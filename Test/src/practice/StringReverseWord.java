package practice;

import java.util.Stack;

public class StringReverseWord {
	
	public static void main(String[] args) {
		String s = "Akash Gupta";
		//  o/p = hsakA atpuG
		
		Stack<Character> st = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char var = s.charAt(i);
			
			if(var != ' ') {
				st.push(var);
			} else {
				while(st.empty()==false) {
					System.out.print(st.pop());
				}
				System.out.print(" ");
			}
		}
		while(st.empty()==false) {
			System.out.print(st.pop());
		}
	}

}
