package practice;

import java.util.HashMap;
import java.util.Map;

public class StringFrequencyOfString {
	public static void main(String[] args) {
		String s = "Akash";
		
		s = s.toLowerCase();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			
			char var = s.charAt(i);
			if (map.containsKey(var)) {
				map.put(var, map.get(var)+1);
			} else {
				map.put(var, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> abcd : map.entrySet()) {
			
			System.out.println("Char - "+abcd.getKey()+", Frequency - "+abcd.getValue());
			
		}
	}
}
