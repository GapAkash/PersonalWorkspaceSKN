package inter;

import java.util.Set;
import java.util.TreeSet;

public class LargestArray {

	public static void main(String[] args) {

		int[] arr = {7, 8, 1, 2, 4, 6, 7 };
		
		int max = arr.length-1;
	
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i]>arr[max]) {
				max = i;
			}
			
		}
		
		System.out.println(arr[max-1]);
		
	}

}
