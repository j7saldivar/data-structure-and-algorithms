package com.algorithms.binarytree;

class BinaryTreeApp {

	BinaryTreeApp() {}
	
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();
		binaryTree.addNode(50, "Boss");

		binaryTree.addNode(25, "Vice");
		binaryTree.addNode(15, "Office Manager");
		binaryTree.addNode(30, "Secretary");
		binaryTree.addNode(75, "Sales Manager");
		binaryTree.addNode(85, "Salesman");

		System.out.println("In Order Traversal:");
		binaryTree.inOrderTraverseTree(binaryTree.root);
		
		System.out.println("\nPre Order Traversal:");
		binaryTree.preOrderTraverseTree(binaryTree.root);
		
		System.out.println("\nPost Order Traversal:");
		binaryTree.postOrderTraverseTree(binaryTree.root);
		
		
		System.out.println("\nFind 30: \n" + binaryTree.findNode(30));
		
	}

}