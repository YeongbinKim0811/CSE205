//Assignment: ASU CSE205 Spring 2021 #8
//Name: Yeongbin Kim
//StudentID: 1217898110
//Lecture: T/TH 4:30 - 5:45
//  Description: This class sorts the objects in the comparator classes.

import java.util.Comparator;
import java.util.ArrayList;

public class Sorts
{
	//Use insertion sort
	public static void sort(ArrayList<Department> deptList, Comparator<Department> xComparator) {
		for (int index = 1; index < deptList.size(); index++)
		{
			Department key = deptList.get(index);
			int position = index;
			
			//Shift larger values to the right
			while (position > 0 && xComparator.compare(deptList.get(position-1), key) > 0)
			{
				deptList.set(position, deptList.get(position-1));
				position--;
			}
			
			deptList.set(position, key);
		}
	} //end sort
} //end class Sorts
