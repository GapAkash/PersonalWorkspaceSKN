package wissen;

public class Employee {

	private int id;
	private String fName;
	private double salary;

	public Employee(int id, String fName, double salary) {
		super();
		this.id = id;
		this.fName = fName;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", salary=" + salary + "]";
	}

}
