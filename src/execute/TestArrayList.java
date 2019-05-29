package execute;

import dataStructures.ArrayList;
import dataStructures.LinkedList;
import dataStructures.List;

public class TestArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new LinkedList<String>();
		
		System.out.println("Size = " + list.size());
		System.out.println("Empty = " + list.isEmpty());
		
		
		list.add("Hello");
		System.out.println("Size = " + list.size());
		System.out.println("Empty = " + list.isEmpty());
		System.out.println(list);
		
		list.add("Apple");
		System.out.println("Size = " + list.size());
		System.out.println(list);
		
		list.add("Orange");
		System.out.println("Size = " + list.size());
		System.out.println(list);
		
		list.add(1, "Pear");
		System.out.println("Size = " + list.size());
		System.out.println(list);
		
		list.remove(2);
		System.out.println("Size = " + list.size());
		System.out.println(list);
		
		String i = list.get(2);
		System.out.println("Element at index 1 is " + i);
		System.out.println("Empty = " + list.isEmpty());
		System.out.println("Size = " + list.size());
		System.out.println(list);
		
		int index = list.indexOf("Pear");
		System.out.println("Index of 30 is " + index);
		System.out.println("Empty = " + list.isEmpty());
		System.out.println("Size = " + list.size());
		System.out.println(list);
		
		
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		
		index = list1.indexOf(50);
		System.out.println("Index of 50 is " + index);
		System.out.println("Empty = " + list1.isEmpty());
		System.out.println("Size = " + list1.size());
		System.out.println(list1);
		
		int j = list1.get(1);
		System.out.println(j);
		
		
		
		
		
	/*	
		for (int j = 50; j < 200; j = j + 10){
			list.add(j);
			System.out.println("Size = " + list.size());
			System.out.println(list);
		}
		
	*/	
	}

}