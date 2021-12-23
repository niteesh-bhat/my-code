package java_lab;

import java.util.Scanner;

class StudentResult {
	String rollNo;
	double[] marks;
	double totalMarks;
	
	static StudentResult highest[] = new StudentResult[3];
	static StudentResult totalHighest;
	
	public void readInput() {
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter roll number: ");
		this.rollNo = s.next();
		
		this.marks = new double[3];
		System.out.print("Enter marks in three subjects: ");
		for (int i = 0; i < 3; i++)
			this.marks[i] = s.nextDouble();
		
		this.totalMarks = (this.marks[0] + this.marks[1] + this.marks[2]);
		
		for (int i = 0; i < 3; i++)
			if (highest[i] == null || highest[i].marks[i] < this.marks[i])
				highest[i] = this;
		
		if (totalHighest == null || totalHighest.totalMarks < this.totalMarks)
			totalHighest = this;
	}
	
	public static void printHeader() {
		System.out.println("Roll no. \tSubject-1 \tSubject-2 \tStudent-3 \tTotal Marks");
	}
	
	public void display() {
		System.out.println(this.rollNo + "\t\t" + this.marks[0] + "\t\t" + this.marks[1] + "\t\t" + this.marks[2] + "\t\t" + this.totalMarks);
	}
}

public class StudentMarks {
	public static void main(String[] args) {
		StudentResult records[] = new StudentResult[3];
		for (int i = 1; i <= 3; i++) {
			System.out.println("Enter info of student " + i);
			records[i-1] = new StudentResult();
			records[i-1].readInput();
		}
		
		StudentResult.printHeader();
		for (StudentResult sr : records)
			sr.display();
		System.out.println();
		
		for (int i = 0; i < 3; i++)
			System.out.println("The highest in subject " + (i+1) + " was scored by roll number " + StudentResult.highest[i].rollNo + " with marks = " + StudentResult.highest[i].marks[i]);
		
		System.out.println("The highest total marks were scored by roll number " + StudentResult.totalHighest.rollNo + " with marks = " + StudentResult.totalHighest.totalMarks);
	}
}
