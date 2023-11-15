package ADTClassDatabase;

/**
 * A class section
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class ClassSection implements Comparable<ClassSection> {

    /**
     * The class number
     */
    private int classNumber;

    /**
     * The course subject
     */
    private String courseSubject;

    /**
     * The catalog number
     */
    private int catalogNumber;

    /**
     * The class title
     */
    private String classTitle;

    /**
     * The level of the class
     */
    private String level;

    /**
     * Creates a class section with a class number.
     * 
     * @param classNumber
     */
    public ClassSection(int classNumber) {
        this(classNumber, null, 0, null, null);
    }

    /**
     * Creates a class section with all information
     * 
     * @param classNumber   The class number
     * @param courseSubject The course subject
     * @param catalogNumber The catalog number
     * @param classTitle    The class title
     * @param level         The level of the class
     */
    public ClassSection(int classNumber, String courseSubject, int catalogNumber, String classTitle, String level) {
        this.classNumber = classNumber;
        this.courseSubject = courseSubject;
        this.catalogNumber = catalogNumber;
        this.classTitle = classTitle;
        this.level = level;
    }

    /**
     * Compares the class number of the two classes
     * 
     * @param otherClassSection other ClassSection to Compare
     * @return The difference between two class numbers
     */
    public int compareTo(ClassSection otherClassSection) {
        return this.classNumber - otherClassSection.classNumber;
    }

    /**
     * Gets the class number
     * 
     * @return The class number
     */
    public int getClassNumber() {
        return this.classNumber;
    }

    /**
     * Gets the course subject
     * 
     * @return The course subject
     */
    public String getCourseSubject() {
        return this.courseSubject;
    }

    /**
     * Gets the catalog number
     * 
     * @return The catalog number
     */
    public int getCatalogNumber() {
        return this.catalogNumber;
    }

    /**
     * Gets the class title
     * 
     * @return The class title
     */
    public String getClassTitle() {
        return this.classTitle;
    }

    /**
     * Gets the level
     * 
     * @return The level
     */
    public String getLevel() {
        return this.level;
    }

    /**
     * Sets the course subject
     * 
     * @return The course subject
     */
    public void setCourseSubject(String courseSubject) {
        this.courseSubject = courseSubject;
    }

    /**
     * Sets the catalog number
     * 
     * @return The catalog number
     */
    public void setCatalogNumber(int catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    /**
     * Sets the class title
     * 
     * @return The class title
     */
    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    /**
     * Sets the level
     * 
     * @return The level
     */
    public void setLevel(String level) {
        this.level = level;
    }
}
