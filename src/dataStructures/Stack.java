/**
 * 
 */
package dataStructures;

/**
 * @author Triona Doyle
 *
 */
public interface Stack<E>{

    public boolean isEmpty();
    
    public int size();
    
    public void clear();
    
    public void push(E element);
    
    public E pop();
    
    public E peek();
}
