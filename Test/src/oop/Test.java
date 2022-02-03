package oop;

abstract class Parent {

	static void m1() {
		System.out.println("parent static");
	}

	void m2()   {
		System.out.println("parent instance");
	}

	abstract void m3();

}

class Child extends Parent {

	static void m1() {
		System.out.println("child static");

	}

	@Override
	void m2()   {
		System.out.println("child instance");
	}

	@Override
	void m3() {
		System.out.println("child m3");
	}

}

public class Test {

	public static void main(String[] args) throws Exception {
		Parent.m1();
		Child.m1();
		Child c = new Child();
		c.m2();
		c.m3();

		System.out.println("-------------------");
		Parent p = new Child();
		p.m2();
		p.m3();
	}
}
