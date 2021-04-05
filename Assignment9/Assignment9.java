//  Assignment: ASU CSE205 Spring 2021 #9
//  Name: Yeongbin Kim
//  StudentID: 1217898110
//  Lecture: T/TH 4:30 - 5:45
//  Description: The Assignment 9 class reads a sequence of integers from input,
//  and compute the maximum, counts numbers divisible by 3, sum of numbers larger than the last, and
//  compute the largest even integer in the sequence using recursion.
import java.io.*;

public class Assignment9 {
	public static void main(String[] args) {	
		// Declare integers and int array to store information
		int num, even, max, count, sum, i = 0;
		int[] numbers = new int[100];

		// Try-Catch block for input stream and buffered reader IO exceptions
		try {
			// Create an input stream reader and buffered reader object
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			// while or do-While loop to store all integers in the array until 0
   			// read in the number as a string and parse to an integer and assign it to array element
			do {
				num = Integer.parseInt(br.readLine());
				if (num != 0)
				{
					numbers[i] = num;
					i++;
				}
			} while (num != 0);     // Continue iterating until 0 is entered
		} //end of try block
		
		// Catch an IO Exception and print out it occurred
		catch(IOException ex) {
			System.out.println("IO Exception");
		}
         
		// Call recursive functions to calculate max, countEven, largeEven, and sum
		max = findMax(numbers, 0, i-1);
		even = largestEven(numbers, 0, i-1);
		count = countDivisibleBy3(numbers, 0, i-1);
		sum = sumLargerThanLast(numbers, 0, i-1, numbers[i-1]);
		
		// Print out results in required format
		System.out.println("The maximum number is " + max);
		System.out.println("The largest even integer in the sequence is " + even);
		System.out.println("The count of numbers divisible by 3 is " + count);
		System.out.println("The sum of numbers larger than the last is " + sum);
	}	// End main method

	// Recursive static method to find maximum array value
	public static int findMax(int[] nums, int startIndex, int endIndex) {
         int max;
         if (startIndex == endIndex)
         {
        	 return nums[startIndex];
         }
         else
         {
        	 max = findMax(nums, startIndex+1, endIndex);	//recursive
        	 if (nums[startIndex] >= max)
        	 {
        		 max = nums[startIndex];
        	 }
        	 return max;
         }
	}	// End findMax method	
	
	// Recursive static method to find the largest even number in the array
    public static int largestEven(int[] nums, int startIndex, int endIndex) {
    	int maxEven;
        if (startIndex == endIndex && nums[startIndex] % 2 == 0)
        {
        	return nums[startIndex];
        }
        else if (startIndex == endIndex && nums[startIndex] % 2 != 0)	//If there is no even number in array, return -99
        {
        	return -99;
        }
        else
        {
        	maxEven = largestEven(nums, startIndex+1, endIndex);	//recursive
        	if (nums[startIndex] >= maxEven && nums[startIndex] % 2 == 0)
        	{
        		maxEven = nums[startIndex];
        	}
        	return maxEven;
        }
	}	// End computeLargestEven method

    // Recursive static method to find the number of integers that can be divisible by 3
	public static int countDivisibleBy3(int[] nums, int startIndex, int endIndex)
	{
		int count = 0;
		if (startIndex == endIndex && nums[startIndex] % 3 == 0)
		{
			count++;
			return count;
		}
		else if (startIndex == endIndex && nums[startIndex] % 3 != 0)
		{
			return count;
		}
		else
		{
			count = countDivisibleBy3(nums, startIndex+1, endIndex);	//recursive
			if (nums[startIndex] % 3 == 0)
			{
				count++;
			}
			return count;
		}
	} //end countDivisibleBy3
	  
	// Recursive static method to find the sum of all numbers larger than the last number in the array
	public static int sumLargerThanLast(int[] nums, int startIndex, int endIndex, int lastNumber) {
		int sum;
		if (startIndex == endIndex)
		{
			return 0;
		}
		else
		{
			sum = sumLargerThanLast(nums, startIndex+1, endIndex, lastNumber);	//recursive
			if (nums[startIndex] > lastNumber)
			{
				sum += nums[startIndex];
			}
			return sum;
		}
	}	// End sumOfNumbersLargerThanFirst method
}//end Assignment9 class