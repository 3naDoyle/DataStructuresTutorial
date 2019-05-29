package dataStructures;

public class LinkedQueue<E> implements Queue<E> {

	private List<E> linkedQ = new LinkedList<E>();
	
	@Override
	public boolean isEmpty() {
		if (linkedQ.size()==0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public int size() {

		return linkedQ.size();
	}

	@Override
	public void clear() {
		linkedQ.clear();
		
	}

	@Override
	public void enqueue(E element) { // add element
		// TODO Auto-generated method stub
		if ((linkedQ.isEmpty())==true){  //
			
			linkedQ.add(0,element);
			
		}
		else{
			
			linkedQ.add(linkedQ.size(),element);
		}
		
	}

	@Override
	public E dequeue() {  
	if (linkedQ.isEmpty()==true){
		System.out.print("Err: Cannot perform dequeue(): Queue is EMPTY: Null Value returned");//remove element
		return null;
	}
	
	else{
		return linkedQ.remove(0); //removes from O index and returns removed value (using remove() function from linked list	
	}
		
	}

	 public String toString() {  //added toString() 
		 
		return linkedQ.toString();
		 
	 }
	 
	 }

