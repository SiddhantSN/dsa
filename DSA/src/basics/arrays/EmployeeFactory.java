package basics.arrays;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {

	public record Employee(int id, int Salary, String name, String dept) {};
	
	public static List<Employee> addData() {
		Employee emp1 = new Employee(1, 10000, "Sid","it");
		Employee emp2 = new Employee(2, 20000, "Ap","net");
		Employee emp3 = new Employee(3, 30000, "Ta","net");
		Employee emp4 = new Employee(4, 40000, "Ar","hr");
		Employee emp5 = new Employee(5, 50000, "Sa","support");
		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		return list;
	}
	
	
	
}

