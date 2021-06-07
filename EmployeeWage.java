package empwageobjectbased;

import java.util.Random;

public class EmployeeWage
{	
	public static final int EMP_PRESENT = 2;
	public static final int EMP_PARTTIME_PRESENT = 1;
	public static final int EMP_ABSENT = 0;
		
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
	 * Accepting values from method call.
	 */
	public void employeePresentAbsent(String company, int employeeWagePerHr, int daysInMonth, int maxHrsInMonth) 
	{	
		int employeeHours = 0, totalEmployeeHours = 0, totalWorkingDays = 0, dailyWage, monthlyWage = 0;
		
		while(totalEmployeeHours < maxHrsInMonth && totalWorkingDays < daysInMonth) 
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
			dailyWage = employeeWagePerHr * employeeHours;
			//System.out.println("Employee daily wage is : " + dailyWage + " Rs");
			monthlyWage += dailyWage;
		}
		System.out.println("Employee monthly wage for Company " + company + " " + " is: "+ monthlyWage + " " + " Rs. for" + " " + totalEmployeeHours + " Hr" + " and " + totalWorkingDays + " working days." );
	}
	
	/**
	 * @param args
	 * Creating objects of a class.
	 * Calling different methods with objects if not static.
	 * Passing values while calling method.
	 */
	public static void main(String[] args)
	{
		EmployeeWage employeeWageObj = new EmployeeWage();
		employeeWageObj.welcomeMessage();
		EmployeeWage relianceObject = new EmployeeWage();
		relianceObject.employeePresentAbsent("Reliance", 20, 20, 100);
		EmployeeWage tcsObject = new EmployeeWage();
		tcsObject.employeePresentAbsent("TCS", 10, 15, 80);
		
	}
}
