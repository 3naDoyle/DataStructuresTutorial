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
	List<String> testList_string = new ArrayList<String>(5);


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
		//default (not empty) created with a default size
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
		
		//negative initial-size - throws illegal exception
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
		
		//assert adding a value to ArrayList may not overwrite existing value
		 assertThrows(IllegalAccessError.class, () -> {			 
				testList_string.add(3,"something else");
			 });
		
		
		//assert out-of-bounds exception when index > size
		 assertThrows(IndexOutOfBoundsException.class, () -> {			 
				testList_string.add(25,"test value");
			 });		
		
	}
	
	@Test
	void testRemoveElement() {	
		testList_string = new ArrayList<String>(0);
		testList_string.add("a");
		testList_string.add("stitch");
		testList_string.add("in");
		testList_string.add("time");
		testList_string.add("saves");
		testList_string.add("nine");
		System.out.println(testList_string);
	
		int size_before = testList_string.size();
		int index = testList_string.indexOf("time");
		assertEquals(testList_string.get(3),"time");
		assertTrue(testList_string.contains("time"));
		
		//remove from specific index
		testList_string.remove(index);
		assertFalse(testList_string.contains("time"));
		assertNotEquals(testList_string.get(3),"time");
		assertEquals(testList_string.size(),size_before-1);
		System.out.println(testList_string);
		
		//remove with boolean check
		assertTrue(testList_string.remove("nine"));
		assertFalse(testList_string.contains("nine"));
	
	}
	
	@Test
	void testSet() {
		testList_string = new ArrayList<String>(5);
		testList_string.add(0,"That's");
		testList_string.set(1, "the");
		testList_string.add(2,"life");		
		assertFalse(testList_string.contains("way"));
		//set index 2 
		testList_string.set(2, "way");
		assertTrue(testList_string.contains("way"));
		assertEquals(testList_string.get(2),"way");

		
	}
	
	@Test
	void testClear() {
		testList_string = new ArrayList<String>(10);
		testList_string.add("world");
		testList_string.add("wide");
		testList_string.add("web");
		assertFalse(testList_string.isEmpty());
		//clear
		testList_string.clear();
		assertTrue(testList_string.isEmpty());

	}


}
