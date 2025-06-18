package java8;

import java.util.Arrays;
import java.util.List;

public class PracticeData {
	
	public List<Integer> getIntegerList(){
		List<Integer> listOfIntegers = Arrays.asList(1,2,3,4);
		return listOfIntegers;
	}
	
	public List<String> getStringList(){
		List<String> listOfString = Arrays.asList("Sid","Tarun","Apoorva","Aditya");
		return listOfString;
	}
	
	public List<String> getStringListWithDuplicates(){
		List<String> listOfString = Arrays.asList("Sid","Tarun","Apoorva","Aditya","Sid","Apoorva");
		return listOfString;
	}
}
