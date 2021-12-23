package java_lab;

import java.util.Scanner;

class Book {
	String title, code;
	double cost;
	int quantity;
	double totalPrice;
	
	static double finalPrice = 0;
	
	public static Book constructFromUserInput() {
		Book b = new Book();
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter book name: ");
		b.title = s.next();
		
		System.out.print("Enter book code: ");
		b.code = s.next();
		
		System.out.print("Enter book cost: ");
		b.cost = s.nextDouble();
		
		System.out.print("Enter quantity: ");
		b.quantity = s.nextInt();
		
		b.totalPrice = b.cost * b.quantity;
		
		finalPrice += b.totalPrice;
		
		return b;
	}
	
	public static void displayHeader() {
		System.out.println("Name \t\tCode \t\tUnit Price \tQuantity \tTotal Price");
	}
	
	public void display() {
		System.out.println(title + "\t\t" + code + "\t\t" + cost + "\t\t" + quantity + "\t\t" + totalPrice);
	}
}

public class Books {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter number of book items: ");
		int n = s.nextInt();
		
		Book[] books = new Book[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter item " + (i+1) + " details: ");
			books[i] = Book.constructFromUserInput();
			System.out.println();
		}
		
		Book.displayHeader();
		for (Book b : books)
			b.display();
		System.out.println();
		
		System.out.println("Final cost: " + Book.finalPrice);
		
		s.close();
	}
}
