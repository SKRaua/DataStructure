package ExpressionEvaluator;

/**
 * The GenericStackInterfere of the expression evaluator
 * 
 * @author XinYang Zhou
 * @version 1.0
 */
public interface GenericStackInterfere<E> {

    /**
     * Adds an element to the top of a stack.
     * 
     * @param element An element to be added
     */
    public void push(E element);

    /**
     * Removes the top of a stack.
     * 
     * @return The element that was most recently added to this stack
     * @throws StackException If the stack is empty.
     */
    public E pop() throws StackException;

    /**
     * Removes all the elements from the stack.
     * 
     * @throws StackException If the stack is empty.
     */
    public void popAll() throws StackException;

    /**
     * Returns a reference to the top element of a stack.
     * 
     * @return A reference to the element that was added most recently
     * @throws StackException If the stack is empty.
     */
    public E peek() throws StackException;

    /**
     * Determines whether the stack is empty.
     * 
     * @return A boolean value specifying if this stack is empty
     */
    public boolean isEmpty();

    /**
     * Returns the size of the stack.
     * 
     * @return the size of the stack
     */
    public int size();
}
