package emailapp;

import java.util.Scanner;

public class Email {
	
	private int mailboxCapacity = 10;
	private int defaultPasswordLength = 10;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String department;
	private String alternateEmail;
	private String companySuffix = "azcompany.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email-created: " + this.firstName + " " + this.lastName);
		
		this.department = setDepartment();
		//System.out.println("Department: " + this.department);
		
		this.password = randomPassword(defaultPasswordLength);
		//System.out.println("Password: " + this.password);
		
		this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
		//System.out.println("Your email: " + this.email);
	}
	
	private String setDepartment() {
		System.out.print("Department codes:\n1 - Sales\n2 - Development\n3 - Accounting\nEnter the department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		in.close();
		if(depChoice == 1) return "Sales";
		else if(depChoice == 2) return "Development";
		else if(depChoice == 3) return "Accounting";
		else return "";
	}
	
	private String randomPassword(int length) {
		String passwordSet = "abcdefghijklmnopqrstuvwxyz!@#$%^&*";
		char[] password = new char[length];
		for(int i=0; i<length; i++) {
			int rand = (int)(Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altemail) {
		this.alternateEmail = altemail;
	}
	
	public void changePassword(String altPassword) {
		this.password = altPassword;
	}
	
	public void showInfo() {
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Department: " + department);
		System.out.println("Email: " + email);
		System.out.println("Mailbox capacity: " + mailboxCapacity);
	}
	
}
