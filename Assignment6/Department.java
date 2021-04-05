// Assignment 6: ASU - CSE 205
// Name: Yeongbin Kim
// StudentID: 1217898110
//Lecture Date and Time: T/TH 4:30 - 5:45
//  Description: This is a class for putting the department's information.

public class Department
{
     private String name;
     private int numberOfFaculty;
     private String university;

     public Department()
     {
           name = "?";
           numberOfFaculty = 0;
           university = "?";
     }
     //accesssor method
     public String getDeptName()
     {
           return name;
     }
     public int getNumberOfMembers()
     {
           return numberOfFaculty;
     }
     public String getUniversity()
     {
           return university;
     }

     //mutator methods
     public void setDeptName(String name)
     {
           this.name = name;
     }
     public void setNumberOfMembers(int numFaculty)
     {
           this.numberOfFaculty = numFaculty;
     }
     public void setUniversity(String name)
     {
           this.university = name;
     }

     public String toString()
     {
           return "\nDepartment Name:\t\t" + name + "\nNumber Of Faculty:\t" + numberOfFaculty +
                     "\nUniversity:\t\t" + university + "\n\n";
     }
}

