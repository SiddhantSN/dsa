package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import basics.arrays.Arrays1;

public class Test {

	public static void main(String[] args) {
		//
		int [] arr = {0,1,2,4,5,7};
		System.out.println(Arrays1.BuySellPrice(arr));
		System.out.println(Arrays1.dnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(Arrays1.jumpGame(arr));
		System.out.println(Arrays1.binarySearch(arr, 4));
//		HashMap<String, Integer> students = new HashMap<>();
//		students.put("Sid", 75);
//		students.put("Zara", 90);
//		students.put("Aaron", 65);
//		students.put("Apoorva", 95);
//		students.put("Tom", 50);
//		
//		students.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		
	}
}
