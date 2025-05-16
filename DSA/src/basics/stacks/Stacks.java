package basics.stacks;

import java.util.ArrayList;
import java.util.List;
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
	
	private static void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {int[] res = new int[temperatures.length];
    Stack<int[]> stack = new Stack<>(); // pair: [temp, index]

    for (int i = 0; i < temperatures.length; i++) {
        int t = temperatures[i];
        while (!stack.isEmpty() && t > stack.peek()[0]) {
            int[] pair = stack.pop();
            res[pair[1]] = i - pair[1];
        }
        stack.push(new int[]{t, i});
    }
    return res;}
}
