/**
 * BagOutOfBoundsException class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class BagOutOfBoundsException extends IndexOutOfBoundsException {

    /**
     * A constructor of BagOutOfBoundsException with a message.
     * 
     * @param message The message of the BagOutOfBoundsException
     */
    public BagOutOfBoundsException(String message) {
        // Call super constructor with the parameter message.
        super(message);
    }
}
