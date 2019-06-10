package test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import dataStructures.ArrayQueue;

/**
 * @author tdoyle
 *
 */

public class Test_ArrayQueue {

	ArrayQueue arr_queue_string;
	ArrayQueue arr_queue_int;

	@Before
	public void before() {
		arr_queue_string = new ArrayQueue<String>();
		arr_queue_string = new ArrayQueue<String>();
		arr_queue_string.enqueue("A");
		arr_queue_string.enqueue("boy");
		arr_queue_string.enqueue("named");		
		arr_queue_int = new ArrayQueue<Integer>();
		arr_queue_int.enqueue(12345);
	}

	@After
	public void after() {

	}

	
	@Test
	public void testEnqueueAndDequeue() {
		//enqueue
		int initalSize=arr_queue_string.size();
		arr_queue_string.enqueue("Sue");
		//size increased
		initalSize++;
		assertEquals(initalSize,arr_queue_string.size());
		assertEquals("Sue",arr_queue_string.getRearElement());	
		//dequeue
		int queueSize = arr_queue_string.size();
		Object removedElement = arr_queue_string.dequeue();
		assertEquals(queueSize-1, arr_queue_string.size());
		assertEquals("A",removedElement);
		removedElement = arr_queue_string.dequeue();
		assertEquals(queueSize-2, arr_queue_string.size());
		assertEquals("boy",removedElement);
		//after2 dequeues "named" should be the front element
		assertEquals(arr_queue_string.getFrontElement(),"named");				
	}
	
	
	@Test
	public void testSingleElementInArrayQueue() {
		//when only one element exists, the front and rear should be the same
		assertEquals(arr_queue_int.getFrontElement(),arr_queue_int.getRearElement());
	}

}
