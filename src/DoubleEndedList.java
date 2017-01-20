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

		if (!isEmpty()) {

			if (first == last) {
				first = null;
				last = null;
			} else {
				first.next.previous = null;
				first = first.next;
			}

		}

	}

	public void removeLast() {

		if (!isEmpty()) {

			if (first == last) {
				first = null;
				last = null;
			} else {
				last.previous.next = null;
				last = last.previous;
			}

		}

	}

	public void removeRecord(String name) {

		SNode previous = null;
		SNode current = first;

		while (!current.name.equalsIgnoreCase(name)) {

			if (current.next == null) {
				return;
			}

			previous = current;
			current = current.next;

		}

		if (current == last) {

			last = current.previous;
			current.previous = previous;

		} else if (current == first) {
			
			first = current.next;
			current.next.previous = null;
			
		} else if (current.next != null) {

			previous.next = current.next;
			current.next.previous = previous;

		} else {

			last = current.previous;

		}

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
		doubleEndedList.addFirstPosition("B");

		System.out.println("Display forward:");
		doubleEndedList.displayForwards();

		System.out.println("\nDisplay backwards:");
		doubleEndedList.displayBackwards();

		System.out.println("\nDisplay backwards again:");
		doubleEndedList.addFirstPosition("A");
		doubleEndedList.addLastPosition("Z");
		doubleEndedList.displayBackwards();

		System.out.println("\nRemove 2 last and 1 first");
		doubleEndedList.removeLast();
		doubleEndedList.removeLast();
		doubleEndedList.removeFirst();
		doubleEndedList.removeFirst();
		doubleEndedList.removeRecord("C");
		doubleEndedList.removeRecord("B");
		doubleEndedList.addFirstPosition("A");
		doubleEndedList.displayBackwards();
	}

}
