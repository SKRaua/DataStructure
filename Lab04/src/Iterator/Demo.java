package Iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iterator Demo
 * 
 * @author XinYang Zhou
 * @version 1.0
 */
public class Demo {

    /**
     * Creates an array list and displays the elements in order.
     * 
     * @param array The array to sort
     */
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        // Adds elements.
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        // Gets the iterator.
        Iterator<Integer> it = nums.iterator();

        // Iterate the list and display the elements.
        while (it.hasNext()) {
            System.out.println(it.next());
            // Removes the "next()" just got
            it.remove();
        }

        // No elements.
        System.out.println(it.hasNext());

        // Size: 0.
        System.out.println(nums.size());
    }
}
