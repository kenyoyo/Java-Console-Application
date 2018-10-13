public class Course {
	private String courseName;
	private int courseCost;

	Course(String courseName, int courseCost) {
		this.courseName = courseName;
		this.courseCost = courseCost;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseCost() {
		return courseCost;
	}

	public void setCourseCost(int courseCost) {
		this.courseCost = courseCost;
	}
}
