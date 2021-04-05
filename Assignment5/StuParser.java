// Assignment #: 5
// Arizona State University - CSE205
//         Name: Yeongbin Kim
//    StudentID: 1217898110
//      Lecture: T-TH 4:30 - 5:45
//  Description: This class is a utility class that will be used to create a student object from a string.

public class StuParser {

	public static Student parseStringToStudent(String lineToParse) {
        String[] sArr = lineToParse.split("/");
        if (lineToParse.substring(0, 1).equals("G"))     //return Graduate student
        {
        	Student newStudent = new Graduate(sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4]), Double.parseDouble(sArr[5]), Double.parseDouble(sArr[6]));     //new object
        	return newStudent;
        }
        else
        {
        	if (sArr[6].toUpperCase().equals("INSTATE"))     //return UnderGrad student if the student is in-state student
        	{
        		Student newStudent = new UnderGrad(sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4]), Double.parseDouble(sArr[5]), true, Double.parseDouble(sArr[7]));     //new object
        		return newStudent;
        	}
        	else     //return UnderGrad student if the student is out-state student
        	{
        		Student newStudent = new UnderGrad(sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4]), Double.parseDouble(sArr[5]), false, Double.parseDouble(sArr[7]));     //new object
        		return newStudent;
        	}
        }

	}
}
