
public class Department {
	private String name;	//The name of the Department
	private int numberOfMembers;	//The number of members of the Department
	private String university;     //The university the Department belongs to
	private Faculty currentFaculty;     //The current Faculty of the Department
	
	public Department() {     //default constructor
		this.name = "?";
		this.numberOfMembers = 0;
		this.university = "?";
		this.currentFaculty = new Faculty();
	}
	
	public String getDeptName() {     //a method that returns name
		return name;
	}
	
	public int getNumberOfMembers() {     //a method that returns numberOfMembers
		return numberOfMembers;
	}
	
	public String getUniversity() {     //a method that returns university
		return university;
	}
	
	public Faculty getCurrentFaculty() {     //a method that returns current faculty
		return currentFaculty;
	}
	
	public void setDeptName(String someName) {     //a method that sets name
		this.name = someName;
	}
	
	public void setNumberOfMembers(int someNumber) {     //a method that sets number of members
		this.numberOfMembers = someNumber;
	}
	
	public void setUniversity(String someUniversity) {     //a method that sets university
		this.university = someUniversity;
	}
	
	public void setCurrentFaculty(String firstName, String lastName, String someLevel) {     //a method that sets current facultyd
		currentFaculty.setFirstName(firstName);
		currentFaculty.setLastName(lastName);
		currentFaculty.setAcademicLevel(someLevel);
	}
	
	public String toString() {
		return "\nDepartment Name:\t\t" + name + "\n" +
				"Number Of Members:\t" + numberOfMembers + "\n" +
				"University:\t\t" + university + "\n" +
				"Faculty:\t\t" + currentFaculty.toString() + "\n\n";
	}
}
