package com.sda.lists;

import org.junit.Assert;
import org.junit.Test;

public class SdaLinkedListTest {

	@Test
	/**
	 * Dobrym sposobem na zrozumienie czegos - jest napisanie tego. My stworzymy
	 * bardzo prosta imlpementacje Single Linked List.
	 */
	public void linkedList() {
		SdaLinkedList list = new SdaLinkedList("jeden");
		list.add("dwa");
		list.add("trzy");
		Assert.assertEquals(list.size(), 3);
		Assert.assertEquals(list.get(0), "jeden");
		list.remove("jeden");
		Assert.assertEquals(list.size(), 2);
		Assert.assertEquals(list.get(0), "dwa");
		list.add("cztery");
		list.remove("trzy");
		Assert.assertEquals(list.size(), 2);
		Assert.assertEquals(list.get(0), "dwa");
		Assert.assertEquals(list.get(1), "cztery");

		try {
			list.get(Integer.MAX_VALUE);
		} catch (IndexOutOfBoundsException exception) {
			System.out.println("yes1");
		}
		try {
			list.get(-1);
		} catch (IndexOutOfBoundsException exception) {
			System.out.println("yes2");
		}
	}

	@Test
	public void linkedListMyTest() {
		SdaLinkedList list = new SdaLinkedList("jeden");
		list.add("dwa");
		list.add("trzy");
		list.add("jeden");
		list.add("trzy");

		Assert.assertEquals(5, list.size());
		list.remove("trzy");
		Assert.assertEquals(4, list.size());
		Assert.assertEquals("jeden", list.get(2));
	}

	@Test
	public void removeAllTest() {
		SdaLinkedList list = new SdaLinkedList("jeden");
		list.add("jeden");
		list.add("dwa");
		list.add("trzy");
		list.add("trzy");
		list.add("cztery");
		list.add("cztery");
		Assert.assertEquals(7, list.size());

		list.removeAll("cztery");
		Assert.assertEquals(5, list.size());

		list.removeAll("jeden");
		Assert.assertEquals("dwa", list.get(0));
		Assert.assertEquals(3, list.size());

	}
}
