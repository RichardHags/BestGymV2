package BestGym;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerHandler {

	protected File oldCustomers = new File("customers.txt");
	protected List<Customer> listOfCustomers = new ArrayList<>();

	public CustomerHandler() {

		try (Scanner sc = new Scanner(oldCustomers)) {
			while (sc.hasNext()) {
				String temp[] = sc.nextLine().split(",");
				String dateFromFile = sc.nextLine();
				LocalDate membershipDate = LocalDate.parse(dateFromFile);
				listOfCustomers.add(new Customer(temp[0].trim(), temp[1].trim(), membershipDate));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Kunde ej hitta filen");
		} catch (Exception ae) {
			System.out.println("Nu blev det fel");
		}

	}
	
	public boolean checkIfCustomerExist(String nameOrDate) {
		for (Customer c : listOfCustomers) {
			if (c.getName().equalsIgnoreCase(nameOrDate) 
			 || c.getDateOfBirth().equalsIgnoreCase(nameOrDate)) {
				return true;
			}
		}
		return false;
	}

	public void saveVisitToFile(Customer c) {
		File hasTrained = new File("hasTrained.txt");
		try (PrintWriter printToFile = new PrintWriter(new BufferedWriter(new FileWriter(hasTrained, true)));) {
			printToFile.println(c.getDateOfBirth() + ", " + c.getName() + "." + "\n Tränade senast: " + LocalDate.now());
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException fel!");
		} catch (IOException e1) {
			System.out.println("IOException fel!");
		}
	}
	
	public void printCustomerList() {
		for (Customer c : listOfCustomers) {
			System.out.println(c.getName() + ", " +  c.getDateOfBirth() + "\n" + c.getMembershipDate());
		}
		
	}
	
	public Customer getCustomer(String str) {
		Customer oldCustomer = null;
		for(Customer c : listOfCustomers)
			if(c.getName().equalsIgnoreCase(str) || c.getDateOfBirth().equalsIgnoreCase(str)) {
				oldCustomer = c;
			}
		return oldCustomer;
	}
	

}
