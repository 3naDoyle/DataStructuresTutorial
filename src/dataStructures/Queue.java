package dataStructures;

/**
 * @author Triona Doyle
 *
 */
public interface Queue<E>{

    public boolean isEmpty();
    
    public int size();
    
    public void clear();
    
    public void enqueue(E element);
    
    public E dequeue();
}