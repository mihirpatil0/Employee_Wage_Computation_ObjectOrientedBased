package empwageobjectbased;

public interface IComputeEmpWage
{
	public void addCompanyEmpWage(String company, int employeeWagePerHr, int daysInMonth, int maxHrsInMonth);
	public void computeEmployeeWage();
	
}
