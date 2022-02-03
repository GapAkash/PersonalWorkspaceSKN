package collections;

import java.util.Comparator;

public class FirstNameSorter implements Comparator<Employee>{

	@Override
	public int compare(Employee var1, Employee var2) {
		return var1.getFirstName().compareTo(var2.getFirstName());
	}

}
