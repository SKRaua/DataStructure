import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import ADTClassDatabase.ClassDatabase;
import ADTClassDatabase.ClassSection;

/**
 * Tests the design of binary search tree
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class Test {
    public static void start() throws FileNotFoundException {
        // Create an empty class database, list.
        ClassDatabase list = new ClassDatabase();

        // Pass list to create that fills list with class sections*.
        create(list);

        System.out.println("Arrange the class sections from small to large: ");
        // Pass list to display that prints the class sections in list.
        display(list);

        // Tests methods in ADTClassDatabase.
        testADTClassDatabase(list);
    }

    /**
     * Creates the class section list by reading a input file
     * 
     * @param list The class section list
     * @throws FileNotFoundException "classSections.txt" can't be found
     */
    public static void create(ClassDatabase list) throws FileNotFoundException {
        Scanner input = new Scanner(new File("classSections.txt"));

        // Reads every class sections in the input file.
        while (input.hasNextLine()) {
            // Constructs a string tokenizer for each class section with a delim "\t".
            StringTokenizer tokenizer = new StringTokenizer(input.nextLine(), "\t", false);
            // Creates and add a instance with attributes from the tokenizer
            // of a class section to the list.
            int classNumber = Integer.parseInt(tokenizer.nextToken());
            String courseSubject = tokenizer.nextToken();
            int catalogNumber = Integer.parseInt(tokenizer.nextToken());
            String classTitle = tokenizer.nextToken();
            String level = tokenizer.nextToken();
            list.insert(new ClassSection(classNumber, courseSubject, catalogNumber, classTitle, level));
        }
    }

    /**
     * Displays the class sections in the list.
     * 
     * @param list The class section list
     */
    public static void display(ClassDatabase list) {
        LinkedList<ClassSection> sortedList = list.sort();
        for (ClassSection classSection : sortedList) {
            System.out.print(classSection.getClassNumber() + " ");
        }
        System.out.println();
        System.out.println();
    }

    public static void testADTClassDatabase(ClassDatabase list) {
        System.out.println("The number of class sections in the list: " + list.number());
        System.out.println();
        System.out.println("The class section with class number 9797: ");
        ClassSection class9797 = list.search(9797);
        System.out.println(
                "course subject: " + class9797.getCourseSubject() + " catalog number: " + class9797.getCatalogNumber()
                        + " class title: " + class9797.getClassTitle() + " level: " + class9797.getLevel());

        System.out.println();

        System.out.println("Deletes a leaf node class section 2349.");
        list.delete(2349);
        display(list);
        System.out.println("Deletes a class section 2345, it has two sub nodes.");
        list.delete(2345);
        display(list);
        System.out.println("Deletes a class section 4321, it has one sub node.");
        list.delete(4321);
        display(list);
        System.out.println("Deletes the root node class section 7122.");
        list.delete(7122);
        display(list);

        System.out.println("Is the list empty: " + list.isEmpty());
        System.out.println("Makes the list empty.");
        list.makeEmpty();
        System.out.println("Is the list empty: " + list.isEmpty());
    }
}
