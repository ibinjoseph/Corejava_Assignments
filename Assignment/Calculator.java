import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Arithmatic
{
	int num1;
	int num2;
	public Arithmatic(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	abstract void calculate();
	}
class Addition extends Arithmatic
{
	public Addition(int num1, int num2) {
		super(num1, num2);
		// TODO Auto-generated constructor stub
	}



	@Override
	void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Addition"+(num1+num2));
	}

}
class Subtraction extends Arithmatic
{

	public Subtraction(int num1, int num2) {
		super(num1, num2);
		// TODO Auto-generated constructor stub
	}

	@Override
	void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Addition"+(num1-num2));
	}
	
}
class Division extends Arithmatic
{

	public Division(int num1, int num2) {
		super(num1, num2);
		// TODO Auto-generated constructor stub
	}

	@Override
	void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Addition"+(num1/num2));
	}
	
}
class Multi extends Arithmatic
{

	public Multi(int num1, int num2) {
		super(num1, num2);
		// TODO Auto-generated constructor stub
	}

	@Override
	void calculate() {
		// TODO Auto-generated method stub
		System.out.println("Addition"+(num1*num2));
	}
	
}
public class Calculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		System.out.println("Enter the 1st ");
		int num1=Integer.parseInt(br.readLine());
		System.out.println("Enter the 1st ");
		int num2=Integer.parseInt(br.readLine());
		System.out.println("Enter the choice");
		int choice=Integer.parseInt(br.readLine());
Arithmatic arr[]=new Arithmatic[4];
arr[0]=new Addition(num1,num2);
arr[1]=new Subtraction(num1,num2);
arr[2]=new Division(num1,num2);
arr[3]=new Multi(num1,num2);
arr[choice-1].calculate();


	}

}
