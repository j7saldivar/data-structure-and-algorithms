
public class BinaryTree {

	Node root;

	public void addNode(int key, String name) {

		Node newNode = new Node(key, name);

		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;

			while (true) {
				parent = focusNode;

				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;

					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;

					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}

	}

	public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);

		}

	}

	public void preOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);

		}

	}
	
	public void postOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
			
		}

	}
	
	public Node findNode(int key) {
		
		Node focusNode = root;
		
		while(focusNode.key != key) {
			
			if (key < focusNode.key) {
				
				focusNode = focusNode.leftChild;
				
			} else {
				
				focusNode = focusNode.rightChild;
				
			}
			
			if(focusNode == null)
				return null;
			
		}
		
		return focusNode;
		
	}

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