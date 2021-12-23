package java_lab;

import java.util.Scanner;

class Ballot {
	private int voteFrequency[];
	
	public Ballot() {
		voteFrequency = new int[5];
	}
	
	public void castVote(int idx) {
		if (idx > 5 || idx <= 0) {
			System.out.println("Spoit ballot.");
			return;
		}
		voteFrequency[idx - 1]++;
	}
	
	public void displayResults() {
		int largest = voteFrequency[0], largestIdx = 0;
		for (int i = 0; i < 5; i++) {
			if (voteFrequency[i] > largest) {
				largest = voteFrequency[i];
				largestIdx = i;
			}
			System.out.println("Candidate " + (i+1) + " has " + voteFrequency[i] + " votes.");
		}
		System.out.println("Candidate " + (largestIdx+1) + " won.");
	}
}

public class Election {
	private static void printMenu() {
		System.out.println("1. Caste a vote");
		System.out.println("2. View Results");
		System.out.print("Enter your choice: ");
	}
	
	public static void main(String[] args) {
		Ballot b = new Ballot();
		Scanner s = new Scanner(System.in);
		boolean isRunning = true;
		while (isRunning) {
			int choice, n;
			printMenu();
			choice = s.nextInt();
			switch(choice) {
			case 1: 
				System.out.print("Enter candidate number to vote (1...5): ");
				n = s.nextInt();
				b.castVote(n);
				break;
			case 2:
				b.displayResults();
				isRunning = false;
				break;
			}
		}
		s.close();
	}
}
