package com.camadeusa.web;

import java.util.ArrayList;
import java.util.List;

// Only allowing 0-100
public class Main {

	private static List<Integer> storage = new ArrayList<>();
	private static int lowerLimit = 0;
	private static int upperLimit = 100;
	// No need for getters or setters in this case.

	public static void main(String[] args) {
		// Adding Individuals
		randomListGen(20).forEach((i) -> {
			if (shouldBeStored(i, lowerLimit, upperLimit)) {
				get().add(i);
			}
		});
		
		// Adding List itself
		filter(randomListGen(20), lowerLimit, upperLimit).forEach((i) -> {
			get().add(i);
		});
		
		System.out.println(storage.toString());
	}

	// Can filter entire lists if I want.
	public static List<Integer> filter(List<Integer> l, int lowerLim, int upperLim) {
		List<Integer> toRemove = new ArrayList<>();
		l.forEach((i) -> {
			if (i < lowerLim || i > upperLim) {
				toRemove.add(i);
			}
		});
		toRemove.forEach((i) -> {
			l.remove(i);
		});

		return l;
	}

	// Can filter individual numbers as well.
	public static boolean shouldBeStored(int i, int lowerLim, int upperLim) {
		if (i > lowerLim && i < upperLim) {
			return true;
		} else {
			return false;
		}
	}

	// Helper to generate random numbers.
	public static List<Integer> randomListGen(int size) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			int num = (int) (Math.random() * 1000);
			numbers.add(num);
		}
		return numbers;
	}

	public static List<Integer> get() {
		return storage;
	}

}
