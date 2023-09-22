/**
 * NoItemsException class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class NoItemsException extends RuntimeException {

    /**
     * A constructor of NoItemsException with a message.
     * 
     * @param message The message of the NoItemsException
     */
    public NoItemsException(String message) {
        // Call super constructor with the parameter message.
        super(message);
    }
}