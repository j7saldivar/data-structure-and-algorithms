package com.algorithms.stackqueue;

class QueueApp {

	static final String FIRST = "First";
	static final String SECOND = "Second";
	static final String THIRD = "Third";
	static final String FOURTH = "Fourth";
	static final String FIFTH = "Fifth";
	static final String SIXTH = "Sixth";

	QueueApp() {
	}

	public static void main(String[] args) {

		Queue queue = new Queue(5);
		System.out.println("Is empty: " + queue.isEmpty());

		queue.delete();

		queue.insert(FIRST);
		queue.insert(SECOND);
		queue.insert(THIRD);
		queue.insert(FOURTH);
		queue.insert(FIFTH);
		queue.insert(SIXTH);
		queue.display();

		queue.delete();
		queue.delete();
		queue.insert(SIXTH);

		queue.display();
		System.out.println("Is empty: " + queue.isEmpty());

		queue.delete();
		queue.delete();
		queue.delete();
		queue.delete();
		System.out.println("Is empty: " + queue.isEmpty());

	}
}
