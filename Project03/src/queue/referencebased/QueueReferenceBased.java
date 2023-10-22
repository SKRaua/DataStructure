package queue.referencebased;

/**
 * An implementation of ADT Queue with a circular linked list with one external reference
 * to the last node. 
 * @author Qi Wang
 * @version 1.0
 */
public class QueueReferenceBased<E> implements QueueInterface<E> {
	  /**
	   * The reference to the last node of this queue
	   */
	  private Node<E> lastNode;

	  /**
	   * Constructs a queue with no nodes. 
	   */
	  public QueueReferenceBased() {
	    this.lastNode = null;
	  }

	  /**
	   * Determines whether a queue is empty.
	   * Precondition: None.
	   * Postcondition: Returns true if the queue is empty; otherwise returns false.
	   * @return A boolean value specifying if this queue is empty
	   */
	  public boolean isEmpty() {
	    return this.lastNode == null;
	  }
	  
	  /**
	   * Adds an item at the back of a queue.
	   * Precondition: newItem is the item to be inserted.
	   * Postcondition: If the operation was successful, newItem is at the back of the queue. 
	   * Some implementations may throw QueueException if newItem cannot be added to the queue.
	   * @param newItem A reference to the new item to be added
	   */
	  public void enqueue(E newItem) {
		  Node<E> newNode = new Node<E>(newItem);

		    // insert the new node
		    if (isEmpty()) {
		      // insertion into empty queue
		      newNode.setNext(newNode);
		    } else {
		      // insertion into nonempty queue
		      newNode.setNext(this.lastNode.getNext());
		      this.lastNode.setNext(newNode);
		    }  

		    this.lastNode = newNode;  // new node is at back
		  } 

	  /**
       * Retrieves and removes the front of a queue.
       * Precondition: None.
       * Postcondition: If the queue is not empty, the item that was added to the queue earliest is returned and
       * the item is removed. If the queue is empty, the operation is impossible and QueueException is thrown.
       * @return A reference to the item that was added to the queue earliest
       * @throws QueueException If the queue is empty, the operation is impossible and QueueException is thrown.
       */
	  public E dequeue() throws QueueException {
		    if (!isEmpty()) {
		      // queue is not empty; remove front
		    	Node<E> firstNode = lastNode.getNext();
		      
		      //Special case: one node in queue
		      if (firstNode == this.lastNode) {
		        this.lastNode = null;          
		      } else {
		        this.lastNode.setNext(firstNode.getNext());
		        
		        // detach the first node from the queue
		        // return first node to the system
		        firstNode.setNext(null);
		      } 
		      
		      return firstNode.getItem();
		      
		    } else {
		      throw new QueueException("QueueException on dequeue:"  + "queue empty");
		    } 
		  } 
	  
	  /**
	   * Removes all items of a queue.
	   * Precondition: None.
	   * Postcondition: The queue is empty.
	   */
	  public void dequeueAll() {
	    this.lastNode = null;
	  } 

	 
	  /**
	   * Retrieves the item at the front of a queue.
	   * Precondition: None.
	   * Postcondition: If the queue is not empty, the item that was added to the queue earliest is returned.
	   * If the queue is empty, the operation is impossible and QueueException is thrown.
	   * @return A reference to the item that was added to the queue earliest 
	   * @throws QueueException if the queue is empty, the operation is impossible
	   */
	  public E peek() throws QueueException {
	    if (!isEmpty()) {
	      // queue is not empty; retrieve front
	    	Node<E> firstNode = this.lastNode.getNext();
	      return firstNode.getItem();
	    }
	    else {
	      throw new QueueException("QueueException on peek:"  + "queue empty");
	    }
	  }
	}
