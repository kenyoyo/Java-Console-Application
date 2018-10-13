package xyz.company.email.generator;

import java.util.regex.Pattern;

public class PersonalData {
	private String firstName, lastName, department;
	private String[] companyDepartment = {"sysad", "prog", "itsup"};
	
	PersonalData() {
		firstName = "Unknown";
		lastName = "Unknown";
		department = "Unknown";
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		// Check that first name not contain any number
		if (Pattern.compile("[0-9]").matcher(firstName).find())
			return false;

		this.firstName = firstName.trim();
		return true;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		// Check that last name not contain any number
		if (Pattern.compile("[0-9]").matcher(lastName).find())
			return false;

		this.lastName = lastName;
		return true;
	}

	public String getDepartment() {
		return department;
	}

	public boolean setDepartment(String selectNumber) {
		int select;
		try {
			select = Integer.parseInt(selectNumber);
		} catch (NumberFormatException error) {
			return false;
		}
		
		if(select > 0 && select <= companyDepartment.length) {
			department = companyDepartment[select-1];
			return true;
		} else {
			return false;
		}
	}
}
