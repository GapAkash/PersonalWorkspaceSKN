package mathematics;

import java.util.Scanner;

public class NumberOfDigitInN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter Number - ");
		long number = sc.nextLong();

		System.out.println("Number of digit is - " + digitCount(number));
		
		sc.close();
	}

	private static long digitCount(long number) {
		int count = 0;
		while (number != 0) {
			number = number / 10;
			count = count + 1;
		}
		return count;
	}

}
