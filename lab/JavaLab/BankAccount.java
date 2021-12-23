package java_lab;

import java.util.Scanner;

enum AccountType {
	Savings,
	FixedDeposit
};

class Account {
	private String depositorName;
	private long accountNumber;
	private AccountType accountType;
	private double balance;
	
	public static long numberOfAccount = 0;
	
	public Account(String depositorName, AccountType accountType, double initialBalance) {
		numberOfAccount++;
		this.accountNumber = numberOfAccount;
		this.depositorName = depositorName;
		this.accountType = accountType;
		this.balance = initialBalance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		if (this.accountType == AccountType.FixedDeposit) {
			System.out.println("You cannot withdraw from a fixed deposit account");
			return;
		}
		
		if (this.balance < amount) {
			System.out.println("Insufficient balance. You cannot withdraw from this account");
			return;
		}
		
		balance -= amount;
	}
	
	public void display() {
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		return "Account Number: " + this.accountNumber + "\nName: " + this.depositorName + "\nAccount type: " + this.accountType + "\nBalance : " + this.balance;
	}
}

public class BankAccount {
	
	private static Account accounts[] = new Account[5];
	
	private static void printMenu() {
		System.out.println("1. Deposit");
		System.out.println("2. Withdraw");
		System.out.println("3. Display all account");
		System.out.println("4. Exit");
	}
	
	private static void displayAllAccounts() {
		for (Account a : accounts) {
			a.display();
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter details for account " + (i+1));
			
			System.out.print("Enter name: ");
			String name = s.next();
			
			System.out.print("Enter account type(S/FD): ");
			AccountType accTyp = AccountType.Savings;
			switch(s.next()) {
			case "S" : accTyp = AccountType.Savings;
					   break;
			case "FD": accTyp = AccountType.FixedDeposit;
					   break;
			default:   System.out.println("Invalid input. Defaulting to savings account.");
			}
			
			System.out.print("Enter initial balance: ");
			double balance = s.nextDouble();
			
			accounts[i] = new Account(name, accTyp, balance);
		}
		
		boolean isRunning = true;
		int id;
		double amt;
		
		while (isRunning) {
			printMenu();
			int choice = s.nextInt();
			switch(choice) {
			case 1: displayAllAccounts();
					System.out.print("Enter account number: ");
					id = s.nextInt();
					System.out.print("Enter amount to deposit: ");
					amt = s.nextDouble();
					accounts[id - 1].deposit(amt);
					break;
					
			case 2: displayAllAccounts();
					System.out.print("Enter account number: ");
					id = s.nextInt();
					System.out.print("Enter amount to withdraw: ");
					amt = s.nextDouble();
					accounts[id - 1].withdraw(amt);
					break;
					
			case 3: displayAllAccounts();
					break;
					
			case 4: isRunning = false;
					break;
			}
		}
		
		s.close();
	}
}
