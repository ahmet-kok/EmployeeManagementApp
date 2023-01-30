package application;

public class SalariedEmployee extends Employee {
	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String SSN, double weeklySalary) {
		super(firstName, lastName, SSN);
		setWeeklySalary(weeklySalary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getPaymentAmount() {
		return weeklySalary;
	}

	public double getWeeklySalary() {
		return weeklySalary;
	}

	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary < 0) {
			System.out.println("Weekly Salary must be higher than or equal to 0!");
			System.exit(1);
		}
		this.weeklySalary = weeklySalary;
	}

	@Override
	public String toString() {
		return "salaried employee: " + super.toString() + "\nweekly salary: $" + getWeeklySalary() + "\npayment amount: $" + getPaymentAmount();
	}

	
}
