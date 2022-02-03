package inter;

public class TekMinds {
	
	public static void main(String[] args) {
		
		StringBuilder s = new StringBuilder ("AKASH");
		System.out.println(s);
		disply(s);
		System.out.println(s);
		
	}

	private static String disply(StringBuilder s) {
		s = s.append("GUPTA");
		System.out.println(s);
		return s.toString();
		
	}

}
