package module04.chapter21.trees.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Demonstration of interface Iterator. 
 * @author Tony Gaddis and Qi Wang
 * @version 1.0
 */
public class IteratorInterfaceDemo {
	/**
	 * Creates an array list and displays the elements in order.
	 * @param array The array to sort
	 */
	public static void main(String[] args){
        List<String> names = new ArrayList<String>();
        
        //Add three elements into the array list.
        names.add("Anna");
        names.add("Bob");
        names.add("Carlos");
        
        // Get the iterator of the array list.
        Iterator<String>  it = names.iterator();
        
        // Iterate the list and display the elements.
        while (it.hasNext()){
            System.out.println(it.next());
            // The most recently returned element from next call is removed. 
            it.remove();
        }
        
        //No more elements. 
        System.out.println(it.hasNext());
        
        //The size of the array list is 0 if remove is called. 
        System.out.println(names.size());
	}
}
