package com.sda.lists;

import java.util.ArrayList;
import java.util.List;

public class ExercisesImpl {

	public static List<String> fill(String string, int size) {
		// List<String> list = new ArrayList<String>();
		// for (int i = 0; i < size; i++) {
		// list.add(string);
		// }
		// return list;
		return fillGeneric(string, size);
	}

	public static <T> List<T> fillGeneric(T value, int size) {
		List<T> list = new ArrayList<T>();
		for (int i = 0; i < size; i++) {
			list.add(value);
		}
		return list;
	}

	public static void swap(List<String> listOne, int i, int j) {
		// String tempElement1 = listOne.get(i);
		// String tempElement2 = listOne.get(j);
		// listOne.remove(i);
		// listOne.add(i, tempElement2);
		// listOne.remove(j);
		// listOne.add(j, tempElement1);
		swapGeneric(listOne, i, j);
	}

	public static <T> void swapGeneric(List<T> listOne, int i, int j) {
		System.out.println(listOne);
		listOne.add(Math.max(i, j), listOne.get(Math.min(i, j)));
		System.out.println(listOne);
		listOne.remove(Math.min(i, j));
		System.out.println(listOne);
		listOne.add(Math.min(i, j), listOne.get(Math.max(i, j)));
		System.out.println(listOne);
		listOne.remove(Math.max(i, j) + 1);
		System.out.println(listOne);
	}

	public static void reverse(List<String> list) {
		reverseGeneric(list);
	}

	public static <T> void reverseGeneric(List<T> list) {
		List<T> reversedList = new ArrayList<T>();
		for (int i = list.size() ; i > 0; i--) {
			reversedList.add(list.size()-i, list.get(i-1));
		}
		list.clear();
		list.addAll(reversedList);
	}

	public static void rotate(List<Integer> numbers, int i) {
		List<Integer> tempSubList = new ArrayList<Integer>();
		int size = numbers.size();
		for (int j = 0, k = j - i; j < size; j++, k++) {
			int v2 = k >= 0 ? k : size + k;
			tempSubList.add(numbers.get(v2));
		}
		numbers.clear();
		numbers.addAll(tempSubList);
		tempSubList.clear();
	}

	public static void bubbleSort(ArrayList<Integer> list) {
	}

}
