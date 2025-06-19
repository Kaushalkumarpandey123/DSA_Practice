package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortListofCustomClass {
    //How to sort a list of custom objects (like Employee)
    // based on a field using Stream?

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(10),
                new Employee(2),
                new Employee(15),
                new Employee(20),
                new Employee(30),
                new Employee(25)
        );

        List<Employee> sortedEmployees = employees.stream()
                .sorted((emp1 , emp2) -> emp1.getId() - emp2.getId())
                .collect(Collectors.toList());

        System.out.println(sortedEmployees.toString());

    }
}

class Employee implements Comparable<Employee> {
    int id;
    public Employee(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getId() - o.getId();
    }

    @Override
    public String toString() {
        return "Employee{id=" + getId() +"}";
    }
}
