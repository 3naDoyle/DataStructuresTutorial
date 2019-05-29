package dataStructures;

public class LinkedStack<E> implements Stack<E>{

    private final List<E> stack = new LinkedList<E>();
    
    public LinkedStack(){
    }
    
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public void push(E element) {
        stack.add(0, element);
    }

    @Override
    public E pop() {
        return stack.remove(0);
    }

    @Override
    public E peek() {
        return stack.get(0);
    }
}