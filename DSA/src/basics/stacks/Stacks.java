package basics.stacks;

import java.util.Stack;

public class Stacks {

	public static String reverseStringUsingStacks(String str) {
		str = str.toLowerCase();
		Stack<Character> strStack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			strStack.push(str.charAt(i));
		}
		StringBuilder result = new StringBuilder();
		while (strStack.iterator().hasNext()) {
			result.append(strStack.pop());
		}
		return result.toString();

	}

	public static int evalRPN(String[] tokens) {
		int result = 0;
		Stack<String> stack1 = new Stack<>();
		for (String string : tokens) {
			switch (string) {
			case "+":
				
				break;
			case "-":
				
				break;
			case "*":
				
				break;
			case "/":
				
				break;
			default:
				stack1.push(string);
				break;
			}
		}
		return result;
	}
}
