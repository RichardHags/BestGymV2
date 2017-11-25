package BestGym;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class BestGymEverV2 {

	public CustomerHandler customer = new CustomerHandler();
	public Customer gymMember;
	boolean bool = true;
	Scanner sc;
	String inputFromUser;

	BestGymEverV2() {

		int choice = 0;

		System.out.println("1: Se fil-listan på gamla kunder. \n2: Kolla om kunden finns med. \n3: Lägg till ny kund");
		sc = new Scanner(System.in);

		while (bool) { // Meny val
			inputFromUser = sc.nextLine();
			try {
				choice = Integer.parseInt(inputFromUser); // gör om input till en int
				bool = false; // Avslutar while-loopen
			} catch (NumberFormatException e) {
				System.out.println("Du måste ange en siffra.");
				bool = false;
			}
		}

		switch (choice) {

		case 1: // Skriver ut listan på de gamla kunderna
			System.out.println("Listan på gamla kunder: \n--------------------");
			customer.printCustomerList();
			break;

		case 2: // Letar i gamla filen efter kund.
			System.out.println("Namn eller personnummer på kund ");
			inputFromUser = sc.nextLine();
			if (customer.checkIfCustomerExist(inputFromUser.trim())) {
				gymMember = customer.getCustomer(inputFromUser.trim());
				if (gymMember.hasCustomerPaid()) {
					System.out.println(gymMember.getName() + " finns med i listan! \nSparar besöket.");
					customer.saveVisitToFile(gymMember);
				} else {
					System.out.println(gymMember.getName() + " är en föredetta kund. \nBetalade senast: "
							+ gymMember.getMembershipDate());
				}
			} else {
				System.out.println("Kunde ej hitta " + inputFromUser + "\nFanns ej med i filen.");
				System.exit(0);
			}
			break;

		case 3: // Lägger till ny kund, som sen läggs till i text-filen hasTrained
			System.out.println("Ange Namn och personnummer: ");
			String name;
			String dateOfBirth;

			name = sc.nextLine();
			dateOfBirth = sc.nextLine();
			customer.saveVisitToFile(gymMember = new Customer(dateOfBirth, name, LocalDate.now()));
			System.out.println("Kunden har nu sparats i filen.");
			break;

		default:
			System.out.println("Avslutar programmet");
			break;
		}
	}

	public static void main(String[] args) throws IOException {

		BestGymEverV2 x = new BestGymEverV2();
	}
}
