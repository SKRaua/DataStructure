
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Helper class for the driver program.
 * 
 * @author Qi Wang
 * @version 1.0
 */
public class Test {
	/**
	 * Tests the reference-based linked list.
	 */
	public static void start() throws FileNotFoundException {
		ListReferenceBased list = new ListReferenceBased();
		// Create a list
		fillList(list);

		// Display a list
		displayList(list);

		// Remove first data
		System.out.println("\nRemoving ...");
		list.remove(1);
		// list.remove(-1);//list.remove(32);
		displayList(list);

		// Remove all of the data
		// list.removeAll();
		// displayList(list);
	}

	/**
	 * Creates a list of charges.
	 * 
	 * @param list A reference to a list of data
	 */
	private static void fillList(ListReferenceBased list) throws FileNotFoundException {
		Scanner input = new Scanner(new File("datalist.txt"));
		// $4.50 $23.56 $2000.98 $0.34
		int i = 0;
		while (input.hasNext()) {
			list.add(i, new Node(input.next()));
			i++;
		}
		input.close();
	}

	/**
	 * Displays data in order.
	 * 
	 * @param list A reference to a list of data
	 */
	private static void displayList(ListReferenceBased list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
