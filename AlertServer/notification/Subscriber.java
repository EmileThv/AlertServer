package notification;

/** This class is used to represent a subscriber of the alert system.
 *  It contains the subscriber's attributes, and offers methods to the Server class.
  */
class Subscriber {
    // The subscriber's name
    private String nom;
    // The subscriber's communication mode
    private String mode;
    // The subscriber's address
    private String adresse;
    // CommunicationStrategy object used in alert sending,
    // initialized in the constructor, according to the given mode

    /**
     * Constructor for the Subscriber class.
     * It is built according to defensive programmation principle.
     * @param nom the subscriber's name
     * @param mode the subscriber's communication mode ("SMS" or "MAIL")
     * @param adr the subscriber's adress
     */
    public Subscriber(String nom, String mode, String adr){
        if(nom == null || nom.length()==0 ){
            System.err.println("Nom invalide");
        } else {
            this.nom = nom;
        }
        if(mode == null || mode.length()==0){
            System.err.println("Mode invalide");
        } else {
            this.mode = mode;
        }
        if(adr == null || adr.length()==0 ){
            System.err.println("Nom invalide");
        } else {
            this.adresse = adr;
        }
        // We check if the mode and strategy are coherent ( either "Mail" and MailCommunication or "SMS" and SMSCommunication)
    }

    /**
     * Gets the name of the subscriber
     * @return nom the name of the subscriber
     */
    public String getNom(){return this.nom;}

    /**
     * Gets the mode of the subscriber
     * @return mode the mode of the subscriber
     */
    public String getMode(){return this.mode;}

    /**
     * Gets the address of the subscriber
     * @return adresse the address of the subscriber
     */
    public String getAdresse(){return this.adresse;}


}
