import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * the Test class of the ADTBag
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Test {

    /**
     * start the test
     */
    public static void start() throws FileNotFoundException {
        // Create an empty bag and save the reference.
        Bag bag = new Bag();

        // Pass the reference to create method that fills the bag.
        create(bag);
        // Pass the reference to display method that prints the bag.
        display(bag);

        // Testing for other methods.
        // insert
        bag.insert("Egg");
        display(bag);
        // removeLast
        bag.removeLast();
        display(bag);
        // removeRandom
        bag.removeRandom();
        display(bag);
        // get
        bag.insert("Banana");
        bag.insert("Banana");
        display(bag);
        System.out.println("The index of the first Banana is: " + bag.get("Banana"));
        System.out.println("The item with index 1 is: " + bag.get(1));
        // isEmpty & makeEmpty
        System.out.println("The bag is empty: " + bag.isEmpty());
        bag.makeEmpty();
        System.out.println("The bag is empty: " + bag.isEmpty());
        display(bag);

        // NoItemsException in remove methods
        bag.removeLast();
        bag.removeRandom();
        // ArrayFullException in insert method
        for (int i = 0; i < 101; i++) {
            bag.insert("1");
        }

    }

    /**
     * Create items using data from an input file.
     * 
     * @param bag The bag to store items
     * @throws FileNotFoundException "./XinYangZhouProject01/src/items.txt"
     *                               can't be found
     */
    public static void create(Bag bag) throws FileNotFoundException {
        Scanner input = new Scanner(new File("./XinYangZhouProject01/src/items.txt"));
        // Create items.
        while (input.hasNextLine()) {
            bag.insert(input.nextLine());
        }
    }

    /**
     * Display the items of the bag.
     */
    public static void display(Bag bag) {
        // Display the items.
        for (int i = 0; i < bag.size(); i++) {
            System.out.println(bag.get(i));
        }
        System.out.println("");

    }

}