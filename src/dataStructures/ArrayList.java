package dataStructures;

/**
 * Resizable-array implementation of the <tt>List</tt> interface.  Implements
 * all list operations, and permits all elements, including <tt>null</tt>.
 * 
 * Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
 * the size of the array used to store the elements in the list.  It is always
 * at least as large as the list size.  As elements are added to an ArrayList,
 * its capacity grows automatically.
 *
 * @author Triona Doyle
 */
public class ArrayList<E> implements List<E> {
	
	private E[] data;
	private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param   initialCapacity   the initial capacity of the list
     * @exception IllegalArgumentException if the specified initial capacity
     *            is negative
     */
    @SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity) {
	super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        
        
        this.setSize(initialCapacity); //
        this.data = (E[])new Object[size()];
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public ArrayList() {
    	this(10);
    }
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++){
		    data[i] = null;
	    }
		size = 0;
	}

	@Override
	public void add(E element) {
		add(size, element);
	}

	@Override
	public void add(int index, E element) {
		if (index > size || index < 0)
		    throw new IndexOutOfBoundsException(
			"Index: "+index+", Size: "+size);

		if (index > size)
			ensureCapacity();
		
		System.arraycopy(data, index, data, index + 1, size - index);
		
		data[index] = element;
		size++;
		
	}

	@Override
	public boolean remove(E element) {
		boolean removed = false;
		if (element == null){
            for (int index = 0; index < size; index++){
            	if (data[index] == null) {
            		fastRemove(index);
            		removed = true;
            	}
            }
		}
		else{
	    	for (int index = 0; index < size; index++){
	    		if (element.equals(data[index])) {
	    			fastRemove(index);
	    			removed = true;
	    		}
	    	}
        }
		
		return removed;
	}

	@Override
	public E remove(int index) {
		checkIndex(index);

		E oldValue = data[index];

		int numMoved = size - index - 1;
		if (numMoved > 0)
		    System.arraycopy(data, index+1, data, index, numMoved);
		
		data[--size] = null; // Let gc do its work

		return oldValue;
	}

	@Override
	public boolean contains(E element) {
		return indexOf(element) >= 0;
	}

	@Override
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}

	@Override
	public E set(int index, E element) {
		checkIndex(index);

		E oldValue = (E)data[index];
		data[index] = element;
		
		return oldValue;
	}

	@Override
	public int indexOf(E element){
		int index = -1;
		
		if (element == null) {
		    for (int i = 0; i < size; i++){
		    	if (data[i]==null){
		    		index = i;
		    		break;
		    	}
		    }
		} else {
		    for (int i = 0; i < size; i++){
		    	if (element.equals(data[i])){
		    		index = i;
		    		break;
		    	}
			}
		}
		return index;
	}
	
	public String toString(){
		StringBuffer list = new StringBuffer(); 
		
		list.append("[");
		
		for (int i = 0; i <= size - 2; i++){
			list.append(data[i] + ", ");
		}
		
		list.append( data[size - 1] + "]");
		
		return list.toString();
	}
	
	/**
     * Private remove method that skips bounds checking and does not
     * return the value removed.
     */
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(data, index+1, data, index, numMoved);
        }
        data[--size] = null; // Let gc do its work
    }
	
    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void checkIndex(int index) {
	if (index >= size)
	    throw new IndexOutOfBoundsException(
		"Index: "+index+", Size: "+size);
    }
    
    /**
     * Increases the capacity of this <tt>ArrayList</tt> instance, if
     * necessary, to ensure that it can hold the elements
     */
    private void ensureCapacity() {
		@SuppressWarnings("unchecked")
		E [] newData = (E[])new Object[data.length * 2];
		
		System.arraycopy(data, 0, newData, 0, size);
			
		data = newData;
    }

}