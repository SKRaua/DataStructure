package ExpressionEvaluator;

import java.util.ArrayList;

/**
 * The generic stack class using an ArrayList
 * 
 * @author Xinyang Zhou
 * @version 1.0
 */
public class GenericStack<E> implements GenericStackInterfere<E> {

    /**
     * The array to store the stack
     */
    private ArrayList<E> list;

    /**
     * Constructs a empty stack.
     */
    public GenericStack() {
        list = new ArrayList<E>();
    }

    /**
     * Adds an element to the top of a stack.
     * 
     * @param element An element to be added
     */
    public void push(E element) {
        list.add(element);
    }

    /**
     * Removes the top of a stack.
     * 
     * @return The element that was most recently added to this stack
     * @throws StackException If the stack is empty.
     */
    public E pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        } else {
            E top = list.get(this.size() - 1);
            list.remove(this.size() - 1);
            return top;
        }
    }

    /**
     * Removes all the elements from the stack.
     * 
     * @throws StackException If the stack is empty.
     */
    public void popAll() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        } else {
            // Clears all items in the array.
            list.clear();
        }
    }

    /**
     * Returns a reference to the top element of a stack.
     * 
     * @return A reference to the element that was added most recently
     * @throws StackException If the stack is empty.
     */
    public E peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("The stack is empty");
        } else {
            // The element that was added most recently
            return list.get(this.size() - 1);
        }

    }

    /**
     * Determines whether the stack is empty.
     * 
     * @return A boolean value specifying if this stack is empty
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Returns the size of the stack.
     * 
     * @return the size of the stack
     */
    public int size() {
        return this.list.size();
    }
}