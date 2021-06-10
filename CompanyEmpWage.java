package empwageobjectbased;

public class CompanyEmpWage
{
	public final String COMPANY;
	public final int EMPLOYEE_WAGE_PER_HR;
	public final int DAYS_IN_MONTH;
	public final int MAX_HRS_IN_MONTH;
	public int monthlyWage;
	
	/**
	 * @param company
	 * @param employeeWagePerHr
	 * @param daysInMonth
	 * @param maxHrsInMonth
	 * Initializing the instance variables.
	 */
	public CompanyEmpWage(String company, int employeeWagePerHr, int daysInMonth, int maxHrsInMonth)
	{
		this.COMPANY = company;
		this.EMPLOYEE_WAGE_PER_HR = employeeWagePerHr;
		this.DAYS_IN_MONTH = daysInMonth;
		this.MAX_HRS_IN_MONTH = maxHrsInMonth;
	}
	
	public void setTotalEmpWage(int monthlyWage)
	{
		this.monthlyWage = monthlyWage;
	}
	
	@Override
	public String toString()
	{
		return "Employee monthly wage for Company " + COMPANY + " " + " is: "+ monthlyWage + " " + " Rs.";
	}
}
