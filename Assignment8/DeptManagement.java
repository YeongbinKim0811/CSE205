//Assignment: ASU CSE205 Spring 2021 #8
//Name: Yeongbin Kim
//StudentID: 1217898110
//Lecture: T/TH 4:30 - 5:45
//Description: The DeptManagement class provides various methods that 
               //interact with department management system.

import java.io.Serializable;
import java.util.ArrayList;
//import all other necessary classes

public class DeptManagement implements Serializable
{
	ArrayList<Department> deptList;     //A list of Department objects in the Department management system

	//Constructor of the DeptManagement class
	public DeptManagement() {
		deptList = new ArrayList<Department>();
	}

	//Search for a Department object in deptList by both its name and University and 
	//return the index of the object if it is found; otherwise return -1;
	public int deptExists(String deptName, String universityName) {
		for (int i = 0; i < deptList.size(); i++)
		{
			if (deptList.get(i).getDeptName().equals(deptName))
			{
				if (deptList.get(i).getUniversity().equals(universityName))
				{
					return i;
				}
				else
				{
					continue;
				}
			}		
		}
		
		return -1;
	}

	//Search for a currentFaculty in Department object in the deptList that have
	//the same firstName, lastName, and academicLevel info.
	public int facultyExists(String firstName, String lastName, String academicLevel) {
		for (int i = 0; i < deptList.size(); i++)
		{
			if (deptList.get(i).getFaculty().getFirstName().equals(firstName) &&
					deptList.get(i).getFaculty().getLastName().equals(lastName) &&
					deptList.get(i).getFaculty().getAcademicLevel().equals(academicLevel))
			{
				return i;
			}
					
		}
		
		return -1;
	}

	//Add a Department object to the deptList and return true if such object is added successfully;
	//otherwise return false
	public boolean addDepartment(String deptName, String university, int numOfMembers, String firstName, String lastName, String academicLevel) {
		Department addDept = new Department(deptName, university, numOfMembers, firstName, lastName, academicLevel);
		DeptNameComparator deptNameComp = new DeptNameComparator();
		for (int i = 0; i < deptList.size(); i++)
		{
			if (deptNameComp.compare(deptList.get(i), addDept) == 0 &&
					deptList.get(i).getUniversity().equals(university))
			{
				return false;
			}
		}
		deptList.add(addDept);
		return true;
	}

	//Remove a Department object to the deptList and return true if such object is 
	//added successfully; otherwise return false
	//***will remove all departments with the same name and university
	public boolean removeDepartment(String deptName, String universityName) {
		int count = 0;
		for (int i = 0; i < deptList.size(); i++)
		{
			if (deptList.get(i).getDeptName().equals(deptName) &&
					deptList.get(i).getUniversity().equals(universityName))
			{
				deptList.remove(i);
				count++;
			}
		}
		
		if (count > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	//Sort the deptList by department names in alphabetical order
	public void sortByDepartmentName() {
		Sorts.sort(deptList, new DeptNameComparator());
	}

	//Sort the deptList by faculty numbers, from the smallest to the largest
	public void sortByFacultyNumbers() {
		Sorts.sort(deptList, new FacultyNumberComparator());
	}

	//Sort the deptList by Department's currentFaculty in the alphabetical order of their 
	//last name and first name
	public void sortByDeptFaculty() {
		Sorts.sort(deptList, new DeptFacultyComparator());
	}

	//List all Department object in deptList
	public String listDepartments() {
		if (deptList == null)
		{
			return "\nNo Department\n\n";
		}
		else
		{
			String result = "\n";
			for (int i = 0; i < deptList.size(); i++)
			{
				result += deptList.get(i).toString();
			}
			result += "\n";
			
			return result;
		}
	}
	
	//Closes the Department management system by making the deptList empty
	public void closeDeptManagement() {
		deptList.clear();
	}
}