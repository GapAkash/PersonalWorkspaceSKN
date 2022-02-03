package level1;

import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			int n = scn.nextInt();
			
			int count = 0;
			for (int div = 2; div <= n; div++) {
				if (n%div==0) {
					count++;
				}
			}
			
			if (count==1) {
				System.out.println("Prime");
			} else {
				System.out.println("Not Prime");
			}
		}
		scn.close();
	}

}
