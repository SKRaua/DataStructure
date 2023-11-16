package ADTClassDatabase;

import java.util.LinkedList;

import ADTBinarySearchTree.BinarySearchTree;
import ADTBinarySearchTree.TreeIterator;

/**
 * The ClassDatabase class of the ADTClassDatabase
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class ClassDatabase implements ClassDatabaseInterface {

    /**
     * The class sections
     */
    private BinarySearchTree<ClassSection> classSections;

    /**
     * The total number
     */
    private int number;

    /**
     * Creates a default ClassDatabase.
     */
    public ClassDatabase() {
        classSections = new BinarySearchTree<ClassSection>();
        number = 0;
    }

    /**
     * Creates a ClassDatabase with a root class.
     * 
     * @param rootClass The root of the binary search tree
     */
    public ClassDatabase(ClassSection rootClass) {
        classSections = new BinarySearchTree<ClassSection>(rootClass);
        number = 1;
    }

    /**
     * Insets a new class section.
     * 
     * @param newClassSection The new class section to insert
     */
    public void insert(ClassSection newClassSection) {
        classSections.insert(newClassSection);
        number++;
    }

    /**
     * Deletes a specific class section.
     * 
     * @param classNumber The class number of the class section to be deleted
     */
    public void delete(int classNumber) {
        ClassSection theClassSection = new ClassSection(classNumber);
        classSections.delete(theClassSection);
        number--;
    }

    /**
     * Searches the class section
     * 
     * @param classNumber the class number to search
     * @return The class with the class number
     */
    public ClassSection search(int classNumber) {
        ClassSection theClassSection = new ClassSection(classNumber);
        return classSections.search(theClassSection);
    }

    /**
     * Determines if the class sections is empty.
     * 
     * @return if the class sections is empty
     */
    public boolean isEmpty() {
        return classSections.isEmpty();
    }

    /**
     * Removes all nodes from the class sections.
     */
    public void makeEmpty() {
        classSections.makeEmpty();
        number = 0;
    }

    /**
     * Sorts the class sections and return the list.
     * 
     * @return The list of the sorted class sections
     */
    public LinkedList<ClassSection> sort() {
        LinkedList<ClassSection> sortedClassSections = new LinkedList<>();
        TreeIterator<ClassSection> iterator = classSections.iterator();
        iterator.setInorder();
        while (iterator.hasNext()) {
            sortedClassSections.add(iterator.next());
        }
        return sortedClassSections;
    }

    /**
     * Get the total number of class sections
     * 
     * @return The total number
     */
    public int number() {
        return this.number;
    }
}
