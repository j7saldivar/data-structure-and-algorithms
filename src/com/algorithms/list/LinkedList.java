package com.algorithms.list;

class LinkedList {

	private List first;

	LinkedList() {}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String name) {

		List link = new List(name);
		link.next = first;
		first = link;

	}

	public List pop() {

		List link = first;

		if (!isEmpty()) {
			first = first.next;
		} else {
			System.out.println("Empty List");
		}

		return link;

	}

	public void display() {

		List link = first;

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

	public List find(String name) {

		List link = first;

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

	public List remove(String name) {

		List current = first;
		List previous = first;

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
