/**
 * Operations of a linked string
 * 
 * @author XinyangZhou
 * @version 1.0
 */
public class LinkedString implements LinkedStringInterface {

    /**
     * The reference node of the head
     */
    private Node<Character> head;

    /**
     * The number of the characters in the Linked string
     */
    private int count;

    /**
     * Constructs a empty linked string.
     */
    public LinkedString() {
        this.head = null;
        this.count = 0;
    }

    /**
     * Constructs a linked string using a char array.
     * 
     * @param characters the char array
     */
    public LinkedString(char[] characters) {
        if (characters.length > 0) {
            // The head of the linked string of the first char in the array.
            this.head = new Node<Character>(characters[0]);
            // The current node
            Node<Character> current = this.head;

            // Traverses character arrays to construct linked String.
            for (int i = 1; i < characters.length; i++) {
                // Instances a new node with the parameter of the previous node(the current),
                // sets the current node's next node using the new node.
                current.setNext(new Node<Character>(characters[i], null, current));
                // Moves the current node to the next position.
                current = current.getNext();
            }
            count = characters.length;
        } else {
            this.head = null;
            this.count = 0;
        }
    }

    /**
     * Constructs a linked string using a string.
     * 
     * @param characters the string
     */
    public LinkedString(String string) {
        if (!string.isEmpty()) {
            // The head of the linked string if the first char in the array.
            this.head = new Node<Character>(string.charAt(0));
            // The current node
            Node<Character> current = this.head;

            // Traverses string to construct linked String.
            for (int i = 1; i < string.length(); i++) {
                // Instances a new node with the parameter of the previous node(the current),
                // sets the current node's next node using the new node.
                current.setNext(new Node<Character>(string.charAt(i), null, current));
                // Moves the current node to the next position.
                current = current.getNext();
                count = string.length();
            }
        } else {
            this.head = null;
            this.count = 0;
        }
    }

    /**
     * Returns the char at the index.
     * 
     * @param index The index of the char
     * @return The char at the index
     */
    public char charAt(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        // The current node
        Node<Character> current = this.head;
        // Counting to find the node corresponding to the index
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        // The char of the node
        return current.getItem();
    }

    /**
     * concats two strings.
     * 
     * @param stringToConcat String concatenated after
     * @return The string after concat
     */
    public LinkedString concat(LinkedString anotherString) {
        // The concatenated string
        LinkedString newLinkedString = new LinkedString();
        // The current node of the new linked string
        Node<Character> newCurrent;
        // The current node of the original linked string
        Node<Character> current = this.head;

        // Sets the item of the head
        newLinkedString.head = new Node<Character>(this.head.getItem(), null, null);
        newCurrent = newLinkedString.head;
        // Copies all characters from the first Linked string to the new Linked string.
        while (current.getNext() != null) {
            // Instances a new node
            // with the parameter of the current node's item and newCurrent(previous node),
            // sets the newCurrent node's next node using the new node.
            newCurrent.setNext(new Node<Character>(current.getNext().getItem(), null, newCurrent));
            // Moves the current node to the next position.
            newCurrent = newCurrent.getNext();
            current = current.getNext();
        }
        // Moves the current node to the head of the another node.
        current = anotherString.head;
        // Copies all characters from the second Linked string to the new Linked string.
        while (current != null) {
            // Instances a new node
            // with the parameter of the current node's item and newCurrent(previous node),
            // sets the newCurrent node's next node using the new node.
            newCurrent.setNext(new Node<Character>(current.getItem(), null, newCurrent));
            // Moves the current node to the next position.
            newCurrent = newCurrent.getNext();
            current = current.getNext();
        }
        newLinkedString.count = this.count + anotherString.count;
        return newLinkedString;
    }

    /**
     * Returns if the string is empty.
     * 
     * @return A boolean value specifying if this string is empty
     */
    public boolean isEmpty() {
        // Is the number of nodes zero.
        return this.count == 0;
    }

    /**
     * Returns the length of the string.
     * 
     * @return The length of the string
     */
    public int length() {
        return this.count;
    };

    /**
     * Returns a portion of a string
     * 
     * @param startIndex The start index of the subString
     * @param endIndex   The end index of the subString
     * @return A portion of a string
     */
    public LinkedString subString(int startIndex, int endIndex) throws IndexOutOfBoundsException {
        if (startIndex < 0 || endIndex >= this.count || startIndex > endIndex) {
            throw new IndexOutOfBoundsException("Invalid startIndex or endIndex.");
        }
        // The subString
        LinkedString newLinkedString = new LinkedString();
        // The current node of the subString
        Node<Character> newCurrent;
        // The current node of the original linked string
        Node<Character> current = this.head;

        // Moves the current node to the start index.
        for (int i = 0; i < startIndex; i++) {
            current = current.getNext();
        }
        // Sets the item of the head.
        newLinkedString.head = new Node<Character>(current.getItem(), null, null);
        newCurrent = newLinkedString.head;
        // Copies characters from the original Linked string to the new Linked string.
        for (int i = startIndex; i < endIndex; i++) {
            // Instances a new node
            // with the parameter of the current node's item and newCurrent(previous node),
            // sets the newCurrent node's next node using the new node.
            newCurrent.setNext(new Node<Character>(current.getNext().getItem(), null, newCurrent));
            // Moves the current node to the next position.
            newCurrent = newCurrent.getNext();
            current = current.getNext();
        }
        count = endIndex - startIndex + 1;
        return newLinkedString;
    }

    /**
     * Returns the string of the linked string.
     * 
     * @return The string of the linked string
     */
    public String toString() {
        // The string of the linked string
        String string = new String();
        // Adds characters from the linked string to the new string.
        Node<Character> current = this.head;
        while (current != null) {
            string += current.getItem();
            current = current.getNext();
        }
        return getClass().getSimpleName() + ": " + string;
    }
}
