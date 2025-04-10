package basics.arrays;

import java.util.List;

public class StreamsTest {

	public record Employee(int id, int Salary, String name, String dept) {};
	
	public static List<Employee> addData(List<Employee> list) {
		Employee emp1 = new Employee(1, 10000, "Sid","it");
		Employee emp2 = new Employee(2, 2000, "Ap","net");
		Employee emp3 = new Employee(3, 30000, "Ta","net");
		Employee emp4 = new Employee(4, 4000, "Ar","hr");
		Employee emp5 = new Employee(5, 100000, "Sa","support");
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		return list;
	}
	
	
	
}

