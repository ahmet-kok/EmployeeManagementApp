package application;
	

public class CommissionEmployee extends Employee {
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee(String firstName, String lastName, String SSN, double grossSales, double commissionRate) {
		super(firstName, lastName, SSN);
		setGrossSales(grossSales);
		setCommissionRate(commissionRate);
	}
	
	public double getGrossSales() {
		return grossSales;
	}

	public void setGrossSales(double grossSales) {
		if(grossSales < 0) {
			System.out.println("Gross Sales must be higher than or equal to 0!");
			System.exit(1);
		}
		this.grossSales = grossSales;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		if(commissionRate <= 0 || commissionRate >= 1) {
			System.out.println("Commission Rate must be between 0 and 1!");
			System.exit(1);
		}
		this.commissionRate = commissionRate;
	}


	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getGrossSales() * getCommissionRate();
	}
	
	@Override
	public String toString() {
		return "commission employee: " + super.toString() + "\ngross sales: $" + getGrossSales() + "; commission rate: " + getCommissionRate() + "\npayment amount: $" + getPaymentAmount();
	}
	
}