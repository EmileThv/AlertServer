package notification;
import java.util.Map;
import java.util.HashMap;

/**
 * The Server class is most important class in the package. It orchestrates the adding or removal of subscribers,
 * as well as storing all the subscribers and their names. It's also the class responsible of implementing the sending of
 * alerts, using the other package private classes.
 */
public class Server {
    // Hashmap organized with key being subscribers names and values
    // being the Subscriber object. Subscribers names are thus unique.
    private Map<String,Subscriber> abonnements;

    /**
     * Initializes abonnements as an empty Hashmap
     */
    public Server(){
        this.abonnements = new HashMap<String,Subscriber>();
    }

    /**
     * This method is used for adding new clients to the
     * alert list. It strictly follows the defensive programmation principle.
     * @param clientName the future subscriber's name
     * @param mode the future subscriber's mode of communication
     * @param adr the future subscriber's address
     */
    public void adherer(String clientName, String mode, String adr){
        // Check if all parameters given are coherent
        if(clientName == null || mode == null || adr == null
                || clientName.length()==0 || mode.length()==0 || adr.length()==0){
            System.err.println("Parametres invalides");
            return;
        // Check if there are no existing subscribers with the same name
        } else if (abonnements.get(clientName) != null){
            System.err.println("Nom existant");
            return;
        } else {
            // Uses the CommunicationFactory class to fetch the correct CommunicationStrategy
            CommunicationStrategy ComStratAbo = CommunicationFactory.create(mode);
            // Calls the subscriber constructor using the previously obtained CommunicationStrategy object
            if (ComStratAbo.isCorrect(adr)) {
                Subscriber adherent = new Subscriber(clientName, mode, adr);
                CommunicationStrategy strat;
                strat = CommunicationFactory.create(mode);
                CommunicationAccess.setCom(mode, strat);
                // Puts the subscriber in the abonnements map, using the subscriber's name as the key
                this.abonnements.put(clientName, adherent);
            } else { System.out.println("adresse non correcte"); }
        }
    }

    /**
     * Removes a previously added subscriber
     * @param clientName The name of the subscriber to be removed
     */
    public void retirer(String clientName){
        // Checks if the subscriber exists
        if(abonnements.get(clientName) != null){
            this.abonnements.remove(clientName);
        } else {
            System.err.println("Client non existant");
        }
    }

    /**
     * Method used to send an alert to every single subscriber,
     * using the previously chosen mode of communication.
     * This method follows the defensive programmation principles.
     * @param message the message to send in the alert.
     */
    public void alerter(String message){
        // Check if the message if correct
        if(message != null && message.length() > 0){
            // for each subscriber in abonnements
            for(Subscriber client : abonnements.values()){
                CommunicationAccess.getCom(client.getMode()).envoyer(client.getNom(),client.getAdresse(),message);
            }
        } else {
            System.err.println("Message invalide");
        }
    }

    /**
     * This method is used to get a list of subscribers
     * in a standardized return format
     * @return res The string array containing a String with all the info for every subscriber.
     */
    public String[] getListeInscrits(){
        String[] res = new String[abonnements.size()];
        int index = 0;
        for(Subscriber client : abonnements.values()){
            String ret = "";
            ret += client.getNom();
            ret += " ";
            ret += client.getAdresse();
            ret += " (";
            ret += client.getMode();
            ret += ")";
            res[index] = ret;
            index ++;
        }
        return res;
    }
}
