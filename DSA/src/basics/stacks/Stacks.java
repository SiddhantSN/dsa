package basics.stacks;

import java.util.Stack;

public class Stacks {
	
	public static String reverseStringUsingStacks(String str) {
		 str = str.toLowerCase();
		Stack<Character> strStack = new Stack<>();
		for(int i=0;i<str.length();i++) {
			strStack.push(str.charAt(i));
		}
		StringBuilder result = new StringBuilder();
		while(strStack.iterator().hasNext()) {
			result.append(strStack.pop());
		}
		return result.toString();
		
	}
}
