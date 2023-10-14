/**
 * BagException class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class BagException extends RuntimeException {

    /**
     * A constructor of BagException with a message.
     * 
     * @param message The message of the BagException
     */
    public BagException(String message) {
        // Call super constructor with the parameter message.
        super(message);
    }
}