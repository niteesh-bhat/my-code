package java_lab;

import java.util.Scanner;

class Employee {
	int id;
	String name, dep_name;
	double basic_pay;
	
	public static Employee readNewEmployee() {
		Scanner s = new Scanner(System.in);
		Employee e = new Employee();
		
		System.out.print("Enter Employee id: ");
		e.id = s.nextInt();
		
		System.out.print("Enter Employee name: ");
		e.name = s.next();
		
		System.out.print("Enter department name: ");
		e.dep_name = s.next();
		
		System.out.print("Enter basic pay: ");
		e.basic_pay = s.nextDouble();
		
		return e;
	}
	
	public double computeGrossPay() {
		return 1.74 * this.basic_pay;
	}
	
	public double coumputeIncomeTax() {
		double gross = this.computeGrossPay();
		if (gross <= 200000) {
			return 0;
		} else if (gross <= 300000) {
			return 0.1 * gross;
		} else if (gross <= 500000) {
			return 0.15 * gross;
		} else {
			double tax = 0.3 * gross;
			tax += tax*0.02;
			return tax;
		}
	}
	
	public double computeNetPay() {
		return this.computeGrossPay() - this.coumputeIncomeTax();
	}
	
	public static void displayHeader() {
		System.out.println("Id\tEmployee name\tDep. name.\tBasic Pay\tGross Pay\tIncome Tax\tNet Pay");
	}
	
	public void display() {
		System.out.println(id + "\t" + name + "\t\t" + dep_name + "\t\t" + basic_pay + "\t\t" + this.computeGrossPay() + "\t\t" + this.coumputeIncomeTax() + "\t\t" + this.computeNetPay());
	}
}

public class EmployeeRecord {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter number of employees: ");
		int n = s.nextInt();
		
		Employee employees[] = new Employee[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter employee " + (i+1) + " details: ");
			employees[i] = Employee.readNewEmployee();
			System.out.println();
		}
		
		Employee.displayHeader();
		for (Employee e : employees)
			e.display();
		System.out.println();
		
		s.close();
	}
}
