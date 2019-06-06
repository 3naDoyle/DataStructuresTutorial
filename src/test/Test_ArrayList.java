/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.ArrayList;
import dataStructures.List;
import execute.TestArrayList;

/**
 * @author tdoyle
 *
 */
class Test_ArrayList {
	List<Integer> testList_int = new ArrayList<Integer>();
	List<String> testList_string = new ArrayList<String>();


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		
	}

	@Test
	void instanciateWithSpecifiedSize() {	
		//default (not empty) 
		testList_int = new ArrayList();
		assertFalse(testList_int.isEmpty());

		int initialSize=1;
		testList_int = new ArrayList(initialSize);
		assertFalse(testList_int.isEmpty());
		assertEquals(1, testList_int.size());

		initialSize=10;
		testList_int = new ArrayList(initialSize);
		assertFalse(testList_int.isEmpty());
		assertEquals(10, testList_int.size());	

		//out-size
		initialSize=1000000;
		testList_int = new ArrayList(initialSize);
		assertFalse(testList_int.isEmpty());
		assertEquals(1000000, testList_int.size());

		//zero initial size
		initialSize=0;
		testList_int = new ArrayList(initialSize);
		assertEquals(0, testList_int.size());
		assertTrue(testList_int.size()==0);
		assertTrue(testList_int.isEmpty());
		
		//negative initial-size -> throws illegal exception
		int negSize=-5;
		 assertThrows(IllegalArgumentException.class, () -> {			 
			 testList_int = new ArrayList(negSize);
			 });	
	}
	
	
	@Test
	void testAddElement() {	
		int arr_size = testList_string.size();
		String value = "Silly String";
		
		//assert array contains the added value
		testList_string.add(value);
		assertTrue(testList_string.contains(value));
		
		//assert size of array has increase by 1
		arr_size++;
		assertEquals(arr_size, testList_string.size());
		
		//assert value has been added to END of array
		assertEquals(testList_string.indexOf("Silly String"),arr_size-1);	
		
		//assert value is added to specific index
		value = "Joke book";
		int index = 3;
		testList_string.add(index,value);
		assertEquals(index,testList_string.indexOf(value));
		
		//assert out-of-bounds exception when index > size
		 assertThrows(IndexOutOfBoundsException.class, () -> {			 
				testList_string.add(25,"test value");
			 });		
		
	}
	
	
	void testRemoveElement() {	
		
	}


}
