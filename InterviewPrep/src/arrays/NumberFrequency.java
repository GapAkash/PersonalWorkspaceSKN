package arrays;

import java.util.HashMap;
import java.util.Map;

public class NumberFrequency {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 2, 2, 4, 2, 1, 2, };

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}

		}

		map.forEach((k, v) -> System.out.println("Frequency of " + k + " is " + v));

	}

}
