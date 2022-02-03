package wissen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Arr {

	public static void main(String[] args) {
		int[] arr = { 6, 6};

		List<Integer> list = new ArrayList<Integer>();

		list.add(5);
		list.add(10);
		list.add(-1);
		list.add(-4);
		list.add(60);
		
		list.stream().filter(a -> a > 0).forEach(a->System.out.println(a));
		
		
			
		

//		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
//			Integer integer = (Integer) iterator.next();
//
//			if (integer < 0) {
//				iterator.remove();
//			}
//
//		}
//		System.out.println(list);

	}

}
