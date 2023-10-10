

/**
 * Specifications on the design of operations of an ADT list. 
 * @author Qi Wang
 * @version 1.0 
 */
public interface ListInterface {
 /**
  * Determines whether a list is empty. 
  * @return A boolean value specifying if this list is empty or not
  */
  public boolean isEmpty();
  
  /**
   * Returns the length of a list. 
   * @return An integer specifying the length of a list
   */
  public int size();
  
  /**
   * Adds a data to the list at position index.
   * @param index The position of this added data
   * @param data A reference to this added data
   * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
   */
  public void add(int index, Object data) throws ListIndexOutOfBoundsException;
  
  /**
   * Adds an element to the end of the list.
   * @param element A reference to this added element
   */
  public void add(Object element);
 
  /**
   * Removes a data by position.
   * @param index An integer specifying the position of the removed data
   * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
   * @throws ListException If size() is 0
   */
  public void remove(int index)  throws ListIndexOutOfBoundsException, ListException;
  
  /**
   * Removes all items in a list.
   * @throws ListException If size() is 0
   */
  public void removeAll() throws ListException;;
  
  /**
   * Returns a data by position.
   * @param index An integer specifying the position of the data
   * @return An object specifying the retrieved data 
   * @throws ListIndexOutOfBoundsException If index < 0 or index > size()
   * @throws ListException If size() is 0
   */
  public Object get(int index) throws ListIndexOutOfBoundsException,ListException;
} 







