package stack.referencebased;

/**
 * Implementations of common operations of a stack. 
 * @author Qi Wang
 * @version 1.0
 */
public class StackReferenceBased<E> implements StackInterface<E> {
	/** 
	 * The top of this stack
	 */
	private Node<E> top;

	/**
	 * Constructs an empty stack.
	 */
	public StackReferenceBased(){
		this.top = null;
	}
	/**
	* Determines whether the stack is empty.
	* Precondition: None.
	* Postcondition: Returns true if the stack is empty; otherwise returns false.
	* @return A boolean value specifying if this stack is empty
	*/
	public boolean isEmpty() {
		return this.top == null;
	}
	

	/**
	* Adds an item to the top of a stack.
	* Precondition: item is the item to be added.
	* Postcondition: If insertion is successful, newItem is on the top of the stack.
	* @param item The item to be added to the stack
	*/
	public void push(E item) {
		this.top = new Node<E>(item, this.top);
	}
	 /**
	* Removes the top of a stack.
	* Precondition: None.
	* Postcondition: If the stack is not empty, the item that was added most recently is removed
	*                from the stack and returned.
	* @return The item that was most recently added to this stack
	* @throws StackException If the stack is empty.
	*/
	public E pop() throws StackException {
		if(!isEmpty()){
		   Node<E> temp = this.top;
		 this.top = this.top.getNext();
		 temp.setNext(null);
		 E item = temp.getItem();
		 temp = null;
		 return item;
		}else{
			throw new StackException("The stack is empty!");
		}
	}
	
	/**
	* Removes all the items from the stack.
	* Precondition: None.
	* Postcondition: Stack is empty.
	*/	
	public void popAll() throws StackException { 
		if(!isEmpty()){
			this.top = null;
		}else{
			throw new StackException("The stack is empty!");
		}
	} 
	
	/**
	* Retrieves the top of a stack.
	* Precondition: None.
	* Postcondition: If the stack is not empty, the item that was added most recently is returned. 
	* The stack is unchanged.
	* @return The item that was added most recently
	* @throws StackException Throws StackException if the stack is empty.
	*/
	public E peek() throws StackException {
		if(!isEmpty()){
	        return this.top.getItem();
	    }else{
		    throw new StackException("The stack is empty!");
	    }
	}
}