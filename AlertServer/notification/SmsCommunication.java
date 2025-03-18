package notification;

/** SMSCommunication is one of the four subclasses for CommunicationStrategy.
 *  It's chosen when 'SMS' is chosen as the communication receiving mode.
 */
class SmsCommunication implements CommunicationStrategy{

    /**
     * This method prints an alert on the screen
     * to the chosen client, at the chosen adress, with a given message.
     * @param clientName the client who will receive the message
     * @param adresse address of said client.
     * @param message the message to be printed in the alarm.
     */
    public void envoyer(String clientName, String adresse, String message) {
        String rendu = "";
        rendu += "[SMS (";
        rendu += adresse;
        rendu += ") -> ";
        rendu += clientName;
        rendu += "] ";
        rendu += message;
        System.out.println(rendu);
    }

    @Override
    /**
     * This method is a non-default implementation of the isCorrect method.
     * It checks the given phone number against a Regex pattern.
     * And returns true if it matches, false otherwise.
     * @param adresse the phone number to check.
     * @return true if the phone number is correct, false otherwise.
     */
    public boolean isCorrect(String adresse) {
        return adresse.matches("^0[67]\\d{8}$");
    }
}
