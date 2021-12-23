package java_lab;

import java.util.Scanner;

class Complex {
	double Re, Im;
	
	public Complex() {
		this.Re = 0;
		this.Im = 0;
	}
	
	public Complex(double Re, double Im) {
		this.Re = Re;
		this.Im = Im;
	}
	
	public static Complex add(int a, Complex b) {
		return new Complex(a + b.Re, b.Im);
	}
	
	public static Complex add(double a, Complex b) {
		return new Complex(a + b.Re, b.Im);
	}
	
	public static Complex add(Complex a, Complex b) {
		return new Complex(a.Re + b.Re, a.Im + b.Im);
	}
	
	@Override
	public String toString() {
		return Re + " + i" + Im;
	}
}

public class ComplexNumbers {
	public static void main(String[] args) {
		int i;
		Complex a, b;
		double re, im;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter integer i = ");
		i = s.nextInt();
		System.out.print("Enter Re and Im for a: ");
		re = s.nextDouble();
		im = s.nextDouble();
		a = new Complex(re, im);
		System.out.print("Enter Re and Im for b: ");
		re = s.nextDouble();
		im = s.nextDouble();
		b = new Complex(re, im);
		System.out.println("a + i = " + Complex.add(i, a));
		System.out.println("a + b = " + Complex.add(a, b));
		s.close();
	}
}
