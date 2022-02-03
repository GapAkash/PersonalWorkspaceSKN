package mainApp;

public class TestSplit {
public static void main(String[] args) {
	String str = "https://www.udemy.com/course/data-structures-and-algorithms-bootcamp-in-python/?couponCode=DATA_ALGO_PYTHON3";
	String str1[] = str.split("/");
	
	System.out.println(str1[5]);
	for (String string : str1) {
		System.out.print(string);
	}
}
}
