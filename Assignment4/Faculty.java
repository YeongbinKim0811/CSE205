public class Faculty {
	private String firstName;	//The first name of the Faculty
	private String lastName;	//The last name of the Faculty
	private String academicLevel;	//The academic level of the Faculty such as senior, junior, etc.
	
	public Faculty() {
		this.firstName = "?";
		this.lastName = "?";
		this.academicLevel = "?";
	}
	
	public String getFirstName() {	//a method that returns firstName
		return firstName;
	}
	
	public String getLastName() {	//a method that returns lastName
		return lastName;
	}
	
	public String getAcademicLevel() {	//a method that returns academicLevel
		return academicLevel;
	}
	
	public void setFirstName(String someFirstName) {	//a method that sets firstName
		this.firstName = someFirstName;
	}
	
	public void setLastName(String someLastName) {	//a method that sets lastName
		this.lastName = someLastName;
	}
	
	public void setAcademicLevel(String someLevel) {	//a method that sets academicLevel
		this.academicLevel = someLevel;
	}
	
	public String toString() {
		return lastName + "," + firstName + "(" + academicLevel+ ")";
	}
}
