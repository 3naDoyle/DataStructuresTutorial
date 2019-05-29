package execute;

import dataStructures.ArrayQueue;
import dataStructures.Queue;

public class TestCircleArrayQueue {

	public static void main(String[] args) {
		
		Queue<String> arQ = new ArrayQueue<String>();  //interface & type
		
		System.out.println("Empty ? "+arQ.isEmpty());
		
		arQ.enqueue("Triona");
		arQ.enqueue("Mary");
		arQ.enqueue("Ed");
		arQ.enqueue("Dave");
		arQ.enqueue("Steve");
		arQ.enqueue("Tara");
		arQ.enqueue("John");
		arQ.enqueue("Colm");
		arQ.enqueue("Linda");
		System.out.println("Value Removed"+arQ.dequeue());
		System.out.println("Value Removed"+arQ.dequeue());
		
		System.out.println("Size = "+arQ.size());
		
		arQ.enqueue("Matt");
		arQ.enqueue("James");
		System.out.println("Size = "+arQ.size());
		
		arQ.enqueue("Conor");
		arQ.enqueue("name");
		
		System.out.println("Removed value "+arQ.dequeue());
		
		arQ.enqueue("Magic!");

	}

}
