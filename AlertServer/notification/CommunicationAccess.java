package notification;
import java.util.HashMap;
import java.util.Map;

/**
 * The CommunicationAccess class is a package private class
 * used to store all the communication strategies as unique instances of their respective classes
 */
class CommunicationAccess {

    private static Map<String,CommunicationStrategy> medias = new HashMap<>();

    /**
     * Private constructor to
     * prevent instantiation of this class
     */
    private  CommunicationAccess(){}

    /**
     * This method is used to add a new communication strategy
     * if the parameter is correct. if the parameter is correct
     * but the class already exists, it will be overwritten
     * @param mode the mode of communication
     * @param comObj the communication strategy object to store
     */
    public static void setCom(String mode, CommunicationStrategy comObj ){
    if(mode == null || mode.length()==0 || comObj == null){
        System.err.println("Parametres invalides");
    } else {
        if((medias.containsKey(mode))){
            medias.remove(mode);
        }
        medias.put(mode,comObj);
    }
    }

    /**
     *  Gets a communication strategy by its mode
     * @param mode the mode of communication
     * @return the communication strategy
     */
    public static CommunicationStrategy getCom(String mode){
        return medias.get(mode);
    }

}
