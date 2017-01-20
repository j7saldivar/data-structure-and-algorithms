package com.algorithms.list;

class DoubleEndedList {

	private List first;
	private List last;

	DoubleEndedList() {}

	public boolean isEmpty() {
		return first == null;
	}

	public void addFirst(String name) {

		List newNode = new List(name);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			first.previous = newNode;
			newNode.next = first;
			first = newNode;
		}

	}

	public void addLast(String name) {

		List newNode = new List(name);

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

		List previous = null;
		List current = first;

		while (!current.name.equalsIgnoreCase(name)) {

			if (current.next == null) {
				return;
			}

			previous = current;
			current = current.next;

		}

		if (current == last) {
			removeLast();
		} else if (current == first) {
			removeFirst();
		} else if (current.next != null) {
			previous.next = current.next;
			current.next.previous = previous;
		} 
		
	}

	public void displayForwards() {

		List firstNode = first;

		while (firstNode != null) {
			firstNode.display();
			firstNode = firstNode.next;
		}

	}

	public void displayBackwards() {

		List lastNode = last;

		while (lastNode != null) {
			lastNode.display();
			lastNode = lastNode.previous;
		}

	}

}
