package linkedString;

/**
 * The Node class for LinkedString
 * 
 * @author XinyangZhou
 * @version 1.0
 */
public class Node<E> {
    /**
     * The item of the node
     */
    private E item;
    /**
     * The link to next node
     */
    private Node<E> next;
    /**
     * c
     */
    private Node<E> previous;

    /**
     * Constructs a default node.
     */
    public Node() {
        this(null, null, null);
    }

    /**
     * Constructs a node with an item and it's next code.
     * 
     * @param item    The item of the node
     * @param nextThe link to next node
     */
    public Node(E item) {
        this(item, null, null);
    }

    /**
     * Constructs a node with an item and it's next code.
     * 
     * @param item    The item of the node
     * @param nextThe link to next node
     */
    public Node(E item, Node<E> next) {
        this(item, next, null);
    }

    /**
     * Constructs a node with an item and it's next code and previous node.
     * 
     * @param item        The item of the node
     * @param nextThe     link to next node
     * @param previousThe link to previous node
     */
    public Node(E item, Node<E> next, Node<E> previous) {
        this.item = item;
        this.next = next;
        this.previous = previous;
    }

    /**
     * Returns the item of this node.
     * 
     * @return The item of this node
     */
    public E getItem() {
        return this.item;
    }

    /**
     * Changes the item of the node.
     * 
     * @param item The item of the node
     */
    public void setItem(E item) {
        this.item = item;
    }

    /**
     * Returns the next reference of this node.
     * 
     * @return The next reference of this node
     */
    public Node<E> getNext() {
        return this.next;
    }

    /**
     * Changes the next reference of this node.
     * 
     * @param next The next reference of this node
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }

    /**
     * Returns the previous reference of this node.
     * 
     * @return The previous reference of this node
     */
    public Node<E> getPrevious() {
        return this.previous;
    }

    /**
     * Changes the previous reference of this node.
     * 
     * @param previous The previous reference of this node
     */
    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    /**
     * Returns the string of the node's item.
     * 
     * @return The string of the node's item
     */
    public String toString() {
        return getClass().getSimpleName() + ": " + this.item;
    }
}
