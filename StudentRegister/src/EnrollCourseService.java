import java.util.ArrayList;

public class EnrollCourseService {
	private static ArrayList<Course> courseList = new ArrayList<>();
	private static ArrayList<Course> earnedCourse = new ArrayList<>();
	private static int tuitionBalance = 0;

	public static void availableCourse(Student student) {

		if (student.getMajor().equals("Computer Science")) {
			if (student.getDegree().equals("Bachelor's degree")) {
				courseList.add(new Course("Algorithm I", 600));
				courseList.add(new Course("Artifical Intelligence I", 600));
				courseList.add(new Course("Natural Language Processing I", 800));
			} else if (student.getDegree().equals("Master's degree")) {
				courseList.add(new Course("Algorithm II", 1200));
				courseList.add(new Course("Artifical Intelligence II", 1500));
				courseList.add(new Course("Natural Language Processing II", 1200));
			}
		} else if (student.getMajor().equals("Software Engineer")) {
			if (student.getDegree().equals("Bachelor's degree")) {
				courseList.add(new Course("Software Development I", 900));
				courseList.add(new Course("Web Technology I", 600));
				courseList.add(new Course("Object Oriented Analysis And Design I", 800));
			} else if (student.getDegree().equals("Master's degree")) {
				courseList.add(new Course("Software Development II", 1500));
				courseList.add(new Course("Web Technology II", 1800));
				courseList.add(new Course("Object Oriented Analysis And Design II", 1600));
			}
		} else if (student.getMajor().equals("Information Technology")) {
			if (student.getDegree().equals("Bachelor's degree")) {
				courseList.add(new Course("Cloud Fundamental I", 900));
				courseList.add(new Course("Network I", 600));
				courseList.add(new Course("System Security I", 800));
			} else if (student.getDegree().equals("Master's degree")) {
				courseList.add(new Course("Cloud Fundamental II", 1000));
				courseList.add(new Course("Network II", 1200));
				courseList.add(new Course("System Security II", 1600));

			}
		}

	}

	public static boolean enroll(String selectNumber) {
		int select;
		try {
			select = Integer.parseInt(selectNumber);
		} catch (NumberFormatException error) {
			return false;
		}

		if (select > 0 && select <= courseList.size()) {
			tuitionBalance += courseList.get(select - 1).getCourseCost();
			earnedCourse.add(courseList.remove(select - 1));
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Course> getAvailableCourse() {
		return courseList;
	}

	public static ArrayList<Course> getEarnedCourse() {
		if (earnedCourse.size() == 0)
			return null;

		return earnedCourse;
	}

	public static int getTuitionBalance() {
		return tuitionBalance;
	}
}
