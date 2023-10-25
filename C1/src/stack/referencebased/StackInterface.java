package stack.referencebased;

/**
 * Specifications of common operations of a stack. 
 * @author Qi Wang
 * @version 1.0
 */
public interface StackInterface<E> {
	  /**
	   * Determines whether the stack is empty.
	   * Precondition: None.
	   * Postcondition: Returns true if the stack is empty; otherwise returns false.
	   * @return A boolean value specifying if this stack is empty
	   */
	  public boolean isEmpty();
	 	 
	  /**
	   * Adds an item to the top of a stack.
	   * Precondition: item is the item to be added.
	   * Postcondition: If insertion is successful, newItem is on the top of the stack.
	   * @param newItem The item to be added to the stack
	   */
	  public void push(E item);
	  
      /**
       * Removes the top of a stack.
       * Precondition: None.
       * Postcondition: If the stack is not empty, the item that was added most recently is removed
       *                from the stack and returned.
       * @return The item that was most recently added to this stack
       * @throws StackException If the stack is empty.
       */
	  public E pop() throws StackException;
	  
	  /**
	   * Removes all the items from the stack.
	   * Precondition: None.
	   * Postcondition: Stack is empty.
	   * @throws StackException If the stack is empty.
	   */
	  public void popAll() throws StackException;;
	 
	  /**
	   * Retrieves the top of a stack.
	   * Precondition: None.
	   * Postcondition: If the stack is not empty, the item that was added most recently is returned. 
	   * The stack is unchanged.
	   * @return The item that was added most recently
	   * @throws StackException If the stack is empty.
	   */
	  public E peek() throws StackException;
	}

	
