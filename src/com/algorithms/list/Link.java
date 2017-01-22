package com.algorithms.list;

class Link {

	String name;
	Link next;
	Link previous;

	Link(String name) {
		this.name = name;
	}

	void display() {
		System.out.println("Name: " + name); 
	}

}

