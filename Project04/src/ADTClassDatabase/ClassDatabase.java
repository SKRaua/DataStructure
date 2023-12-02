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
    private BinarySearchTree<ClassSection> classSectionsTree;

    /**
     * The total number
     */
    private int number;

    /**
     * Creates a default ClassDatabase.
     */
    public ClassDatabase() {
        classSectionsTree = new BinarySearchTree<ClassSection>();
        number = 0;
    }

    /**
     * Creates a ClassDatabase with a root class.
     * 
     * @param rootClass The root of the binary search tree
     */
    public ClassDatabase(ClassSection rootClass) {
        classSectionsTree = new BinarySearchTree<ClassSection>(rootClass);
        number = 1;
    }

    /**
     * Insets a new class section.
     * 
     * @param newClassSection The new class section to insert
     */
    public void insert(ClassSection newClassSection) {
        classSectionsTree.insert(newClassSection);
        number++;
    }

    /**
     * Deletes a specific class section.
     * 
     * @param classNumber The class number of the class section to be deleted
     */
    public void delete(int classNumber) {
        ClassSection theClassSection = new ClassSection(classNumber);
        classSectionsTree.delete(theClassSection);
        number--;
    }

    /**
     * Searches the class section
     * 
     * @param classNumber the class number to search
     * @return Is this class present in the classSectionsTree.
     */
    public boolean search(int classNumber) {
        ClassSection theClassSection = new ClassSection(classNumber);
        return classSectionsTree.search(theClassSection);
    }

    /**
     * Determines if the class sections is empty.
     * 
     * @return if the class sections is empty
     */
    public boolean isEmpty() {
        return classSectionsTree.isEmpty();
    }

    /**
     * Removes all nodes from the class sections.
     */
    public void makeEmpty() {
        classSectionsTree.makeEmpty();
        number = 0;
    }

    /**
     * Sorts the class sections and return the list.
     * 
     * @return The list of the sorted class sections
     */
    public LinkedList<ClassSection> sort() {
        LinkedList<ClassSection> sortedClassSections = new LinkedList<>();
        TreeIterator<ClassSection> iterator = classSectionsTree.iterator();
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
