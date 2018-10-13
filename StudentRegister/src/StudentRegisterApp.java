import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StudentRegisterApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Student student = new Student();

		System.out.println("***Student register&enroll course application***\n");

		while (true) {
			System.out.print("Enter your first name: ");
			if (student.setFirstName(br.readLine())) {
				System.out.println();
				break;
			} else
				System.out.println("Your first name isn't correct please retry.\n");
		}

		while (true) {
			System.out.print("Enter your last name: ");
			if (student.setLastName(br.readLine())) {
				System.out.println();
				break;
			} else
				System.out.println("Your last name isn't correct please retry.\n");
		}

		System.out.print("Select the number of your major\n 1: Computer Science"
				+ "\n 2: Software Engineer\n 3: Information Technology\n");

		while (true) {
			System.out.print("Enter number: ");
			if (student.setMajor((br.readLine()))) {
				System.out.println();
				break;
			} else
				System.out.println("Your select number isn't correct please retry.\n");
		}

		System.out.print("Select the number of your degree\n 1: Bachelor's degree" + "\n 2: Master's degree\n");

		while (true) {
			System.out.print("Enter number: ");
			if (student.setDegree((br.readLine()))) {
				System.out.println();
				break;
			} else
				System.out.println("Your select number isn't correct please retry.\n");
		}

		System.out.println("All course of your major that you can enroll");
		EnrollCourseService.availableCourse(student);

		while (true) {
			ArrayList<Course> availableCourse = EnrollCourseService.getAvailableCourse();

			for (int i = 0; i < availableCourse.size(); i++)
				System.out.println((i + 1) + ": " + availableCourse.get(i).getCourseName() + " - " + "enroll cost: "
						+ availableCourse.get(i).getCourseCost());

			System.out.println("0: Quit");
			System.out.print("Enter number: ");
			String userEnter = br.readLine();

			if (userEnter.equals("0")) {
				System.out.println();
				break;
			}

			if (EnrollCourseService.enroll(userEnter)) {
				if (availableCourse.size() == 0) {
					System.out.println();
					break;
				}
				System.out.println();
			} else {
				System.out.println("Your select number isn't correct please retry.\n");
			}
		}

		System.out.println("-Student Information-");
		System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
		System.out.println("ID: " + student.getStudentId());
		System.out.println("Degree: " + student.getDegree());
		System.out.println("Major: " + student.getMajor());
		System.out.print("Enroll in course: ");
		if (EnrollCourseService.getEarnedCourse() != null) {
			System.out.println();
			int i = 0;
			for (Course course : EnrollCourseService.getEarnedCourse())
				System.out.println(" " + (++i) + ". " + course.getCourseName());
		} else {
			System.out.println("None");
		}

		System.out.println("Tuition balance: $" + EnrollCourseService.getTuitionBalance());
	}

}
