package collections;

public class Child extends Parent {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(" child run");
		super.run();
	}
	
	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println(" child walk");
		super.walk();
	}

}
