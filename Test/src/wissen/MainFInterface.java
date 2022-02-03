package wissen;

public class MainFInterface {

	public static void main(String[] args) {

		FunInterface total = (a, b) -> a * b;

		System.out.println(total.multiply(10, 50));
		
	}

}


