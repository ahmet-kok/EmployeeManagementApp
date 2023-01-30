package application;
	
public class HourlyEmployee extends Employee {
	private double wage;
	private int hours;
	
	public HourlyEmployee(String firstName, String lastName, String SSN, double wage, int hours) {
		super(firstName, lastName, SSN);
		setWage(wage);
		setHours(hours);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double getPaymentAmount() {
		if(hours <= 40) {
			return getWage() * getHours();
		}
		else {
			return (40 * getWage()) + ((getHours() - 40) * (getWage() * 1.5));
		}
	}
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		if(wage < 0) {
			System.out.println("Wage must be higher than or equal to 0!");
			System.exit(1);
		}
		this.wage = wage;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		if(hours < 0 || hours >= 168) {
			System.out.println("Hours must be higher than or equal to 0 and lower than 168!");
			System.exit(1);			
		}
		this.hours = hours;
	}
	
	@Override
	public String toString() {
		return "hourly employee: " + super.toString() + "\nhourly wage: $" + getWage() + "; hours worked: " + getHours() + "\npayment amount: $" + getPaymentAmount();
	}
}
