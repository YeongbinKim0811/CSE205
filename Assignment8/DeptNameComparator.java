//Assignment: ASU CSE205 Spring 2021 #8
//Name: Yeongbin Kim
//StudentID: 1217898110
//Lecture: T/TH 4:30 - 5:45
//Description: This is a class to list departments' names in alphabetical order.

import java.util.*;

public class DeptNameComparator implements Comparator<Department> {

	@Override
	public int compare(Department first, Department second) {
		if (((first.getDeptName()).compareTo((second.getDeptName()))) < 0)
		{
			return -1;
		}
		else if (((first.getDeptName()).compareTo((second.getDeptName()))) > 0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

}
