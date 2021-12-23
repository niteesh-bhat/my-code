package java_lab;

import java.util.Scanner;

public class MergeArray {
	public static int[] merge(int[] arr1, int[] arr2) {
		int m = arr1.length, n = arr2.length;
		int[] mergeArr = new int[m+n];
		
		int i;
		int x = 0, y = 0;
		for (i = 0; i <= m+n && x != m && y != n; i++) {
			if (arr1[x] < arr2[y])
				mergeArr[i] = arr1[x++];
			else
				mergeArr[i] = arr2[y++];
		}
		
		while (x < m)
			mergeArr[i++] = arr1[x++];
		
		while (y < n)
			mergeArr[i++] = arr2[y++];
		
		return mergeArr;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter number of elements in first array: ");
		int m = s.nextInt();
		int[] a = new int[m];
		System.out.print("Enter elements into array in asscending order: ");
		for (int i = 0; i < m; i++)
			a[i] = s.nextInt();
		
		System.out.print("Enter number of elements in second array: ");
		int n = s.nextInt();
		int[] b = new int[n];
		System.out.print("Enter elements into array in asscending order: ");
		for (int i = 0; i < n; i++)
			b[i] = s.nextInt();
		
		int mergeArr[] = merge(a, b);
		
		System.out.println("Array after merging is: ");
		for (int i : mergeArr) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		s.close();
	}
}
