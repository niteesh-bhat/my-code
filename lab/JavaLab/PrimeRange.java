package java_lab;

import java.util.Scanner;

public class PrimeRange {
	public static void main(String[] args) {
		int lrange, rrange;
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter start index: ");
		lrange = s.nextInt();
		
		System.out.print("Enter end index: ");
		rrange = s.nextInt();
		
		
		for (int i = lrange; i <= rrange; i++) {
			boolean isPrime = (i != 1);
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime)
				System.out.print(i + " ");
		}
		
		s.close();
	}
}
