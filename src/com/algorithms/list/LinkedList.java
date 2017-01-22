package com.algorithms.list;

class LinkedList {

	private Link first;

	LinkedList() {}

	boolean isEmpty() {
		return first == null;
	}

	void push(String name) {

		Link link = new Link(name);
		link.next = first;
		first = link;

	}

	Link pop() {

		Link link = first;

		if (!isEmpty()) {
			first = first.next;
		} else {
			System.out.println("Empty List");
		}

		return link;

	}

	void display() {

		Link link = first;

		while (link != null) {

			System.out.print("Name: " + link.name);

			if (link.next != null)
				System.out.println(" - next link: " + link.next.name);
			else {
				System.out.println(" - next link is empty");
			}

			link = link.next;
		}
	}

	Link find(String name) {

		Link link = first;

		if (!isEmpty()) {

			while (!link.name.equalsIgnoreCase(name)) {

				if (link.next == null) {
					System.out.println("Name not found: " + name);
					return null;
				} else {
					link = link.next;
				}

			}

		} else {

			System.out.println("Empty Link");

		}

		System.out.println("Name Found: " + link.name);
		return link;

	}

	Link remove(String name) {

		Link current = first;
		Link previous = first;

		while (!current.name.equalsIgnoreCase(name)) {

			if (current.next == null) {

				return null;

			} else {

				previous = current;
				current = current.next;

			}

		}

		if (current == first) {
			first = first.next;

		} else {
			previous.next = current.next;
		}

		return current;

	}

}
