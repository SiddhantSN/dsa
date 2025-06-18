package java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import basics.arrays.EmployeeFactory;
import basics.arrays.EmployeeFactory.Employee;

public class Practice {

	public static void main(String[] args) {
		// employee list
		List<Employee> employeeList = EmployeeFactory.addData();

		PracticeData data = new PracticeData();
		sortByValue(EmployeeToEmployeeMap(employeeList));

		// TODO Auto-generated method stub

	}

	public static void onlyEven(List<Integer> list) {
		list.stream().filter(t -> t % 2 == 0).forEach(System.out::println);
	}

	public static void upperString(List<String> list) {
		list.stream().map(String::toUpperCase).forEach(System.out::println);
	}

	public static void greaterThan100(List<Integer> list) {
		long count = list.stream().filter(t -> t > 100).count();
		System.out.println(count);
	}

	public static void removeDuplicates(List<String> list) {
		list.stream().distinct().forEach(System.out::println);
	}

	public static void countDuplicates(List<String> list) {
//		Set<String> set = new HashSet<>();
//		long count = list.stream().filter(t->!(set.add(t))).count();
//		System.out.println(count);
		System.out.println(list.size() - list.stream().distinct().count());
	}

	public static void sumOfIntegers(List<Integer> list) {
		Integer sum = list.stream().reduce((t, u) -> t + u).get();
		System.out.println(sum);
	}

	public static void maxElement(List<Integer> list) {
		Optional<Integer> max = list.stream().max(Comparator.naturalOrder());
		System.out.println(max.get());
	}

	public static void averageElement(List<Integer> list) {
		Integer integer = list.stream().reduce((t, u) -> t + u).map(t -> t / list.size()).get();
		System.out.println(integer);
	}

	public static void ConcatString(List<String> list) {
		String string = list.stream().reduce((t, u) -> t.concat(u)).get();
		System.out.println(string);
	}

	public static void salarySum(List<Employee> list) {
		Integer integer = list.stream().map(Employee::Salary).reduce((s1, s2) -> s1 + s2).get();
		System.out.println(integer);
	}

	public static void groupByDepartment(List<Employee> list) {
		Map<String, Long> map = list.stream().collect(Collectors.groupingBy(t -> t.dept(), Collectors.counting()));
		System.out.println(map);
	}

	// Get the name of the highest-paid employee in each department.
	public static void highestPaidByDept(List<Employee> list) {
		Map<String, Optional<Employee>> highestPaidByDept = list.stream().collect(Collectors.groupingBy(Employee::dept,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::Salary)))

		));
		System.out.println(highestPaidByDept);
	}
	//How do you convert a list to a map using streams? (e.g., list of User to Map<name, salary>)
	public static Map<String, Integer> EmployeeToEmployeeMap(List<Employee> list) {
		Map<String, Integer> NameSalaryMap = list.stream().collect(Collectors.toMap(e->e.name(), t->t.Salary()));
		return NameSalaryMap;
	}
	
	//Given a Map<String, Integer>, how do you filter entries with value > 10 using streams?
	public static void filterEmployeeMap(Map<String, Integer> map) {
		Map<String,Integer> collect = map.entrySet().stream().filter(t->t.getValue()>20000).collect(Collectors.toMap(t->t.getKey(), t->t.getValue()));
		System.out.println(collect);
	}
	public static void sortByValue(Map<String, Integer> map) {
		Map<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(t->t.getKey(), t->t.getValue()));
		System.out.println(collect);
	}

}
