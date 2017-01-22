package com.algorithms.list;

class DoubleEndedList {

	private Link first;
	private Link last;

	DoubleEndedList() {}

	boolean isEmpty() {
		return first == null;
	}

	void addFirst(String name) {

		Link newNode = new Link(name);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			first.previous = newNode;
			newNode.next = first;
			first = newNode;
		}

	}

	void addLast(String name) {

		Link newNode = new Link(name);

		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
			last = newNode;
		}

	}

	void removeFirst() {

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

	void removeLast() {

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

	void removeRecord(String name) {

		Link previous = null;
		Link current = first;

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

	void displayForwards() {

		Link firstNode = first;

		while (firstNode != null) {
			firstNode.display();
			firstNode = firstNode.next;
		}

	}

	void displayBackwards() {

		Link lastNode = last;

		while (lastNode != null) {
			lastNode.display();
			lastNode = lastNode.previous;
		}

	}

}
