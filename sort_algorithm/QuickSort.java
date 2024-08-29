package sort_algorithm;

import java.util.Arrays;
import java.util.ArrayList;

public class QuickSort {
	static int[] origin = {5, 3, 7, 8, 6, 4, 2, 1, 0, 9};
	static ArrayList<Integer> sorted = new ArrayList<>();
	
	public static void quickSort(int start, ArrayList<Integer> arr) {
		if (arr.size() <= 1) {
			return;
		}
		
		int pivot = arr.size() / 2;
		ArrayList<Integer> lefts = new ArrayList<>();
		ArrayList<Integer> rights = new ArrayList<>();
		
		for (int i = 0; i < arr.size(); i++) {
			if (i != pivot && arr.get(i) < arr.get(pivot)) {
				lefts.add(arr.get(i));
			} else if (i != pivot) {
				rights.add(arr.get(i));
			}
		}
		int index = start;
		for (int l : lefts) {
			sorted.set(index++, l);
		}
		sorted.set(index++, arr.get(pivot));
		for (int r : rights) {
			sorted.set(index++, r);
		}
		
		if (lefts.size() > 1) {
			quickSort(start, lefts);
		}
		if (rights.size() > 1) {
			quickSort(pivot, rights);
		}
	}
	
	/*
	public static void main(String[] args) {
		ArrayList<Integer> arrlist = new ArrayList<>();
		for (int o : origin) {
			arrlist.add(o);
		}
		sorted = arrlist;
		quickSort(0, arrlist);
		System.out.println(sorted);
	}*/
}