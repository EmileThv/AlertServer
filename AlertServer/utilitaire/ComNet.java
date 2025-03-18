package utilitaire;

/**
 * This class was discovered by a developer in the
 * utility package. It is used to send messages through ComNet
 *
 */
public class ComNet {

    /**
     * Sends a message through ComNet
     * with a given login. ( Currently just prints
     * "*-Comnet" to the screen )
     * @param login login info of the user to send the alert to
     * @param message content of the alert to send
     */
public void send (String login,String message){
    System.out.print("*-ComNet ");
}
}
