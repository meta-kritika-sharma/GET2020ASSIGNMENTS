import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws Exception {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(new Employee("Krits", 17, 800));
		linkedList.insert(new Employee("Divya", 18, 600));
		linkedList.insert(new Employee("Heena", 19, 500));
		linkedList.sort();
		List<Employee> sortedList = linkedList.returnAsList();
		for (int i=0;i<sortedList.size();i++){
			System.out.println(sortedList.get(i).getName());
		}
	}

}
