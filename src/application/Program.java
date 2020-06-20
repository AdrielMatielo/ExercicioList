package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
	
	public static void main (String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		

		List<Employee> list = new ArrayList<>();
		
		//READING DATA:
	
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i =0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #"+ i+":");
			
			System.out.print("Id: ");
			int id = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}		
		
		//UPDATING DATA:
		System.out.println();
		System.out.print("Enter the employee id that will have salary: ");
		int id = sc.nextInt();
		
		//SEARCH WITH LAMBDA EXPRESSION
			Employee pos = list.stream().filter(x ->x.getId() == id).findFirst().orElse(null);
		
		//SEARCH WITHOUT LAMBDA EXPRESSION
			//Integer pos = position(list, id);
		
		if (pos == null) {
			System.out.println("This ID dos not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			//SEARCH WITH LAMBDA EXPRESSION
			pos.increaseSalary(sc.nextDouble());
			//SEARCH WITHOUT LAMBDA EXPRESSION
			//list.get(pos).increaseSalary(sc.nextDouble());
		}
		
		//PRINTING DATA:
		System.out.println();
		System.out.println("List of emplyees:");
		for(Employee x : list)
			System.out.println(x);
		
		sc.close();
			
	}
	
	public static Integer position(List<Employee> list, int id) {
		for (int i=0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}

}
