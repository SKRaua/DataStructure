import java.util.Random;

/**
 * The BagArrayBased class of the ADTBag
 * 
 * @author XinYang Zhou
 * @version 1.0
 */
public class BagArrayBased implements BagInterface {
    /**
     * The list to store datas
     */
    private Object[] bag;

    /**
     * The size of the bag
     */
    private int size;

    /**
     * The MAXNUM of the bag
     */
    private final int MAXNUM = 100;

    /**
     * Create an empty bag that can hold up to 100 items.
     */
    public BagArrayBased() {
        bag = new Object[MAXNUM];
        size = 0;
    }

    /**
     * Add an item to the end of the list of this bag.
     * 
     * @param item An item to add
     */
    public void insert(Object item) {
        try {
            if (size < MAXNUM) {
                // Add an item.
                bag[size] = item;
                size++;
            } else {
                throw new BagOutOfBoundsException("Array is full.");
            }
        } catch (BagOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }

    }

    /**
     * Remove the item at the end of this bag.
     */
    public void removeLast() {
        try {
            if (size != 0) {
                // Remove the item.
                bag[size - 1] = null;
                size--;
            } else {
                throw new NoItemsException("There are no items in the array.");
            }
        } catch (NoItemsException e) {
            e.printStackTrace();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    /**
     * Remove an item at a random index from this bag.
     */
    public void removeRandom() {
        try {
            if (size != 0) {
                Random ran = new Random();
                // the index of the item
                int index = ran.nextInt(size);
                // Remove the item.
                bag[index] = null;
                // Move the following items forward.
                for (int i = index; i < size; i++) {
                    bag[i] = bag[i + 1];
                }
                size--;
            } else {
                throw new NoItemsException("There are no items in the array.");
            }
        } catch (NoItemsException e) {
            e.printStackTrace();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
        }
    }

    /**
     * Get the index of the first occurrence of an item from this bag.
     * 
     * @param item The item to obtain index
     * @return the index of the item
     */
    public int get(Object item) {
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                // Find this item in the bag.
                if (bag[i].equals(item)) {
                    return i;
                }
            }
            // Item not found.
            return -1;
        } else {
            return -1;
        }
    }

    /**
     * Get a reference to an item at position index of this bag.
     * 
     * @param index The item's index
     * @return the item
     */
    public Object get(int index) {
        return bag[index];
    }

    /**
     * Return the number of items in this bag.
     * 
     * @return The number of items
     */
    public int size() {
        return size;
    }

    /**
     * Check if this bag is empty.
     * 
     * @return If this bag is empty
     */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Empty this bag.
     */
    public void makeEmpty() {
        bag = new Object[MAXNUM];
        size = 0;
    }
}
