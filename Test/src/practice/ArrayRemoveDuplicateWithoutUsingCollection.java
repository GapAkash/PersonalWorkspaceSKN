package practice;

import java.util.Arrays;

public class ArrayRemoveDuplicateWithoutUsingCollection {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 3, 2};
		
		Arrays.sort(arr);
		
		int j = 0;
		
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] != arr[i+1]) {
				arr[j++] = arr[i];
			}
		}
		
		arr[j] = arr[arr.length-1];
		
		for (int k = 0; k <= j; k++) {
			System.out.println(arr[k]);
		}
	}

}
