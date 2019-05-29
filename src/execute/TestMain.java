//Question 

package execute;

import dataStructures.ArrayQueue;
import dataStructures.ArrayStack;
import dataStructures.LinkedQueue;
import dataStructures.Queue;
import dataStructures.Stack;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
	/*
	 *  Part A - Implement an Array Stack
	 * 
	 */
		//create new array stack
		Stack<String> arrStack1 = new ArrayStack<String>();
		Stack<String> arrStack2 = new ArrayStack<String>();
	
		
		//demonstrate use of all array stack methods
		System.out.println("***** Array Stack *****");
		
		//isEmpty()
		System.out.println("Empty ?? "+arrStack1.isEmpty());
		
		//push() 
		arrStack1.push("A");
		arrStack1.push("B");
		arrStack1.push("C");
		arrStack1.push("D");
		arrStack2.push("E");
		arrStack2.push("F");
		arrStack2.push("G");
		// stack should now have values (top down) C, B, A

		//peek()
		System.out.println("peek at 1st stack = "+ arrStack1.peek());
		System.out.println("peek at 2nd stack = "+ arrStack2.peek());
		
		//pop()
		String poppedValue=arrStack1.pop();
		System.out.println("Pop from 1st Stack= "+poppedValue);
		poppedValue=arrStack2.pop();
		System.out.println("Pop from 1st stack(again)= "+poppedValue);
		
		//size()
		System.out.println("Size of 1st stack is now = "+arrStack1.size());
		System.out.println("size of 2nd stack is now "+arrStack2.size());
		
		//clear
		arrStack1.clear();
		System.out.println("size of 1st stack after clear() is now " +arrStack1.size());
		
		
		 
	/*
	 *  Part A.2 - Implement an linked queue
	 * 
	 */
		Queue<String> lnkQ1 = new LinkedQueue<String>();  //interface & type
		Queue<String> lnkQ2 = new LinkedQueue<String>();
		
		/* INTERFACES for QUEUE
    public void clear();

		 */
		
		 System.out.println("***** Linked Queue *****");
		 
		//isEmpty();
		System.out.println("Queue 1 empty ? "+lnkQ1.isEmpty());
		
		//enqueue(E element);
		lnkQ1.enqueue("ABC");  //add values (to start of queue)
		lnkQ1.enqueue("DEF");
	
		System.out.println("current values of 1st queue are "+lnkQ1.toString());
		
		lnkQ2.enqueue("10");
		lnkQ2.enqueue("9");
		lnkQ2.enqueue("8");
		lnkQ2.enqueue("7");
		System.out.println("Current values of 2nd queue are "+lnkQ2.toString());
		
		
		//size();
		System.out.println("Size of 1st queue is "+lnkQ1.size());
		System.out.println("Size of 1st queue is "+lnkQ2.size());
		
		//dequeue(); 
		System.out.println("Remove 2 Elements from 2nd queue  - the removed values are is "+lnkQ2.dequeue()+" and "+lnkQ2.dequeue());
		System.out.println("Remove Element from 1st queue  - the removed value is "+lnkQ1.dequeue());
		
		System.out.println("Clear elements from 1st queue ");
		lnkQ1.clear();
		System.out.println("size of queue 1 is now "+lnkQ1.size());
		System.out.println("size of queue 2 is now "+lnkQ2.size());
		
		// Test Array Queue

		Queue<String> arrQueue = new ArrayQueue<String>();  //interface & type
		
		System.out.println("Empty ? "+arrQueue.isEmpty());
		
	}//close main

}// close class
