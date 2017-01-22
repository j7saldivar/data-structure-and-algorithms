package com.algorithms.stackqueue;

class StackApp {

	static final String FIRST = "First";
	static final String SECOND = "Second";
	static final String THIRD = "Third";
	static final String FOURTH = "Fourth";
	static final String FIFTH = "Fifth";
	static final String SIXTH = "Sixth";
	
	StackApp() {}
	
	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		System.out.println("Is empty: " + stack.isEmpty());
		
		stack.delete();	
		
		stack.insert(FIRST);
		stack.insert(SECOND);
		stack.insert(THIRD);
		stack.insert(FOURTH);
		stack.insert(FIFTH);
		stack.insert(SIXTH);
		stack.display();
		
		stack.delete();	
		stack.delete();	
		stack.insert(SIXTH);
		
		stack.display();
		System.out.println("Is empty: " + stack.isEmpty());
		
		stack.delete();	
		stack.delete();	
		stack.delete();	
		stack.delete();	
		System.out.println("Is empty: " + stack.isEmpty());
		
	}
	
}
