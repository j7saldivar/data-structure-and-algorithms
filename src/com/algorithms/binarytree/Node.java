package com.algorithms.binarytree;

class Node {

	int key;
	String name;

	Node leftChild;
	Node rightChild;

	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", name=" + name + "]";
	}

}