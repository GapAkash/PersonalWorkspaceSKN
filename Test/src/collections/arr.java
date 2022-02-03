package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Write a program to find distinct element in an error and also find out frequency of those elements.
//For e.g. if array is an integer array
//int arr[] = {10,40, 30, 20,40, 30,20,10}

public class arr {

	public static void main(String[] args) {

		int arr[] = { 10, 10, 40, 30, 20, 40, 30, 20, 10, 50 };
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (Integer integer : arr) {
//			if (set.add(integer)==false) {
//				System.out.println(integer);
//			}
			set.add(integer);
		}
		
		

//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//		for (int i = 0; i < arr.length; i++) {
//
//			if (map.containsKey(arr[i])) {
//				map.replace(arr[i], map.get(arr[i]) + 1);
//			} else {
//				map.put(arr[i], 1);
//
//			}
//
//		}
//		System.out.println(map);

//		
//		
//		for (int i = 0; i < arr.length; i++) {
//			int count = 0;
//			for (int j = 0; j < arr.length; j++) {
//				if (arr[i] == arr[j]) {
//					count++;
//				}
//			}
//			map.put(arr[i], count);
//		}
//		
//		System.out.println(map);

	}

}
