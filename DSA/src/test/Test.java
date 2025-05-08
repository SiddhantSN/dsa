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
import basics.stacks.Stacks;

public class Test {

	public static void main(String[] args) {
		//
		int [] arr = {5,1,3};
		int[][] matrix = {
			    {1, 3, 5, 7},
			    {10, 11, 16, 20},
			    {23, 30, 34, 60}
			};
		String str = "Anavrin";
		//System.out.println(Arrays1.searchMatrix(matrix, 90));
		System.out.println(Arrays1.checkInclusion("ab", "eidbaooo"));
		System.out.println(Arrays1.search(arr, 3));
		
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

