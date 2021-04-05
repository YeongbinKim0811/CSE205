// Assignment #: 5
// Arizona State University - CSE205
//         Name: Yeongbin Kim
//    StudentID: 1217898110
//      Lecture: T-TH 4:30 - 5:45
//  Description: The Student class represents the basic attributes of any student in a university.

import java.text.DecimalFormat;

public abstract class Student {
	protected String firstName;     //First name of the student
	protected String lastName;     //Last name of the student
	protected String studentID;     //Student ID of the student
	protected int numCredit;     //Number of Credits that the student is taking
	protected double rate;     //Tuition rate for the student
	protected double tuition = 0.0;     //Tuition amount for each student to be computed
	
	public Student (String fName, String lName, String id, int credits, double rate) {     //a constructor of this class
		this.firstName = fName;
		this.lastName = lName;
		this.studentID = id;
		this.numCredit = credits;
		this.rate = rate;
	}
	
	public int getNumCredit() {     //a method that returns numCredit
		return numCredit;
	}
	
	public abstract void computeTuition();     //an abstract method
	
	public String toString() {
		DecimalFormat money = new DecimalFormat("$##,##0.00");     //Use DecimalFormat class to format the rate and tuition amount
		return "\nFirst name:\t\t" + firstName + "\n"
				+ "Last name:\t\t" + lastName + "\n"
				+ "Student ID:\t\t" + studentID + "\n"
				+ "Credits:\t\t" + numCredit + "\n"
				+ "Rate:\t\t\t" + money.format(rate) + "\n"
				+ "Tuition:\t\t" + money.format(tuition) + "\n";
	}
}
