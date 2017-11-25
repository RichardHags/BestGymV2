package BestGym;

import java.time.LocalDate;

public class Customer {
	
	protected String name;
	protected String DateOfBirth;
	protected LocalDate membershipDate;
	
	public Customer (String dateOfBirth, String name, LocalDate membershipDate) {
		this.name = name;
		this.DateOfBirth = dateOfBirth;
		this.membershipDate = membershipDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public LocalDate getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(LocalDate membershipDate) {
		this.membershipDate = membershipDate;
	}
	
	public boolean hasCustomerPaid() {
		LocalDate todaysDate = LocalDate.now();
		LocalDate aYearFromNow = todaysDate.minusYears(1);
		if (membershipDate.isAfter(aYearFromNow)) {
			return true;
		} else {
			return false;
		}
	}

}
