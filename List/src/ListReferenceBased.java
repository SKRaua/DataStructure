
/**
 * Implementations of operations a linked list.
 * @author Qi Wang
 * @version 1.0
 */
public class ListReferenceBased implements ListInterface{
	/**
	 * A reference to an array of data
	 */
	private Node head;
	
	/**
	 * The number of data in this ADT list
	 */
	private int count;
	
	/**
	 * Creates an empty linked list.
	 */
	public ListReferenceBased(){
		this.head = null;
	    this.count = 0;
	}
	 /**
	  * Determines whether a list is empty. 
	  * @return A boolean value specifying if this list is empty or not
	  */
	  public boolean isEmpty(){
		  return this.count == 0;
	  }
	  
	  /**
	   * Returns the size of a list. 
	   * @return An integer specifying the size of a list
	   */
	  public int size(){
		  return this.count;
	  }
	  
	  /**
	   * Adds an element to the list at position index.
	   * @param index The position of this added element
	   * @param element A reference to this added element
	   * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
	   */
	  public void add(int index, Object data) throws ListIndexOutOfBoundsException{
		  if(index < 0 || index > this.size()){
			  throw new ListIndexOutOfBoundsException("The index value must be between 0 and " 
		                               + (this.count -1));
		  }else{
			  //Empty list
			  // - front, middle, and end are the same
			  //One node list
			  // - front or end
			  //Multi-node list( two nodes or more)
			  // - front, middle, end
			  
			  if(this.head == null){//Empty list 
				  this.head = new Node(data, null);
			  }else if(this.size() == 1){// One-node list
				  if(index == 0){ 
					  // front
					  this.head = new Node(data, this.head);
				  }else if(index == this.size()){  
					  // end
					  this.head.setNext(new Node(data, null));
				  }
			  }else{ // a multi-node ist
				  if(index == 0){ // front
					  this.head = new Node(data, this.head);
				  }else if(index == this.size()){ // end
					  //find the very last node
					  Node current = find(index -1);
					  current.setNext(new Node(data, null));
				  }else{ // middle
					  //Find the node prior to the node at index
					  Node current = find(index-1);
					  //Insert the node at the font of the node at index
					  current.setNext(new Node(data, current.getNext()));
				  }
			  }
		 
		      this.count++;
	  }
	} 
	  
	  /**
	   * Returns a reference to a specific node at index.
	   * @return The index of a specific node
	   */
	  private Node find(int index){
		  int position = 0;
		  Node current = this.head;
		  while(position != index){
			  position++;
			  current = current.getNext();
		  }
		 return current;
	  }
	  
	  /**
	   * Adds an element to the end of the list.
	   * @param element A reference to this added element
	   */
	  public void add(Object element) {
			add(size(),element);
	  }
	 
	  /**
	   * Removes an element by position.
	   * @param index An integer specifying the position of the removed element
	   * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
	   * @throws ListException if the list is empty
	   */
	  public void remove(int index)  throws ListIndexOutOfBoundsException, ListException{
		  //One node list
		  // - Remove all.
		  //Multi-node list( two nodes or more)
		  // - front, middle, end
		  
		  if(this.count == 0){
			  throw new ListException("The list is empty");
		  }else if(index < 0 || index > this.size() - 1){
			  throw new ListIndexOutOfBoundsException("The index value must be between 0 and " + (this.count -1));
		  }else if(this.count == 1){  // one node list
			  this.removeAll();
		  }else{                      // multi-node list
			  if(index == 0){ //front
				  Node temp = this.head;
				  this.head = this.head.getNext();
				  temp.setNext(null); // return it to the system.
			  }else if(index == this.count - 1){ // end
				  Node secondLastNode = find(this.count - 2);
				  secondLastNode.setNext(null);;
			  }else{ //middle
				  Node temp = find(index);
				  Node predecessor = find(index - 1);
				  predecessor.setNext(temp.getNext());
				  temp.setNext(null);
			  }
		  }
	      this.count--;
	  }
	  
	  /**
	   * Removes all items in a list.
	   * @throws ListException if the list is empty
	   */
	 public void removeAll() throws ListException{
		  if(this.count == 0){
			  throw new ListException("The list is empty");
		  }else{
			  this.head = null;
			  this.count = 0;
		  }
	  }
	  
	 /** 
	  * Returns an element by position.
	  * @param index An integer specifying the position of the element
	  * @return An object specifying the retrieved element 
	  * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
	  * @throws ListException if the list is empty
	  */
	  public Object get(int index) throws ListIndexOutOfBoundsException, ListException{
		  if(this.count == 0){
			  throw new ListException("The list is empty");
		  }else if(index < 0 || index > this.size()){
			  throw new ListIndexOutOfBoundsException("The index value must be between 0 and 9.");
		  }else{
              // return an items at index from this list.
			  return find(index).getElement();
		  }
	  }
}



