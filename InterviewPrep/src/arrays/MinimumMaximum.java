package arrays;

public class MinimumMaximum {
	
	public static void main(String[] args) {
		int arr[] = {56789, 345, 234, 21, 1};
		
		int min = 0;
		int max = arr.length-1;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[min]>arr[max]) {
				arr[max] = arr[min];
			} 
			
			if(arr[max]<arr[min]) {
				arr[min] = arr[max];
			} 
		}
		System.out.println(arr[max]);
		System.out.println(arr[min]);
		
	}

}
