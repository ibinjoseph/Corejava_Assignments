import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class EmployeeVo
{
	int empid;
	String empname;
	double annualIncome;
	double IncomeTax;
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public double getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}
	public double getIncomeTax() {
		return IncomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		IncomeTax = incomeTax;
	}
	@Override
	public String toString() {
		return "EmployeeVo [empid=" + empid + ", empname=" + empname + ", annualIncome=" + annualIncome + ", IncomeTax="
				+ IncomeTax + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(annualIncome);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeVo other = (EmployeeVo) obj;
		if (Double.doubleToLongBits(annualIncome) != Double.doubleToLongBits(other.annualIncome))
			return false;
		return true;
	}
	public EmployeeVo(int empid, String empname, double annualIncome, double incomeTax) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.annualIncome = annualIncome;
		IncomeTax = incomeTax;
	}
	
}
class EmployeeBo
{
	void calIncomeTax(EmployeeVo E1)
	{
		E1.IncomeTax=E1.annualIncome*.10;
		
}
}
class EmployeeSort implements Comparator<EmployeeVo>
{

	
	

	@Override
	public int compare(EmployeeVo o1, EmployeeVo o2) {
		int retvalue=0;
		if(o1.getIncomeTax()<o2.getIncomeTax())
		retvalue=1;
		else
			if(o1.getIncomeTax()>o2.getIncomeTax())
				retvalue=-1;
			else
			 retvalue=0;
		
		return retvalue;
	}
	
}
public class EmployeeMain {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int empid;
		String empname;
		double annualIncome,IncomeTax=0.0;
	System.out.println("Enter the number of Employees");
	int num1=Integer.parseInt(br.readLine());
	ArrayList<EmployeeVo> a=new ArrayList<EmployeeVo>(num1);
	for (int j = 0; j < num1; j++) {
		System.out.println("Enter the Employee ID");
		empid=Integer.parseInt(br.readLine());
		System.out.println("Enter the Employee Name");
		empname=br.readLine();
		System.out.println("Enter the annual Income");
		annualIncome=Double.parseDouble(br.readLine());
		
		a.add(new EmployeeVo(empid, empname, annualIncome, IncomeTax));
		EmployeeBo eb=new EmployeeBo();
		eb.calIncomeTax(a.get(j));
	}
	System.out.println(a);
		
	Collections.sort(a, new EmployeeSort());	
		
		System.out.println(a);
	}
	
	
	}


