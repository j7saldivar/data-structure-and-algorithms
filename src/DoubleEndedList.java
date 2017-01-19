class SNode {

	String name;
	SNode next;
	SNode previous;

	SNode(String name) {
		this.name = name;
	}

	public void display() {
		System.out.println("Name: " + name);
	}
}

public class DoubleEndedList {

	SNode first;
	SNode last;

	public DoubleEndedList() {
		first = null;
		last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void addFirstPosition(String name) {

		SNode newNode = new SNode(name);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			first.previous = newNode;
			newNode.next = first;
			first = newNode;
		}

	}
	
	public void addLastPosition(String name) {

		SNode newNode = new SNode(name);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
			last = newNode;
		}

	}
	
	public void removeFirst() {
		
	}
	
	public void removeLast() {
		
	}
	
	public void removeRecord() {
		
	}
	
	public void displayForwards() {
		
		SNode firstNode = first; 
		
		while (firstNode != null) {
			firstNode.display();
			firstNode = firstNode.next;
		}
		
	}
	
public void displayBackwards() {
		
		SNode lastNode = last; 
		
		while (lastNode != null) {
			lastNode.display();
			lastNode = lastNode.previous;
		}
		
	}

	public static void main(String[] args) {
		
		DoubleEndedList doubleEndedList = new DoubleEndedList(); 
		doubleEndedList.addFirstPosition("D");
		doubleEndedList.addFirstPosition("C");
		doubleEndedList.addFirstPosition("B");
		
		System.out.println("Display forward:");
		doubleEndedList.displayForwards();
	
		System.out.println("\nDisplay backwards:");
		doubleEndedList.displayBackwards();
		
		System.out.println("\nDisplay backwards again:");
		doubleEndedList.addFirstPosition("A");
		doubleEndedList.addLastPosition("Z");
		doubleEndedList.displayBackwards();
	}

}
