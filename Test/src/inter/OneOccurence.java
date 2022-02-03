package inter;

import java.util.HashMap;
import java.util.Map;

public class OneOccurence {
	
	public static void main(String[] args) {
		
		int arr[]= {1, 5, 6, 5, 1};
		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = 1; j < arr.length; j++) {
//				if(arr[i]==arr[j]);
//			}
//		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.get(arr[i])==null ? 1 : map.get(arr[i])+1);
		}
		
		for(Map.Entry<Integer, Integer> ans: map.entrySet()) {
			if(ans.getValue()==1) {
				System.out.println(ans.getKey());
			}
		}
		
	}

}
