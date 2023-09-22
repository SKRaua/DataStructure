/**
 * ArrayFullException class
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class ArrayFullException extends IndexOutOfBoundsException {

    /**
     * A constructor of ArrayFullException with a message.
     * 
     * @param message The message of the ArrayFullException
     */
    public ArrayFullException(String message) {
        // Call super constructor with the parameter message.
        super(message);
    }
}
