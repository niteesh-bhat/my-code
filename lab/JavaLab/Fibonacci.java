package java_lab;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		int n;
		Scanner s = new Scanner(System.in);
		int a1 = 1, a2 = 1;
		System.out.println("Enter n: ");
		n = s.nextInt();
		
		System.out.print("0 ");
		for (int i = 0; i < n-1; i++) {
			System.out.print(a1 + " ");
			int next = a1 + a2;
			a1 = a2;
			a2 = next;
		}
		System.out.print("\n");
		
		s.close();
	}
}
