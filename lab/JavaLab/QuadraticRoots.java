package java_lab;

import java.util.Scanner;

class Quadratic {
	double a, b, c;
	
	public Quadratic(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public void readQuadratic() {
		System.out.println("ax^2 + bx + c = 0");
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter coeff. a: ");
		this.a = s.nextDouble();
		
		System.out.println("Enter coeff. b: ");
		this.b = s.nextDouble();
		
		System.out.println("Enter coeff. c: ");
		this.c = s.nextDouble();
		
		
		s.close();
	}
	
	public void printQuadratic() {
		System.out.println(a + "x^2 + " + b + "x + " + c + " = 0");
	}
	
	public void evaluate() {
		if (a == 0.0) {
			System.out.println("Invalid quadratic. (a == 0)");
			return;
		}
		
		double disc = b*b - 4*a*c;
		
		if (disc > 0.0) {
			// Real unequal roots
			double root1 = (-b + Math.sqrt(disc))/(2*a);
			double root2 = (-b - Math.sqrt(disc))/(2*a);
			
			System.out.println("Root 1: x = " + root1);
			System.out.println("Root 2: x = " + root2);
		} else if (disc == 0.0) {
			// Real equal roots
			double root = -b/(2*a);
			
			System.out.println("Root 1 = Root 2 : x = " + root);
		} else {
			// Complex unequal roots
			double Re = -b/(2*a);
			double Im = Math.sqrt(disc)/(2*a);
			
			System.out.println("Root 1 : x = " + Re + " + i" + Im);
			System.out.println("Root 2 : x = " + Re + " - i" + Im);
		}
	}
}

public class QuadraticRoots {
	public static void main(String[] args) {
		Quadratic q = new Quadratic(0.0, 0.0, 0.0);
		q.readQuadratic();
		q.printQuadratic();
		q.evaluate();
	}
}
