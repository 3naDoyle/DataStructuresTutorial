package dataStructures;

public class ArrayStack<E> implements Stack<E> {

	private List<E> arrStack  = new ArrayList<E>();
	
	
    @Override
    public boolean isEmpty() {
      if(arrStack.size()==0){
    	  return true;
      }
      else {
    	  
    	  return false;
      }
    }

    @Override
    public int size() {
    
        return  arrStack.size();
    }

    @Override
    public void clear() {
       
    	arrStack.clear();
        
    }

    @Override
    public void push(E element) {
       arrStack.add(0,element); //calls super add() method and pushes at index 0 only
        
    }

    @Override
    public E pop() {
       E popedValue = arrStack.remove(0);
    	
        return popedValue;
    }

    @Override
    public E peek() {
    	
    	E peekedElement = arrStack.get(0);
        // TODO Auto-generated method stub
        return peekedElement;
    }
    
 

}
