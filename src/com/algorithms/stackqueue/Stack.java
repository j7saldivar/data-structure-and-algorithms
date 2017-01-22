package com.algorithms.stackqueue;

import java.util.Arrays;

class Stack {

	String[] stack;
	int size;
	int stackTop;

	Stack(int size) {
		this.size = size;
		stack = new String[size];
		Arrays.fill(stack, "empty");
		stackTop = -1;
	}
	
	boolean isEmpty() {
		return stackTop == -1;
	}

	void insert(String value) {

		if (stackTop + 1 < size) {
			stack[++stackTop] = value;
		} else {
			System.out.println("Stack is full");
		}

	}

	void delete() {

		if (!isEmpty()) {
			stack[stackTop--] = "empty";
		} else {
			System.out.println("Stack is empty");
		}

	}
	
	void display() {
		
		System.out.print("| ");
		for(int i = 0; i < stack.length; i++) {
			System.out.print(stack[i] + " | ");
		}
		System.out.println();
		
	}
	
	

}
