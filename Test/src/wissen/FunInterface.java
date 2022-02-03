package wissen;

@FunctionalInterface
public interface FunInterface {
	
	public int multiply(int a, int b);
	
	public static void metA(String... string) {
		System.out.println(string+" ");
	}

}
