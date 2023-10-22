package stack.arraybased;

/**
 * An implementation of a stack using an array. 
 * @author Qi Wang
 * @version 1.0
 */
public class StackArrayBased implements StackInterface {
	  /** 
	   * The maximum size of this stack
	   */
	  private final int MAX_STACK = 50;
	  /**
	   * The array containing the items of this stack
	   */
	  private Object[] items;
	  /**
	   * The top item of this stack
	   */
	  private int top;
	  
	  /**
	   * Constructs a stack with a maximum size of 50. A stack is emplty when the top value is -1.
	   */
	  public StackArrayBased() {
	    this.items = new Object[this.MAX_STACK];
	    this.top = -1;
	  }
	  
	  /**
	   * Determines whether the stack is empty.
	   * Precondition: None.
	   * Postcondition: Returns true if the stack is empty; otherwise returns false.
	   * @return A boolean value specifying if this stack is empty
	   */
	  public boolean isEmpty() {
	    return this.top < 0;
	  }
	 
	  /**
	   * Adds an item to the top of a stack.
	   * Precondition: newItem is the item to be added.
	   * Postcondition: If insertion is successful, newItem is on the top of the stack.
	   * @param newItem An item to be added
	   * @throws StackException If the stack is full.
	   */
	  public void push(Object item) throws StackException {
	    if (!isFull()) {
	    	this.top++;
	    	this.items[this.top] = item;
	    } else {
	    	throw new StackException("StackException on " +  "push: stack full");
	    }
	  }
	  
	  /**
	   * Determines whether the stack is full.
	   * @return A boolean value specifying if the stack is full
	   */
	  private boolean isFull() {
		    return this.top == this.MAX_STACK - 1;
		  }
	  
      /**
       * Removes the top of a stack.
       * Precondition: None.
       * Postcondition: If the stack is not empty, the item that was added most recently is removed
       *                from the stack and returned.
       * @return The item that was most recently added to this stack
       * @throws StackException If the stack is empty.
       */
	  public Object pop() throws StackException {
		    if (!isEmpty()) {
		      return this.items[this.top--];
		    } else {
		      throw new StackException("StackException on " + "pop: stack empty");
		    }
		  }
	  
	  /**
	   * Removes all the items from the stack.
	   * Precondition: None.
	   * Postcondition: Stack is empty.
	   * @throws StackException If the stack is empty.
	   */
	  public void popAll() throws StackException{
		  if(!isEmpty()){
			  this.items = new Object[MAX_STACK];
			  this.top = -1;
		  }else{
			  throw new StackException("StackException on " + "popAll: stack empty");
		  }
	  }

	  /**
	   * Returns a reference to the top item of a stack.
	   * Precondition: None.
	   * Postcondition: If the stack is not empty, the item that was added most recently is returned. 
	   *                The stack is unchanged.
	   * @return A reference to the item that was added most recently or null if stack is empty
	   * @throws StackException If the stack is empty.
	   */
	  public Object peek() throws StackException {
	    if (!isEmpty()) {
	      return this.items[this.top];
	    }else {
	    	throw new StackException("StackException on " + "peek: stack empty");
	    }
	  }
	} 

	

