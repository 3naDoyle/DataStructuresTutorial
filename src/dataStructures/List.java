package dataStructures;

//import java.util.Iterator;

/**
 * An ordered collection (also known as a <i>sequence</i>).  The user of this
 * interface has precise control over where in the list each element is
 * inserted.  The user can access elements by their integer index (position in
 * the list), and search for elements in the list.
 * 
 * @author Triona Doyle
 */

public interface List<E>{ // extends Iterable<E> {
	
    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
	public boolean isEmpty();

	 /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
	public int size();
	
    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
	public void clear();
	
    /**
     * Appends the specified element to the end of this list.
     *
     * @param element element to be appended to this list
     */
	public void add(E element);
	
    /**
     * Inserts the specified element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any 
     * subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
	public void add(int index, E element);
	
    /**
     * Removes the first occurrence of the specified element from this
     * list, if it is present. If this list does not contain the element,
     * it is unchanged.
     *
     * @param element element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
	public boolean remove(E element);
	
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed 
     * from the list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	public E remove(int index);
	
    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param element element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
	public boolean contains(E element);
	
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	public E get(int index);
	
    /**
     * Replaces the element at the specified position in this list with the
     * specified element.
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
	public E set(int index, E element);
	
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     *
     * @param element element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
	public int indexOf(E element);
	
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
	//public Iterator<E> iterator(); 

}