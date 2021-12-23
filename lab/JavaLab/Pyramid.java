package java_lab;

import java.util.Scanner;

public class Pyramid {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = s.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++)
				System.out.print(" ");
			for (int j = 0; j < 2*i - 1; j++)
				System.out.print("*");
			for (int j = 0; j < n - i; j++)
				System.out.print(" ");
			System.out.print("\n");
		}
		
		s.close();
	}
}
