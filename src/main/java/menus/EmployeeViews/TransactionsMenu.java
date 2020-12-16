package menus.EmployeeViews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import menus.Menu;

public class TransactionsMenu extends Menu {

	@Override
	public void manageUserInput() {
		Scanner input;
		try {
			input = new Scanner(new File("logs/transactions.log"));
			while (input.hasNextLine())
			{
			   System.out.println(input.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		displayBackMenu();
	}

}
