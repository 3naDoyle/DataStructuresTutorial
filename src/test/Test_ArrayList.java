/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.ArrayList;
import execute.TestArrayList;

/**
 * @author tdoyle
 *
 */
class Test_ArrayList {
	ArrayList testList;


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
		testList = new ArrayList();
		assertFalse(testList.isEmpty());

		int initialSize=1;
		testList = new ArrayList(initialSize);
		assertFalse(testList.isEmpty());
		assertEquals(1, testList.size());

		initialSize=10;
		testList = new ArrayList(initialSize);
		assertFalse(testList.isEmpty());
		assertEquals(10, testList.size());	

		//out-size
		initialSize=1000000;
		testList = new ArrayList(initialSize);
		assertFalse(testList.isEmpty());
		assertEquals(1000000, testList.size());

		//zero initial size
		initialSize=0;
		testList = new ArrayList(initialSize);
		assertEquals(0, testList.size());
		assertTrue(testList.size()==0);
		assertTrue(testList.isEmpty());
		
		//negative initial-size -> throws illegal exception
		int negSize=-5;
		 assertThrows(IllegalArgumentException.class, () -> {			 
			 testList = new ArrayList(negSize);
			 });	
	}
	
	
	
	

}
