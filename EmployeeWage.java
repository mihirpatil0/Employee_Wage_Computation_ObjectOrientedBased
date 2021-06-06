package empwageobjectbased;

import java.util.Random;

public class EmployeeWage
{	
	public static final int EMP_PRESENT = 2;
	public static final int EMP_PARTTIME_PRESENT = 1;
	public static final int EMP_ABSENT = 0;
	public static final int EMP_WAGE_PER_HR = 20;
	public static final int DAY_IN_MONTH = 20;
	
	public static int employeeHours;
	public static int dailyWage;
	public int monthlyWage;
	
	
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
		
		switch (randomNumber) 
		{
			case EMP_PRESENT: 
			{
				System.out.println("Employee Is Full Time Present.");
				employeeHours = 8;
				break;
			}
			case EMP_PARTTIME_PRESENT: 
			{
				System.out.println("Employee Is Part Time Present.");
				employeeHours = 4;
				break;
			}
			case EMP_ABSENT: 
			{
				System.out.println("Employee Is Absent.");
				employeeHours = 0;
				break;
			}
		default:
			throw new IllegalArgumentException("Unexpected value: " + randomNumber);
		}
		return employeeHours;
	}
	
	/**
	 * @param employeeHour
	 * @param EMP_WAGE_PER_HR
	 * Calculating: Daily wage.
	 * Wage per/hr is 20.
	 */
	public int employeeDailyWage(int EMP_WAGE_PER_HR, int employeeHours) 
	{
		dailyWage = (EMP_WAGE_PER_HR * employeeHours);
		System.out.println("Employee daily wage is : "+dailyWage);
		return dailyWage;
	}
	
	/**
	 * @param dailyWage
	 * Calculating: Monthly wage.
	 */
	public void employeeMonthlyWage(int dailyWage)
	{
		monthlyWage = (DAY_IN_MONTH * dailyWage);
		System.out.println("Employee monthly wage is : "+monthlyWage);
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
		employeeWageObj.employeeMonthlyWage(dailyWage);
	}
}
