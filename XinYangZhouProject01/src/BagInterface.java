/**
 * The BagInterface class of the ADTBag
 * 
 * @author XinYang Zhou
 * @version 1.0
 */
public interface BagInterface {
    /**
     * Add an item to the end of the list of this bag.
     * 
     * @param item An item to add
     */
    public void insert(Object item);

    /**
     * Remove the item at the end of this bag.
     */
    public void removeLast();

    /**
     * Remove an item at a random index from this bag.
     */
    public void removeRandom();

    /**
     * Get the index of the first occurrence of an item from this bag.
     * 
     * @param item The item to obtain index
     * @return the index of the item
     */
    public int get(Object item);

    /**
     * Get a reference to an item at position index of this bag.
     * 
     * @param index The item's index
     * @return the item
     */
    public Object get(int index);

    /**
     * Return the number of items in this bag.
     * 
     * @return The number of items
     */
    public int size();

    /**
     * Check if this bag is empty.
     * 
     * @return If this bag is empty
     */
    public boolean isEmpty();

    /**
     * Empty this bag.
     */
    public void makeEmpty();
}
