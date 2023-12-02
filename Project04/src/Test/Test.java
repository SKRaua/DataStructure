package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

import ADTBinarySearchTree.BinarySearchTree;
import ADTBinarySearchTree.TreeIterator;
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
        // Create an empty class database and an empty binary search tree.
        ClassDatabase list = new ClassDatabase();
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Pass list to create that fills list with class sections.
        create(list, tree);

        // Tests methods in ADTClassDatabase.
        testADTClassDatabase(list);

        // Tests the iterator of the binary search tree.
        // Most other BinarySearchTree methods have been tested in testADTClassDatabase.
        testTreeIterator(tree);
    }

    /**
     * Creates the class section list by reading a input file
     * 
     * @param list The class section list
     * @param tree A binary search tree
     * 
     * @throws FileNotFoundException "classSections.txt" can't be found
     */
    public static void create(ClassDatabase list, BinarySearchTree<Integer> tree) throws FileNotFoundException {
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
            // Tests insert().
            list.insert(new ClassSection(classNumber, courseSubject, catalogNumber, classTitle, level));
            tree.insert(classNumber);
        }
    }

    /**
     * Displays the class sections in the list.
     * 
     * @param list The class section list
     */
    public static void display(ClassDatabase list) {
        // Sorts the list.
        LinkedList<ClassSection> sortedList = list.sort();

        System.out.printf("%-13s %-15s %-15s %-36s %-10s%n",
                "Class Number", "Course Subject", "Catalog Number", "Class Title", "Level");
        for (ClassSection classSection : sortedList) {
            System.out.printf("%-13s %-15s %-15s %-36s %-10s%n",
                    classSection.getClassNumber(),
                    classSection.getCourseSubject(),
                    classSection.getCatalogNumber(),
                    classSection.getClassTitle(),
                    classSection.getLevel());
        }
        // Tests number().
        System.out.println("Number of class sections: " + list.number());
        System.out.println();
    }

    /**
     * Tests the ADTClassDatabase.
     * 
     * @param list The class section list
     */
    public static void testADTClassDatabase(ClassDatabase list) {
        System.out.println("Tests the ADTClassDatabase: ");

        // Tests sort(), number().
        System.out.println("Arrange the class sections from small to large: ");
        display(list);

        // Tests search().
        System.out.println("Is the class section with class number 9797 in this list: " + list.search(9797));
        System.out.println("Is the class section with class number 0001 in this list: " + list.search(0001));
        System.out.println();

        // Tests delete(). (Deletes elements at different positions.)
        System.out.println("Deletes a leaf node class section 2349.");
        list.delete(2349);
        display(list);
        System.out.println("Deletes a class section 4321, it has one sub node.");
        list.delete(4321);
        display(list);
        System.out.println("Deletes the root node class section 7122.(It has two sub nodes)");
        list.delete(7122);
        display(list);

        // Tests isEmpty(), makeEmpty().
        System.out.println("Is the list empty: " + list.isEmpty());
        System.out.println("Makes the list empty.");
        list.makeEmpty();
        System.out.println("Is the list empty: " + list.isEmpty());
        display(list);
    }

    /**
     * Tests the iterator of the binary search tree.
     * 
     * @param tree A binary search tree
     */
    public static void testTreeIterator(BinarySearchTree<Integer> tree) {
        TreeIterator<Integer> iterator = tree.iterator();
        System.out.println("Test the iterator of the binary search tree: ");
        iterator.setInorder();
        System.out.print("Inorder: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator.setPostorder();
        System.out.print("Postorder: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        iterator.setPreorder();
        System.out.print("Preorder: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
