package notification;

/**
 * CommunicationStrategy is an abstract class that defines the preferred strategy for the alerts.
 * Subclasses will implement the envoyer method to send the message through the right canal.
 */
abstract interface CommunicationStrategy {
    /**
     * This method prints an alert on the screen
     * to the chosen client, at the chosen address, with a given message.
     * @param clientName the client who will receive the message
     * @param adresse address of said client.
     * @param message the message to be printed in the alarm.
     */
    public abstract void envoyer(String clientName, String adresse, String message);

    /**
     * This method checks if the address is correct.
     * A non-default implementation is provided only in the SmsCommunication class.
     * @param adresse the address to check.
     * @return true if the address is correct, false otherwise.
     */
    public default boolean isCorrect(String adresse){
        return true;
    }
}
