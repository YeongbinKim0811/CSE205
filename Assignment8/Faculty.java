//Assignment: ASU CSE205 Spring 2021 #8
//Name: Yeongbin Kim
//StudentID: 1217898110
//Lecture: T/TH 4:30 - 5:45
//Description: The Faculty class implements the Serializable interface so that 
//             its object can be stored as one piece.

import java.io.*;

public class Faculty implements Serializable
{
	//private instance variables
	private String firstName, lastName, academicLevel;

	//constructor
	public Faculty(String firstName, String lastName, String academicLevel)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.academicLevel = academicLevel;
	}

	//gets firstName
	public String getFirstName() {
		return firstName;
	}

	//gets lastName
	public String getLastName() {
		return lastName;
	}

	//gets AcademicLevel
	public String getAcademicLevel() {
		return academicLevel;
	}

	//sets firstName to the specified string
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//sets lastName to the specified string
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	//sets academicLevel to the specified string
	public void setAcademicLevel(String level) {
		academicLevel = level;
	}

	//return a string in the specified format
	public String toString() {
		return firstName + " " + lastName + ", " + academicLevel;
	}
}
