package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import basics.arrays.Arrays1;
import basics.arrays.StreamsTest;
import basics.arrays.StreamsTest.Employee;
import basics.prep.InterviewPrepBasics;
import basics.stacks.Stacks;

public class Test {

	public static void main(String[] args) {
		//
		int [] arr = {73,74,75,71,69,72,76,73};
		String str = "rotator";
		int[][] matrix = {
			    {1, 3, 5, 7},
			    {10, 11, 16, 20},
			    {23, 30, 34, 60}
			};
		
		System.out.println(InterviewPrepBasics.isPalindrome(str));
		System.out.println(InterviewPrepBasics.printFiboNumber(10));
		System.out.println(InterviewPrepBasics.factorial(5));
		
		System.out.println(InterviewPrepBasics.reverseString("hello"));
		System.out.println(InterviewPrepBasics.isPrime(3));
		System.out.println(InterviewPrepBasics.sumOfPrimes(12));
//		List<String> generateParenthesis = Stacks.generateParenthesis(3);
//		for (String string : generateParenthesis) {
//			System.out.println(string);
//		}
//		int[] dailyTemperatures = Stacks.dailyTemperatures(arr);
//		for (int i : dailyTemperatures) {
//			System.out.println(i);
//		}
//		String str = "Anavrin";
//		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//		//System.out.println(Arrays1.searchMatrix(matrix, 90));
//		System.out.println(Arrays1.checkInclusion("ab", "eidbaooo"));
//		System.out.println(Arrays1.search(arr, 3));
//		System.out.println(Stacks.evalRPN(tokens));
//		System.out.println(Arrays1.maxProfit(arr));
//		System.out.println(Arrays1.lengthOfLongestSubstring(str));
		System.out.println(Arrays1.characterReplacement(str, 2));
		
//		List<Employee> empList = StreamsTest.addData(new ArrayList<Employee>());
//		List<String> names = empList.stream().map(e->e.name()).toList();
//		String name = names.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
//		System.out.println(name);
//		
//		Integer salary = empList.stream().map(e->e.Salary()).sorted(Comparator.comparingInt(Integer::intValue).reversed()).findFirst().get();
//		System.out.println(salary);
//		
//		Integer avgSalary = (int) empList.stream().mapToInt(Employee::Salary).average().orElse(0);
//		System.out.println(avgSalary);
//		
//		Supplier<Double> supplier = () -> Math.random()*100;
//		int hello = supplier.get().intValue();
//		System.out.println(hello);
//		
//			
//		Consumer<Integer> consumer =t -> t.intValue();
//		System.out.println(consumer);
//		
//		
//		List<Integer> noDupli = Arrays.asList(1,2,2,3,4,6,6,6,9).stream().distinct().toList();
//		System.out.println(noDupli);
//		
//		
//		for (Integer integer : Arrays1.productExceptSelf(arr)) {
//			System.out.println(integer);
//		}
//		int[] arr1 = Arrays1.twoSum2(arr, 0);
//		for (int i : arr1) {
//			System.out.println(i);
//		}
//System.out.println(Arrays1.twoSum2(arr1, 9));
		}
		
		
		
	}

