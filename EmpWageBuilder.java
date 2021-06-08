package empwageobjectbased;

import java.util.Random;

public class EmpWageBuilder
{	
	public static final int EMP_PRESENT = 2;
	public static final int EMP_PARTTIME_PRESENT = 1;
	public static final int EMP_ABSENT = 0;
	
	private final String COMPANY;
	private final int EMPLOYEE_WAGE_PER_HR;
	private final int DAYS_IN_MONTH;
	private final int MAX_HRS_IN_MONTH;
	private int monthlyWage;
	
	/**
	 * @param company
	 * @param employeeWagePerHr
	 * @param daysInMonth
	 * @param maxHrsInMonth
	 * Initializing the instance variables.
	 */
	public EmpWageBuilder(String company, int employeeWagePerHr, int daysInMonth, int maxHrsInMonth)
	{
		this.COMPANY = company;
		this.EMPLOYEE_WAGE_PER_HR = employeeWagePerHr;
		this.DAYS_IN_MONTH = daysInMonth;
		this.MAX_HRS_IN_MONTH = maxHrsInMonth;
	}
	
	/**
	 * Checking Employee is full time present, part time present or absent.
	 * Using RANDOM() to attendance check.
	 * Accepting values from method call.
	 */
	public void computeEmployeeWage() 
	{	
		int employeeHours = 0, totalEmployeeHours = 0, totalWorkingDays = 0, dailyWage; 
		
		while(totalEmployeeHours < MAX_HRS_IN_MONTH && totalWorkingDays < DAYS_IN_MONTH) 
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
			dailyWage = EMPLOYEE_WAGE_PER_HR * employeeHours;
			//System.out.println("Employee daily wage is : " + dailyWage + " Rs");
			monthlyWage += dailyWage;
		}
		//System.out.println("Employee monthly wage for Company " + company + " " + " is: "+ monthlyWage + " " + " Rs. for" + " " + totalEmployeeHours + " Hr" + " and " + totalWorkingDays + " working days." );
	}
	
	@Override
	public String toString() 
	{
		return "Employee monthly wage for Company " + COMPANY + " " + " is: "+ monthlyWage + " " + " Rs.";
	}
	
	/**
	 * @param args
	 * Creating objects of a class.
	 * Calling different methods with objects if not static.
	 * Passing values while calling method.
	 */
	public static void main(String[] args)
	{
		EmpWageBuilder airIndia = new EmpWageBuilder("AirIndia", 20, 25, 80);
		EmpWageBuilder bata = new EmpWageBuilder("BATA", 15, 20, 100);
		airIndia.computeEmployeeWage();
		System.out.println(airIndia);
		bata.computeEmployeeWage();
		System.out.println(bata);
		
	}
}
