package dataStructures;

//import com.doyle.triona.Queue;

public class ArrayQueue<E> implements Queue<E> {
	
	E[] Q;
	int setsize;
	int f; //front index
	int r; //rear index
	int size;
	
	@SuppressWarnings("unchecked")
	public
	ArrayQueue(){
		
		setsize=10;
		Q = (E[])new Object[setsize];
		size=0;
	}
	

	@Override
	public boolean isEmpty() {
		if (size()==0){
			return true;
		}
			
		else{
			return false;
		}
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void clear() {
		
		for(int i=0; i<Q.length; i++){
			Q[i]=null;
		}
		size=0;
		System.out.println("All Elements have been removed from queue");
	}

	@Override
	public void enqueue(E element) {
		
		if(size()==(Q.length-1)){
			
			System.out.println("Increasing array size");
			ensureCapacity(); 
		}
		
		Q[r]=element;
		
		r=(r+1)%(Q.length);
		
		System.out.println("Values in Queue");
		for(int i=0;i<Q.length;i++){
			
			System.out.println("Values at index "+i+" is "+Q[i]);
		}
		
		
		
		size++;
		
		System.out.println("Front = "+Q[f]);
		System.out.println("Rear = "+Q[r]);
		
	}

	@Override
	public E dequeue() {
		
		E removed = Q[f];
		Q[f]=null;
		f=(f+1)%(Q.length);
		
		size--;
		return removed;
	}
	
	private void ensureCapacity() {
		@SuppressWarnings("unchecked")
		E[] Q2 =(E[])new Object[Q.length*2]; //create new array and double the size
		
		System.out.println("VALUE at Q[f] old array = "+Q[f]);
		
		
		for(int i=0;i<Q.length;i++){
			
		
			Q2[i]= Q[f];  //Set index 0 of new array to front value of old array -
			System.out.println("New ARRAY --> index "+i+" is "+Q2[i]);
			dequeue();  //remove value from old array - to recalculate the position of the next value for writing to new array
			
			//size=i; //reset size to 
			r=i;
		}
		
		
		System.out.println("size"+size());
		f=0; //front of new array at index zero
	
		Q=Q2; // return values to original array
		
		
    }


}
