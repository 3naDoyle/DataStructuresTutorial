package dataStructures;

/**
 * @author Triona Doyle
 *
 */
public interface Queue<E>{

    public boolean isEmpty();
    
    public int size();
    
    public void clear();
    
    /**
     * adds and element to the queue. 
     * A queue structure adds new entries to the END of the queue
     * 
     * @param E 
     */
    public void enqueue(E element);
    
    
    /**
     * removes and element from the queue. 
     * A queue structure removes elements from the FRONT of the queue
     * 
     * @return E - the removed element
     */
    public E dequeue();
}