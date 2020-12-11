package menus;

import java.util.Scanner;

public class BankMenu {
	enum UserType { Customer, Employee };
	enum CustomerOption { };
	enum UserOption { Login, Register };
	Scanner userInput;
	
	public BankMenu() {
		userInput = new Scanner(System.in);
	}
	
	public void welcome() {
		System.out.println("Hello. Welcome to the Revature bank.");
	}
	
	public String getUsername() {
		System.out.println("enter your username:");
		return userInput.nextLine();
	}
	
	public String getPassword() {
		System.out.println("enter your password:");
		return userInput.nextLine();
	}
	
	public CustomerOption getCustomerOption() {
		
	}
	
	public UserOption getUserOption() {		
		UserOption userOption = UserOption.Login;
		boolean success = false;
		while(!success) {
			try {
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input) - 1;
				switch(choice) {
					case 0: 
						userOption = UserOption.Login;
						success = true; 
						break;
					case 1: 
						userOption = UserOption.Register;
						success = true;
						break;
					default: throw new NumberFormatException();
				}
			} catch(NumberFormatException e) {
				System.out.println("Not a valid choice. Try again");
				success = false;
			}
		}
		
		return userOption;
	}
	
	public UserType getUserType() {
		System.out.println("enter the login option number:");
		System.out.println("1) employee \n2) customer");
		
		UserType res = UserType.Customer;
		boolean success = false;
		while(!success) {
			try {
				String input = userInput.nextLine();
				int choice = Integer.parseInt(input) - 1;
				switch(choice) {
					case 0: 
						res = UserType.Employee; 
						success = true; 
						break;
					case 1: 
						res = UserType.Customer;
						success = true;
						break;
					default: throw new NumberFormatException();
				}
			} catch(NumberFormatException e) {
				System.out.println("Not a valid choice. Try again");
				success = false;
			}
		}
		
		return res;
	}
}
