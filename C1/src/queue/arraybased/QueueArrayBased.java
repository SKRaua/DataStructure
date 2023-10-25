

/**
 * Implementation of ADT queue with a circular array.
 * @author Qi Wang
 * @version 1.0
 */
public class QueueArrayBased implements QueueInterface<Object> {
	  /**
	   * The maximum size of this queue
	   */
	  private final int MAX_QUEUE = 50;
	  /**
	   * The data structure containing items of this queue
	   */
	  private Object[] items;
	  /**
	   * The index of the first item of this queue
	   */
	  private int front;
	  /**
	   * The index of the next new item of this queue
	   */
	  private int rear;
	  /**
	   * The number of items of this queue
	   */
	  private int count;

	  /**
	   * Constructs a queue with a maximum size of 50. 
	   */
	  public QueueArrayBased() {
	    this.items = new Object[this.MAX_QUEUE];
	    this.front = 0;
	    this.rear = 0;
	    this.count = 0;
	  }

	  /**
	   * Determines whether a queue is empty.
	   * Precondition: None.
	   * Postcondition: Returns true if the queue is empty; otherwise returns false.
	   * @return A boolean value specifying if this queue is empty
	   */
	  public boolean isEmpty() {
	    return this.count == 0;
	  }

	  /**
	   * Determines whether a queue is full.
	   * Precondition: None.
	   * Postcondition: Returns true if the queue is full; otherwise returns false.
	   * @return A boolean value specifying if this queue is full
	   */
	  private boolean isFull() {
	    return this.count == this.MAX_QUEUE;
	  }

	  /**
	   * Adds an item at the back of a queue.
	   * Precondition: item is the item to be inserted.
	   * Postcondition: If the operation was successful, newItem is at the back of the queue. 
	   * Some implementations may throw QueueException if newItem cannot be added to the queue.
	   * @param item A reference to the new item to be added
	   * @throws QueueException if newItem cannot be added to the queue
	   */
	  public void enqueue(Object item) throws QueueException {
	    if (!this.isFull()) {
	    	this.count++;
	    	this.items[this.rear] = item;
	    	this.rear = (this.rear + 1) % this.MAX_QUEUE;
	    } else {
	    	throw new QueueException("QueueException on enqueue: " + "Queue full");
	    }
	  }
	  
      /**
       * Retrieves and removes the front of a queue.
       * Precondition: None.
       * Postcondition: If the queue is not empty, the item that was added to the queue earliest is returned and
       * the item is removed. If the queue is empty, the operation is impossible and QueueException is thrown.
       * @return A reference to the item that was added to the queue earliest
       * @throws QueueException If the queue is empty, the operation is impossible and QueueException is thrown.
       */
	  public Object dequeue() throws QueueException {
	    if (!this.isEmpty()) {
	       this.count--;
	       Object queueFront = this.items[this.front];
	       this.items[this.front] = null;
	       this.front = (this.front + 1) % this.MAX_QUEUE;
	       return queueFront;	       
	    } else {
	       throw new QueueException("QueueException on dequeue: " + "Queue empty");
	    }
	  }
	  
	  /**
	   * Removes all items of a queue.
	   * Precondition: None.
	   * Postcondition: The queue is empty.
       * @throws QueueException If the queue is empty, the operation is impossible and QueueException is thrown.
       */
	  public void dequeueAll() throws QueueException {
		 if(this.isEmpty()){
		    this.items = new Object[this.MAX_QUEUE];
		    this.front = 0;
		    this.rear = 0;
		    this.count = 0;
		  } else {
		      throw new QueueException("QueueException on dequeue: " + "Queue empty");
		  }
	  }

	  /**
	   * Retrieves the item at the front of a queue.
	   * Precondition: None.
	   * Postcondition: If the queue is not empty, the item that was added to the queue earliest is returned.
	   * If the queue is empty, the operation is impossible and QueueException is thrown.
	   * @return A reference to the item that was added to the queue earliest 
	   * @throws QueueException if the queue is empty, the operation is impossible
	   */
	  public Object peek() throws QueueException {
	    if (!this.isEmpty()) {
	      return this.items[this.front];
	    } else {
	      throw new QueueException("Queue exception on peek: " + "Queue empty");
	    }
	  }
	}

