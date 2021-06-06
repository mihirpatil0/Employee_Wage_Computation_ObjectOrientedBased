package empwageobjectbased;

import java.util.Random;

public class EmployeeWage
{	
	public static final int EMP_PRESENT = 1;
	
	/**
	 * Displaying Welcome Message.
	 */
	private void welcomeMessage() 
	{
		System.out.println("Welcome to Employee Wage Computation Problem .");
	}
	
	/**
	 * Checking Employee is present or absent.
	 * Using RANDOM() to attendance check.
	 */
	public void employeePresentAbsent() 
	{
		Random random = new Random();
		int randomNumber = random.nextInt(2);
		
		if(EMP_PRESENT == randomNumber) 
		{
			System.out.println("Employee Is Present.");
		}
		else
		{
			System.out.println("Employee Is Absent.");
		}
	}
	
	/**
	 * @param args
	 * Creating objects of a class.
	 * Calling different methods with objects if not static. 
	 */
	public static void main(String[] args)
	{
		EmployeeWage employeeWageObj = new EmployeeWage();
		employeeWageObj.welcomeMessage();
		employeeWageObj.employeePresentAbsent();
	}
}
