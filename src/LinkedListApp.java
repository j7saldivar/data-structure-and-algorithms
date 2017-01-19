
public class LinkedListApp {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		System.out.println("List empty: " + linkedList.isEmpty());

		linkedList.push("First Link");
		linkedList.push("Second Link");
		linkedList.push("Third Link");

		linkedList.remove("Third Link");
		linkedList.push("Fourth Link");
		linkedList.pop();
		linkedList.display();

		System.out.println();
		linkedList.find("First Link");
		linkedList.find("Second Link");
		linkedList.find("Third Link");

	}

}

class Link {

	private String name;
	private Link next;

	Link(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Link getNext() {
		return next;
	}

	public void setNext(Link next) {
		this.next = next;
	}

	public void display() {
		System.out.println("Name: " + name);
	}

	@Override
	public String toString() {
		return "Link [name=" + name + "]";
	}

}

class LinkedList {

	private Link firstLink;

	LinkedList() {
		firstLink = null;
	}

	public boolean isEmpty() {
		return (firstLink == null);
	}

	public void push(String name) {

		Link link = new Link(name);
		link.setNext(firstLink);
		firstLink = link;

	}

	public Link pop() {

		Link link = firstLink;

		if (!isEmpty()) {
			firstLink = firstLink.getNext();
		} else {
			System.out.println("Empty List");
		}

		return link;

	}

	public void display() {

		Link link = firstLink;

		while (link != null) {

			System.out.print("Name: " + link.getName());

			if (link.getNext() != null)
				System.out.println(" - next link: " + link.getNext().getName());
			else {
				System.out.println(" - next link is empty");
			}

			link = link.getNext();
		}
	}

	public Link find(String name) {

		Link link = firstLink;

		if (!isEmpty()) {

			while (!link.getName().equalsIgnoreCase(name)) {

				if (link.getNext() == null) {
					System.out.println("Name not found: " + name);
					return null;
				} else {
					link = link.getNext();
				}

			}

		} else {
			System.out.println("Empty Link");
		}

		System.out.println("Name Found: " + link.getName());
		return link;

	}

	public Link remove(String name) {

		Link current = firstLink;
		Link previous = firstLink;

		while (!current.getName().equalsIgnoreCase(name)) {

			if (current.getNext() == null) {

				return null;

			} else {

				previous = current;

				current = current.getNext();

			}

		}

		if (current == firstLink) {

			firstLink = firstLink.getNext();

		} else {
			previous.setNext(current.getNext());
		}

		return current;

	}

}
