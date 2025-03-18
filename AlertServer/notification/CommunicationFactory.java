package notification;

/** The CommunicationFactory is a package private class
 *  used to create the right CommunicationStrategy Object when signing up a new client.
 */
class CommunicationFactory {
    /**
     * Private empty constructor makes it so the class can never be instanciated.
     */
    private CommunicationFactory(){}

    /** This static method create
     *  is used by the Server class in order to instanciate the right CommunicationStrategy when
     *  adding a user.
     * @param mode the client's alert receiving mode
     * @return a CommunicationStrategy of the requested subclass, or null if the given parameter is not correct.
     */
    public static CommunicationStrategy create(String mode){
        if (mode.equals("SMS")) {
            return new SmsCommunication();
        } else if(mode.equals("MAIL")) {
            return new MailCommunication();
        } else if(mode.equals("XMESS")) {
            return new XmessCommunication();
        } else if(mode.equals("CHAT")){
            return new ComNetAdaptator();
        }else return null;
    }
}
