package notification;
import utilitaire.ComNet;

/** ComNetAdaptor is one of the four subclasses for CommunicationStrategy.
 *  It's chosen when 'CHAT' is chosen as the communication receiving mode.
 */
public class ComNetAdaptator implements CommunicationStrategy{
    private ComNet theCom;

    public ComNetAdaptator(){
        theCom = new ComNet();
    }

    /**
     * This method calls the "send" method of the ComNet class,
     * then prints an alert on the screen
     * to the chosen client, at the chosen adress, with a given message.
     * @param clientName the client who will receive the message
     * @param adresse address of said client.
     * @param message the message to be printed in the alarm.
     */
    public void envoyer(String clientName, String adresse, String message) {
        theCom.send(adresse, message);
        String rendu = "";
        rendu += "[COMNET (";
        rendu += adresse;
        rendu += ") -> ";
        rendu += clientName;
        rendu += "] ";
        rendu += message;
        System.out.println(rendu);
    }

}
