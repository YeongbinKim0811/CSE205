// Assignment #: 5
// Arizona State University - CSE205
//         Name: Yeongbin Kim
//    StudentID: 1217898110
//      Lecture: T-TH 4:30 - 5:45
//  Description: This class is a subclass of Student class. It represents a graduate student.

import java.text.DecimalFormat;

public class Graduate extends Student {

	private double gradFee;     //Graduate fee for a graduate student
	
	public Graduate(String fName, String lName, String id, int credits, double rate, double gradFee) {     //a constructor of this class
		super(fName, lName, id, credits, rate);
		this.gradFee = gradFee;
		super.tuition = 0.0;
	}

	@Override
	public void computeTuition() {     //a method that computes tuition fee
		super.tuition = (super.rate * super.numCredit + this.gradFee);	
	}
	
	public String toString() {
		DecimalFormat money = new DecimalFormat("$##,##0.00");     //Use DecimalFormat class to format the rate and tuition amount
		return "\nGraduate Student:"
				+ super.toString()
				+ "Grad Fee:\t\t" + money.format(this.gradFee) + "\n";
	}

}
