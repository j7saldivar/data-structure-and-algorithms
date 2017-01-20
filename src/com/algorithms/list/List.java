package com.algorithms.list;

class List {

	String name;
	List next;
	List previous;

	List(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Name: " + name); 
	}

}

