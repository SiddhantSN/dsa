package basics.prep;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewPrepBasics {

	public static boolean isPalindrome(String str) {
		int start = 0;
		int end = str.length() - 1;

		while (start < end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	public static int printFiboNumber(int n) {
		if (n < 2)
			return n;

		return printFiboNumber(n - 1) + printFiboNumber(n - 2);
	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;

		return n * factorial(n - 1);
	}

	public static String reverseString(String str) {
		StringBuilder stringBuilder = new StringBuilder();
//		for (int i = str.length()-1; i >= 0; i--) {
//			stringBuilder.append(str.charAt(i));
//		}
		int end = str.length() - 1;
		while (end >= 0) {
			stringBuilder.append(str.charAt(end));
			end--;
		}
		return stringBuilder.toString().toUpperCase();
	}

	public static boolean isPrime(int num) {
		if (num < 2) {
			return true;
		}
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean sumOfPrimes(int target) {

		int[] array = IntStream.range(0, 10).filter(InterviewPrepBasics::isPrime).toArray();
		for (int i = 1; i < array.length; i++) {
			if (array[i] + array[i - 1] == target) {
				return true;
			}
		}
		return false;
	}
}
