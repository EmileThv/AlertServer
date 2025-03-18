package notification;

/** MailCommunication is one of the four subclasses for CommunicationStrategy.
 *  It's chosen when 'MAIL' is chosen as the communication receiving mode.
 */
class MailCommunication implements CommunicationStrategy {
    /**
     * This method prints an alert on the screen
     * to the chosen client, at the chosen address, with a given message.
     * @param clientName the client who will receive the message
     * @param adresse address of said client.
     * @param message the message to be printed in the alarm.
     */
    public void envoyer(String clientName, String adresse, String message){
        String rendu = "";
        rendu += "[MAIL (";
        rendu += adresse;
        rendu += ") -> ";
        rendu += clientName;
        rendu += "] ";
        rendu += message;
        System.out.println(rendu);
    }
}
