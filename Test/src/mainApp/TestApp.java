package mainApp;

import java.util.HashSet;
import java.util.Set;

public class TestApp {
	public static void main(String[] args) {
		System.out.println(getMessage());
	}

	private static Set<String> getMessage() {
		String sentence = "html sql abcd html";
		String[] arr1 = sentence.toUpperCase().split(" ");
		//System.out.println(Arrays.toString(arr1));
		
		//String[] arr1 = { "html", "sql", "abcd", "html" };
		String[] arr2 = { "HTML", "SQL"};
		//System.out.println(Arrays.toString(arr2));
		
		Set<String> hash = new HashSet<String>();
		//StringBuilder hash = new StringBuilder();
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i].contains(arr2[j])) {
					hash.add(" #"+arr1[i]);
					//hash.append(" #"+arr1[i]);
				}
			}
		}
		return hash;
	}
}
