package com.sda.lists;

public class SdaLinkedList {

	private SdaLinkedNode head, lastNode;

	public SdaLinkedList(String value) {
		this.head = new SdaLinkedNode(value);
		lastNode = head;
	}

	public void add(String value) {
		SdaLinkedNode newNode = new SdaLinkedNode(value);
		if (head == null) {
			head = newNode;
			lastNode = head;
		} else {
			lastNode.next = newNode;
			lastNode = newNode;
		}
	}

	public String get(int index) throws IndexOutOfBoundsException {
		String returnedValue;
		SdaLinkedNode current;
		if (index < 0 || index >= size())
			throw new IndexOutOfBoundsException("Tried to get non existent elemeent");
		if (index == 0) {
			returnedValue = head.value;
		} else {
			current = head;
			int indexCounter = 0;
			while (current.next != null && indexCounter != index) {
				current = current.next;
				indexCounter++;
			}
			returnedValue = current.value;
		}
		return returnedValue;
	}

	public void removeAll(String value) {
		SdaLinkedNode tmpNode = head;
		while (tmpNode.next != null) {
			if (tmpNode.next.value.equals(value)) {
				if (tmpNode.next.next != null) {
					tmpNode.next = tmpNode.next.next;
				} else {
					tmpNode.next = null;
				}
			} else {
				tmpNode = tmpNode.next;
			}
		}
		if (head.value.equals(value)) {
			head = head.next;
		}
	}

	public boolean remove(String value) {
		SdaLinkedNode tmpNode = head;
		boolean isRemoved = false;
		if (head.value.equals(value)) {
			head = head.next;
			isRemoved = true;
		} else {
			while (tmpNode.next != null && !isRemoved) {
				if (tmpNode.next.value.equals(value)) {
					isRemoved = true;
					if (tmpNode.next.next != null) {
						tmpNode.next = tmpNode.next.next;
					} else {
						tmpNode.next = null;
					}
				} else {
					tmpNode = tmpNode.next;
				}
			}
		}
		return isRemoved;
	}

	public int size() {
		int size = 1;
		SdaLinkedNode tmpNode = head;
		while (tmpNode.next != null) {
			size++;
			tmpNode = tmpNode.next;
		}
		return size;
	}

	private static class SdaLinkedNode {

		private String value;
		private SdaLinkedNode next;

		public SdaLinkedNode(String value) {
			next = null;
			this.value = value;
		}
	}

}
