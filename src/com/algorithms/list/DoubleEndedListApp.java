package com.algorithms.list;

class DoubleEndedListApp {
	
	DoubleEndedListApp() {}

	public static void main(String[] args) {

		DoubleEndedList doubleEndedList = new DoubleEndedList();
		doubleEndedList.addFirst("D");
		doubleEndedList.addFirst("C");
		doubleEndedList.addFirst("B");
		doubleEndedList.addFirst("B");

		System.out.println("Display forward:");
		doubleEndedList.displayForwards();

		System.out.println("\nDisplay backwards:");
		doubleEndedList.displayBackwards();

		System.out.println("\nDisplay backwards again:");
		doubleEndedList.addFirst("A");
		doubleEndedList.addLast("Z");
		doubleEndedList.displayBackwards();

		System.out.println("\nRemove 2 last and 1 first");
		doubleEndedList.removeLast();
		doubleEndedList.removeLast();
		doubleEndedList.removeFirst();
		doubleEndedList.removeFirst();
		doubleEndedList.removeRecord("C");
		doubleEndedList.removeRecord("B");
		doubleEndedList.addFirst("B");
		doubleEndedList.addFirst("B");
		doubleEndedList.removeRecord("B");
		
		doubleEndedList.displayBackwards();
	}

}
