package queue.referencebased;

/**
 * Represents an exception that is thrown when queue operations such as enqueue, dequeue, and peek, fail. 
 */
public class QueueException extends RuntimeException {

	  /**
	   * Constructs a queue exception with a specified message. 
	   * @param message A string literal specifying the message of this queue exception
	   */
	  public QueueException(String message) {
	    super(message);
	  }
}
