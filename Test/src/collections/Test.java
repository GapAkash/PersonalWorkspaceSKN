package collections;

public class Test {
	public static void main(String[] arr) {
		Ab a = new Ab();
		try {
			
			a.m1();
		} catch (Error e) {
			System.out.println(e);
		}
	}

}

class Ab {
	public void m1() {
		m1();
	}
}