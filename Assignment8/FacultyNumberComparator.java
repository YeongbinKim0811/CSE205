//Assignment: ASU CSE205 Spring 2021 #8
//Name: Yeongbin Kim
//StudentID: 1217898110
//Lecture: T/TH 4:30 - 5:45
//Description: This is a class to compare the number of faculty.

import java.util.*;

public class FacultyNumberComparator implements Comparator<Department> {

	@Override
	public int compare(Department first, Department second) {
		if (first.getNumOfMembers() < second.getNumOfMembers())
		{
			return -1;
		}
		else if (first.getNumOfMembers() > second.getNumOfMembers())
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}

}
