package oop;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Mao {
	public static void main(String[] args) {
		Set<Integer> map = new HashSet<>();
		
		
		
		map.add(null);
		map.add(null);
		
		System.out.println(map);
		
		for (Integer integer : map) {
			System.out.println(integer);
		}
	}
}
