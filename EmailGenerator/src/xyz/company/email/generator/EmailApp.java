package xyz.company.email.generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmailApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PersonalData person = new PersonalData();
		
		System.out.println("***XYZ company email generator program***\n");
		
		while (true) {
			System.out.print("Enter your first name: ");
			if (person.setFirstName(br.readLine())) {
				System.out.println();
				break;
			} else
				System.out.println("Your first name isn't correct please retry.\n");
		}

		while (true) {
			System.out.print("Enter your last name: ");
			if (person.setLastName(br.readLine())) {
				System.out.println();
				break;
			} else
				System.out.println("Your last name isn't correct please retry.\n");
		}
		

		System.out.print("Select the number of your department\n 1: System Administrator"
				+ "\n 2: Programmer\n 3: IT Support\n");

		while (true) {
			System.out.print("Enter number: ");
			if(person.setDepartment(br.readLine())) {
				System.out.println();
				break;
			} else 
				System.out.println("Your select number isn't correct please retry.\n");
		}
		
		System.out.println("The program have generated email for you.");
		System.out.println("Your email: " + EmailGeneratorService.generateEmail(person));
		System.out.println("Your password: " + EmailGeneratorService.generatePassword());
		
	}

}
