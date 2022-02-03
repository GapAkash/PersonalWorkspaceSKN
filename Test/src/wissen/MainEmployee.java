package wissen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainEmployee {

	public static void main(String[] args) {

//		List<Employee> list = new ArrayList<Employee>();
//
//		list.add(new Employee(1, "Satyam", 21));
//
//		list.add(new Employee(2, "Sumit", 24));
//
//		list.add(new Employee(3, "Ankuj", 2));
//
//		list.add(new Employee(4, "Saurabh", 33));
//
//		list.add(new Employee(5, "Madhav", 45));
//		
//		list.stream().sorted((o1, o2) -> (int)(o1.getSalary() - o2.getSalary())).forEach(a -> System.out.println(a.getfName()));
//		System.out.println();
//		list.stream().filter(a -> a.getSalary()>21).forEach(a -> System.out.println(a.getfName()));
//		System.out.println();
//		list.forEach(a -> System.out.println(a.getfName()+":"+a.getSalary()));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(7);
		list.add(6);
		
		Set<Integer> set = new HashSet<>();
		
		list.stream().filter(x -> !set.add(x)).forEach(System.out::println);
	}

}
