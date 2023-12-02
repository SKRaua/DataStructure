package ADTClassDatabase;

import java.util.LinkedList;

/**
 * The ClassDatabase interface of the ADTClassDatabase
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public interface ClassDatabaseInterface {

    /**
     * Insets a new class section.
     * 
     * @param newClassSection The new class section to insert
     */
    public void insert(ClassSection newClassSection);

    /**
     * Deletes a specific class section.
     * 
     * @param theClassSection the class section to be deleted
     */
    public void delete(int classNumber);

    /**
     * Searches the class section
     * 
     * @param classNumber the class number to search
     * @return Is this class present in the classSectionsTree.
     */
    public boolean search(int classNumber);

    /**
     * Determines if the class sections is empty.
     * 
     * @return if the class sections is empty
     */
    public boolean isEmpty();

    /**
     * Removes all nodes from the class sections.
     */
    public void makeEmpty();

    /**
     * Sorts the class sections and return the list.
     * 
     * @return The list of the sorted class sections
     */
    public LinkedList<ClassSection> sort();

    /**
     * Get the total number of class sections
     * 
     * @return The total number
     */
    public int number();
}
