package inter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestMain {

	public static void main(String[] args) {

		int[] arr = { 6, 1, 2, 3, 4, 5, 3, 4, 5 };

		Set<Integer> set = new TreeSet<>();

		for (Integer num : arr) {

			set.add(num);

		}
		

		set.forEach(a -> System.out.println(a));
	}

}
