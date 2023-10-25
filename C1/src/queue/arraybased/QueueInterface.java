

/**
 * Design of a ADT Queue.
 * @author Qi Wang
 * @version 1.0
 */
public interface QueueInterface<E> {

	  /**
	   * Determines whether a queue is empty.
	   * Precondition: None.
	   * Postcondition: Returns true if the queue is empty; otherwise returns false.
	   * @return A boolean value specifying if this queue is empty
	   */
	  public boolean isEmpty();
	  
	  /**
	   * Adds an item at the back of a queue.
	   * Precondition: item is the item to be inserted.
	   * Postcondition: If the operation was successful, newItem is at the back of the queue. 
	   * Some implementations may throw QueueException if newItem cannot be added to the queue.
	   * @param item A reference to the new item to be added
	   * @throws QueueException if newItem cannot be added to the queue
	   */
	  public void enqueue(E item) throws QueueException;
	  
      /**
       * Retrieves and removes the front of a queue.
       * Precondition: None.
       * Postcondition: If the queue is not empty, the item that was added to the queue earliest is returned and
       * the item is removed. If the queue is empty, the operation is impossible and QueueException is thrown.
       * @return A reference to the item that was added to the queue earliest
       * @throws QueueException If the queue is empty, the operation is impossible and QueueException is thrown.
       */
	  public E dequeue() throws QueueException;
	  
	  /**
	   * Removes all items of a queue.
	   * Precondition: None.
	   * Postcondition: The queue is empty.
       * @throws QueueException If the queue is empty, the operation is impossible and QueueException is thrown.
       */
	  public void dequeueAll() throws QueueException;
 
	  /**
	   * Retrieves the item at the front of a queue.
	   * Precondition: None.
	   * Postcondition: If the queue is not empty, the item that was added to the queue earliest is returned.
	   * If the queue is empty, the operation is impossible and QueueException is thrown.
	   * @return A reference to the item that was added to the queue earliest 
	   * @throws QueueException if the queue is empty, the operation is impossible
	   */
	  public E peek() throws QueueException;
	}
