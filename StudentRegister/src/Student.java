import java.util.regex.Pattern;

public class Student {
	private String firstName, lastName, studentId, degree, major;
	private String[] collegeMajor = {"Computer Science", "Software Engineer", "Information Technology"};
	private String[] collegeDegree = {"Bachelor's degree", "Master's degree"};

	Student() {
		firstName = "Unknown";
		lastName = "Unknown";
		studentId = "Unknown";
		degree = "Unknown";
		major = "Unknown";
	}

	public String getFirstName() {
		return firstName;
	}

	public boolean setFirstName(String firstName) {
		// Check that first name not contain any number
		if (Pattern.compile("[0-9]").matcher(firstName).find())
			return false;

		this.firstName = firstName.trim().substring(0, 1).toUpperCase() + firstName.trim().substring(1);
		return true;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean setLastName(String lastName) {
		// Check that last name not contain any number
		if (Pattern.compile("[0-9]").matcher(lastName).find())
			return false;

		this.lastName = lastName.trim().substring(0, 1).toUpperCase() + lastName.trim().substring(1);
		return true;
	}

	public String getStudentId() {
		return studentId;
	}

	private void setStudentId() {
		if(degree.equals("Bachelor's degree"))
			studentId = "1001";
		else
			studentId = "2001";
	}

	public String getDegree() {
		return degree;
	}

	public boolean setDegree(String selectNumber) {
		int select;
		try {
			select = Integer.parseInt(selectNumber);
		} catch (NumberFormatException error) {
			return false;
		}
		
		if(select > 0 && select <= collegeDegree.length) {
			degree = collegeDegree[select-1];
			setStudentId();
			return true;
		} else {
			return false;
		}
	}

	public String getMajor() {
		return major;
	}

	public boolean setMajor(String selectNumber) {
		int select;
		try {
			select = Integer.parseInt(selectNumber);
		} catch (NumberFormatException error) {
			return false;
		}
		
		if(select > 0 && select <= collegeMajor.length) {
			major = collegeMajor[select-1];
			return true;
		} else {
			return false;
		}
	}

}
