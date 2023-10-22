package stack.referencebased;

/**
 * Represents a node for a linked list of objects.
 * @author Qi Wang
 * @version 1.0
 */
public class Node<E> {
	/**
	 * The data of this node
	 */
	private E item;
	/**
	 * The link to next node
	 */
	private Node<E> next;
	
	/**
	 * Constructs a default node.
	 */
	public Node(){
		this(null, null);
	}  
	/**
	 * Constructs a node with an item and link to a null node.
	 * @param item A reference to this data of this node
	 */
	public Node(E item) {
		this(item, null);
	}  
	/**
	 * Constructs a node with an item and a link to next node.
	 * @param item A reference to this data of this node
	 */
	public Node(E item, Node<E> next) {
		this.item = item;
		this.next = next;
    }
	/**
	 * Returns the value of this node.
	 * @return the item of this node
	 */
	public E getItem() {
		return this.item;
	}
	/**
	 * Changes the item of this node.
	 * @param item the item to set
	 */
	public void setItem(E item) {
		this.item = item;
	}
	/**
	 * Returns the reference to the next node. 
	 * @return A reference to the next node
	 */
	public Node<E> getNext() {
		return this.next;
	}
	/**
	 * Changes the next node of this node.
	 * @param next A reference to the next to set
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}  


