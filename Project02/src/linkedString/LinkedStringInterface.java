package linkedString;

/**
 * The interface of the LinkedString class
 * 
 * @author XinyangZhou
 * @version 1.0
 */
public interface LinkedStringInterface {

    /**
     * Returns the char at the index.
     * 
     * @param index The index of the char
     * @return The char at the index
     */
    public char charAt(int index);

    /**
     * concats two strings.
     * 
     * @param stringToConcat String concatenated after
     * @return The string after concat
     */
    public LinkedString concat(LinkedString stringToConcat);

    /**
     * Returns if the string is empty.
     * 
     * @return A boolean value specifying if this string is empty
     */
    public boolean isEmpty();

    /**
     * Returns the length of the string.
     * 
     * @return The length of the string
     */
    public int length();

    /**
     * Returns a portion of a string
     * 
     * @param startIndex The start index of the subString
     * @param endIndex   The end index of the subString
     * @return A portion of a string
     */
    public LinkedString subString(int startIndex, int endIndex);
}
