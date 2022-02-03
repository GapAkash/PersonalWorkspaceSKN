package practice;

public class TestMain {

	public static void main(String[] args) {
		String s = "My name# i%s akash";


		s = s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);

//		for (char ch : s.toCharArray()) {
//			if (ch != ' ') {
//				System.out.print(ch);
//			}
//		}
	}

}
