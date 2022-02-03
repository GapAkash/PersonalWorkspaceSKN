package array;

public class PrimeNumber {
	public static void main(String[] args) {
		int n = 100;
		isPrime(n);
	}

	private static void isPrime(int n) {
		for (int i = 2; i <= n/2 ; i++) {
			if (i%n==0) {
			} else {
				System.out.println(i);
			}
		}
	}
}
