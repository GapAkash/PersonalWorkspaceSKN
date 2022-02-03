package inter;

public class ExampleHashmap {

	public static void main(String[] args) {

		String s = "HelleH";

		int first = 0;
		int last = s.length() - 1;

		boolean isPalindrom = true;

		while (first < last) {

			for (int i = 0; i < s.length(); i++) {

				if (s.charAt(first) != s.charAt(last)) {
					isPalindrom = false;
					break;
				}
				first++;
				last--;

			}

		}
		if (isPalindrom) {
			System.out.println("Plaindrom");
		} else {
			System.out.println("Not a Plaindrom");
		}

	}
	
}
