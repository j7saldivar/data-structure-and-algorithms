package com.algorithms.list;

class LinkedListApp {

	static final String FIRST = "First";
	static final String SECOND = "Second";
	static final String THIRD = "Third";
	static final String FOURTH = "Fourth";
	static final String FIFTH = "Fifth";
	
	LinkedListApp() {
	}
	
	public static void main(String[] args) {

		LinkedList linkedList = new LinkedList();
		
		System.out.println("List empty: " + linkedList.isEmpty()); 

		//Insert records
		linkedList.push(FIRST);
		linkedList.push(SECOND);
		linkedList.push(THIRD);
		linkedList.display();
		System.out.println();
		
		//Remove first (using key) and insert new record
		linkedList.remove(FIRST);
		linkedList.push(FOURTH);
		linkedList.display();
		System.out.println();
		
		//Remove first
		linkedList.pop();
		linkedList.display();
		System.out.println();
		
		linkedList.find(FIRST);
		linkedList.find(SECOND);
		linkedList.find(THIRD);

	}

}
