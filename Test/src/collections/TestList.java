package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestList {
	
	public static void main(String[] args) {
		
//		Employee e1 = new Employee();
//		e1.setId(1);
//		e1.setFirstName("AKASH");
//		
//		Employee e2 = new Employee();
//		e2.setId(1);
//		e2.setFirstName("AKASH");
//		
//		
//		Map<Employee, Integer> map = new HashMap<Employee, Integer>();
//		
//		map.put(e1, 1);
//		map.put(e2, 2);
//		
//		System.out.println(map);
		Employee e1 = new Employee(1, "aTestName", "dLastName", 34);
        Employee e2 = new Employee(2, "nTestName", "pLastName", 30);
        Employee e3 = new Employee(3, "kTestName", "sLastName", 31);
        Employee e4 = new Employee(4, "dTestName", "zLastName", 25);
        
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(e2);
        employees.add(e3);
        employees.add(e1);
        employees.add(e4);
		
        System.out.println(employees);
        
        Collections.sort(employees);
        System.out.println(employees);
        
        Collections.sort(employees, new FirstNameSorter());
        System.out.println(employees);
        
	}
	

}
