package empwageobjectbased;

import java.util.Random;

public class EmployeeWage
{	
	public static final int EMP_PRESENT = 2;
	public static final int EMP_PARTTIME_PRESENT = 1;
	public static final int EMP_ABSENT = 0;
	public static final int EMP_WAGE_PER_HR = 20;
	public static final int DAY_IN_MONTH = 20;
	public static final int MAX_HR_IN_MONTH = 100;
	
	public int employeeHours = 0;
	public int totalEmployeeHours = 0;
	public int totalWorkingDays = 0;
	public int dailyWage;
	public int monthlyWage;
		
	/**
	 * Displaying Welcome Message.
	 */
	private void welcomeMessage() 
	{
		System.out.println("Welcome to Employee Wage Computation Problem .");
	}
	
	/**
	 * Checking Employee is full time present, part time present or absent.
	 * Using RANDOM() to attendance check.
	 * Checking for employee working for 100hr or 20 days in a month.
	 * Calculating Daily wage.
	 * Calculating monthly wage according to 100hr or 20 days condition.
	 */
	public void employeePresentAbsent() 
	{	
		while(totalEmployeeHours < MAX_HR_IN_MONTH && totalWorkingDays < DAY_IN_MONTH) 
		{	
			totalWorkingDays ++;
			Random random = new Random();
			int randomNumber = random.nextInt(3);
			
			switch (randomNumber) 
			{
				case EMP_PRESENT: 
				{
					employeeHours = 8;
					break;
				}
				case EMP_PARTTIME_PRESENT: 
				{
					employeeHours = 4;
					break;
				}
				case EMP_ABSENT: 
				{
					employeeHours = 0;
					break;
				}
			default:
				throw new IllegalArgumentException("Unexpected value: " + randomNumber);
			}
			totalEmployeeHours += employeeHours;
			dailyWage = EMP_WAGE_PER_HR * employeeHours;
			System.out.println("Employee daily wage is : " + dailyWage + " Rs");
			monthlyWage += dailyWage;
		}
		System.out.println("Employee monthly wage is : " + monthlyWage + " Rs for " + totalEmployeeHours + " Hr" + " and " + totalWorkingDays + " working days." );
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
