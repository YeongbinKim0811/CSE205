// Assignment #: 5
// Arizona State University - CSE205
//         Name: Yeongbin Kim
//    StudentID: 1217898110
//      Lecture: T-TH 4:30 - 5:45
//  Description: This class is a subclass of Student class. It represents an undergraduate student in a university.

import java.text.DecimalFormat;

public class UnderGrad extends Student {

	private boolean inState;     //Its value is true if the student is an in state resident, and false otherwise
	private int creditUpperbound;     //The upper bound of credits. If the number of credits is grater than or equals to this bound, the tuition will not increase
	private double programFee;     //Student program Fee that will be added to the tuition
	
	public UnderGrad(String fName, String lName, String id, int credits, double rate, boolean inState, double programFee) {
		super(fName, lName, id, credits, rate);
		this.inState = inState;
		this.programFee = programFee;
		super.tuition = 0.0;
		if(inState)     //If instate is true, creditUpperbound is 7
		{
			this.creditUpperbound = 7;
		}
		else     //If instate is false, creditUpperbound is 12
		{
			this.creditUpperbound = 12;
		}
	}

	@Override
	public void computeTuition() {
		if (super.numCredit >= this.creditUpperbound)
		{
			super.tuition = super.rate * this.creditUpperbound + this.programFee;
		}
		else
		{
			super.tuition = super.rate * this.numCredit + this.programFee;
		}
	}
	
	public String toString() {
		DecimalFormat money = new DecimalFormat("$##,##0.00");     //Use DecimalFormat class to format the rate and tuition amount
		if (inState)
		{
			return "\nUnderGrad:"
					+ "\nIn-State"
					+ super.toString()
					+ "Student Program Fee:\t" + money.format(programFee) + "\n"; 
		}
		else
		{
			return "\nUnderGrad:"
					+ "\nOut-Of-State"
					+ super.toString()
					+ "Student Program Fee:\t" + money.format(programFee) + "\n";
		}
	}

}
