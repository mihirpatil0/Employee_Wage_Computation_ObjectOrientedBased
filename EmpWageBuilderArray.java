package empwageobjectbased;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class EmpWageBuilderArray implements IComputeEmpWage
{	
	public static final int EMP_PRESENT = 2;
	public static final int EMP_PARTTIME_PRESENT = 1;
	public static final int EMP_ABSENT = 0;
	
	private int numberOfCompany = 0;
	private LinkedList<CompanyEmpWage> companyEmpWagesList;
	private Map<String,CompanyEmpWage> companyEmpWagesMap;
	
	/**
	 * Constructor initializing LinkedList and HashMap.
	 */
	public EmpWageBuilderArray()
	{
		companyEmpWagesList = new LinkedList<>();
		companyEmpWagesMap = new HashMap();
	}
	
	public void addCompanyEmpWage(String company, int employeeWagePerHr, int daysInMonth, int maxHrsInMonth)
	{
		CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, employeeWagePerHr, daysInMonth, maxHrsInMonth);
		
		companyEmpWagesList.add(companyEmpWage);
		companyEmpWagesMap.put(company, companyEmpWage);
	}
	
	public void computeEmployeeWage()
	{
		for(int i = 0; i < companyEmpWagesList.size(); i++ )
		{
			CompanyEmpWage companyEmpWage = companyEmpWagesList.get(i);
			companyEmpWage.setTotalEmpWage(this.computeEmployeeWage(companyEmpWage));
			System.out.println(companyEmpWage);
		}
	}
	
	/**
	 * Checking Employee is full time present, part time present or absent.
	 * Using RANDOM() to attendance check.
	 * Calculating employee monthly wage.
	 */
	 private int computeEmployeeWage(CompanyEmpWage companyEmpWage) 
	{	
		int employeeHours = 0, totalEmployeeHours = 0, totalWorkingDays = 0; 
		
		while(totalEmployeeHours <= companyEmpWage.MAX_HRS_IN_MONTH && totalWorkingDays < companyEmpWage.DAYS_IN_MONTH) 
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
			System.out.println("Days : "+ totalWorkingDays +" Employee Hr: "+employeeHours);
		}
		return totalEmployeeHours * companyEmpWage.EMPLOYEE_WAGE_PER_HR;
	}
	 
	 /**
	 *Method for total employee wage.
	 */
	public int getTotalWage(String company)
	 {
		 return companyEmpWagesMap.get(company).monthlyWage;
	 }
	
	/**
	 * @param args
	 * Creating objects of a class.
	 * Calling different methods with objects if not static.
	 * Passing values while calling method.
	 */
	public static void main(String[] args)
	{	
		IComputeEmpWage empWageBuilder = new EmpWageBuilderArray();
		empWageBuilder.addCompanyEmpWage("Reliance", 20, 25, 100);
		empWageBuilder.addCompanyEmpWage("Bata", 18, 20, 86);
		empWageBuilder.computeEmployeeWage();
		System.out.println("Total Wage for Bata Company: "+empWageBuilder.getTotalWage("Bata"));
	}
}
