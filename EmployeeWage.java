package empwageobjectbased;

import java.util.Random;

public class EmployeeWage
{	
	public static final int EMP_PRESENT = 2;
	public static final int EMP_PARTTIME_PRESENT = 1;
	public static final int EMP_WAGE_PER_HR = 20;
	
	public static int employeeHours;
	public int dailyWage;
	
	
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
	 * @return 
	 */
	public int employeePresentAbsent() 
	{
		Random random = new Random();
		int randomNumber = random.nextInt(3);
		
		if(EMP_PRESENT == randomNumber) 
		{
			System.out.println("Employee Is Present.");
			employeeHours = 8;
			
		}
		else if(EMP_PARTTIME_PRESENT == randomNumber)
		{
			System.out.println("Employee Is Part Time Present.");
			employeeHours = 4;
		}
		else
		{
			System.out.println("Employee Is Absent.");
			employeeHours = 0;
		}
		return employeeHours;
	}
	
	/**
	 * @param employeeHour
	 * @param EMP_WAGE_PER_HR
	 * Calculating: Daily wage.
	 * Wage per/hr is 20.
	 */
	public void employeeDailyWage(int EMP_WAGE_PER_HR, int employeeHours) 
	{
		dailyWage = (EMP_WAGE_PER_HR * employeeHours);
		System.out.println("Employee daily wage is : "+dailyWage);
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
		employeeWageObj.employeeDailyWage(EMP_WAGE_PER_HR,employeeHours);
	}
}
