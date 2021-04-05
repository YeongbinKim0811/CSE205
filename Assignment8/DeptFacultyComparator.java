//Assignment: ASU CSE205 Spring 2021 #8
//Name: Yeongbin Kim
//StudentID: 1217898110
//Lecture: T/TH 4:30 - 5:45
//Description: This is a class to list faculties' names in alphabetical order.

import java.util.*;

public class DeptFacultyComparator implements Comparator<Department>
{
	//First we compare the currentFaculty's last name, if they are same, we then compare
	//their first names. The departments should be listed in the alphabetical order of the
	//currentFaculty's last and first names
	public int compare(Department first, Department second)
	{
		if (((first.getFaculty()).getLastName()).compareTo(((second.getFaculty()).getLastName())) < 0)
		{
			return -1;
		}
		else if (((first.getFaculty()).getLastName()).compareTo(((second.getFaculty()).getLastName())) > 0)
		{
			return 1;
		}
		else
		{
			if (((first.getFaculty()).getFirstName()).compareTo(((second.getFaculty()).getFirstName())) < 0)
			{
				return -1;
			}
			else if (((first.getFaculty()).getFirstName()).compareTo(((second.getFaculty()).getFirstName())) > 0)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
}
