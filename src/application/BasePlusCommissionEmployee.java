package application;
	
public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String firstName, String lastName, String SSN, double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, SSN, grossSales, commissionRate);
		setBaseSalary(baseSalary);
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	
	public void setBaseSalary(double baseSalary) {
		if(baseSalary < 0) {
			System.out.println("Base Salary must be higher than or equal to 0");
			System.exit(1);
		}
		this.baseSalary = baseSalary;
	}
	@Override
	public double getPaymentAmount() {
		return super.getPaymentAmount() + getBaseSalary();
	}

	@Override
	public String toString() {
		return "base-salaried commission employee: " + super.getFirstName() + " " + super.getLastName() + "\nsocial security number: " + super.getSSN() + "\ngross sales: $" + super.getGrossSales() + "; commission rate: " + super.getCommissionRate() + "; base salary: $" + getBaseSalary() + newToString();
	}
	public String newToString() {
		setBaseSalary(getBaseSalary() * 1.1);
		return "\nnew base salary with 10% increase is: $" + getBaseSalary() + "\npayment amount: $" + getPaymentAmount();
	}


}
