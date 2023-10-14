import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Test class for LinkedString
 * 
 * @author XinyangZhou
 * @version 1.0
 */
public class Test {

    /**
     * Starts testing the LinkedString class.
     * 
     * @throws FileNotFoundException File not found
     */
    public static void start() throws FileNotFoundException {

        // Creates an empty array list.
        ArrayList<LinkedString> array = new ArrayList<>();
        // Fills the list.
        create(array);
        // Prints the list
        display(array);
        // Other tests
        otherTests(array);
    }

    /**
     * Creates a ArrayList by reading a items file.
     * 
     * @param array The ArrayList array
     * @throws FileNotFoundException File not found
     */
    public static void create(ArrayList<LinkedString> array) throws FileNotFoundException {
        Scanner input = new Scanner(new File("items.txt"));
        // Reads the next token from the input file
        while (input.hasNextLine()) {
            // Creates a linked string from the input and add it to the array list.
            array.add(new LinkedString(input.nextLine()));
        }
        // Makes a few linked strings and add them into the array list.
        array.add(new LinkedString());
        array.add(new LinkedString());
        char[] characters = { 'a', 'b', 'c', 'd' };
        array.add(new LinkedString(characters));

        // Tests the concat method and subString method.
        LinkedString firstName = new LinkedString("Xinyang");
        LinkedString lastName = new LinkedString("Zhou");
        LinkedString name = firstName.concat(lastName);
        LinkedString subName = name.subString(7, 10);
        array.add(subName);
        array.add(name);
        array.add(firstName);
        array.add(lastName);

        input.close();
    }

    /**
     * Displays the items in the array.
     * 
     * @param array The ArrayList array
     */
    public static void display(ArrayList<LinkedString> array) {
        // Display/print the linked strings from the list.
        // Note: This will test toString method.
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }

    /**
     * Tests other methods in LinkedString class.
     * 
     * @param array The ArrayList array
     */
    public static void otherTests(ArrayList<LinkedString> array) {
        // charAt
        System.out.println("The third char in the first string: " + array.get(0).charAt(2));
        // System.out.println(array.get(0).charAt(10));// Exception

        // isEmpty
        System.out.println("The first string is empty: " + array.get(0).isEmpty());
        System.out.println("The 21th string is empty: " + array.get(20).isEmpty());

        // length
        System.out.println("The length of the first string: " + array.get(0).length());

    }
}
