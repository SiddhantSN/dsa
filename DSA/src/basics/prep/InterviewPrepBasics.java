package basics.prep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewPrepBasics {
	
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
		System.out.println(countOccurancesUsingStreams("abc"));
		System.out.println(countOccurances("abc"));
		System.out.println(countOccurancesUsingStreamsForInts(1122334567));
	}
	

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
	
	public static HashMap<Character, Integer> countOccurances(String str){
		HashMap<Character, Integer> result = new HashMap<>();
		
		char[] charArray = str.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			result.put(charArray[i], result.getOrDefault(charArray[i], 0)+1);
		}
		return result;
	}
	
	public static String containsVowels(String str) {
		//char [] vowels= {'a','e','i','o','u'};
		StringBuilder res = new StringBuilder();
		int left = 0;
		int right = 1;
		while(right<str.length()) {
			if(str.substring(left, right).matches("^[aeyiuo]+$")) {
				right++;
			}
			else {
				StringBuilder res1 = new StringBuilder();
				res=res1.append(str.substring(left, right));
				left = right;
				right++;
			}
		}
		return res.toString();
	}
	
	public static void OneThreadEvenOneThreadOdd() {
		boolean isOddTurn = true;
		
		Thread T1 = new Thread(()->{
			for (int i = 1; i <= 10; i++) {
				if(i%2==0) {
					if(!isOddTurn) {
						System.out.println(i);
					}
					else {
						
					}
					
				}
			}
		
		});
		Thread T2 = new Thread(()->{
			for (int i = 1; i <= 10; i++) {
				if(i%2!=0) {
					System.out.println(i);
				}
			}
		});
		
		T1.start();
		T2.start();
	}
	
	// SIDAEIOUPSID, Longest substring with vowels 
	
	public static String vowelSubstring(String str) {
		return str;
		
	}
	
    public static int lengthOfLongestSubstring(String s) {
    	int left = 0;
    	int right = 0;
    	
    	Set<Character> seen = new HashSet<>();
    	int maxLength = 0;
    	
    	while(right<s.length()) {
    		if(!seen.contains(s.charAt(right))) {
    			seen.add(s.charAt(right));
    			maxLength = Math.max(maxLength, right-left+1);
    			right++;
    		}
    		else {
    			seen.remove(s.charAt(left));
    			left++;
    		}
    	}
		return maxLength;
    	
    }
    
    public static Map<Character, Long> countOccurancesUsingStreams(String str){
    	List<Character> list = new ArrayList<>();
    	for (Character character : str.toCharArray()) {
			list.add(character);
		}
    	Map<Character, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		return collect;
    }
    
    public static Map<Character, Long> countOccurancesUsingStreamsForInts(int ints){
    	String str = String.valueOf(ints);
    	List<Character> list = new ArrayList<>();
    	for (Character character : str.toCharArray()) {
			list.add(character);
		}
    	Map<Character, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		return collect;
    }
    
	//Balanced Parenthesis
    
    
	
}
