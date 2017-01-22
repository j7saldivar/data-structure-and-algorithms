package com.algorithms.stackqueue;

import java.util.Arrays;

class Queue {

	String[] queue;
	int size;
	int head;
	int tail;
	int itemsQueued;

	Queue(int size) {
		this.size = size;
		queue = new String[size];
		Arrays.fill(queue, "empty");
		head = -1;
		tail = -1;
		itemsQueued = 0;
	}

	boolean isEmpty() {
		return itemsQueued == 0;
	}

	void display() {

		System.out.print("| ");

		for (int i = 0; i < queue.length; i++) {

			if (head == i)
				System.out.print("head - ");

			System.out.print(queue[i]);

			if (tail == i)
				System.out.print(" - tail");

			System.out.print(" | ");

		}

		System.out.println();

	}

	void insert(String value) {

		if (head == -1) {
			head = 0;
		}

		if (itemsQueued + 1 <= size) {

			if (tail + 1 >= size) {
				tail = 0;
			} else {
				tail++;
			}

			queue[tail] = value;
			itemsQueued++;
		} else {
			System.out.println("Queue is full");
		}

	}

	void delete() {

		if (!isEmpty()) {

			queue[head] = "empty";
			itemsQueued--;

			if (head + 1 >= size) {
				head = 0;
			} else {
				head++;
			}

		} else {
			System.out.println("Queue is empty");
		}

	}

}
