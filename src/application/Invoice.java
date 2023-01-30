package application;
	
public class Invoice implements Payable {
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		setQuantity(quantity);
		setPricePerItem(pricePerItem);
	}
	
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return quantity * pricePerItem;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if (quantity < 0) {
			System.out.println("Quantity must be higher than or equal to 0!");
			System.exit(1);
		}
		this.quantity = quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		if(pricePerItem <= 0) {
			System.out.println("Price must be higher than 0!");
			System.exit(1);
		}
		this.pricePerItem = pricePerItem;
	}
	
	@Override
	public String toString() {
		return "invoice:\npartNumber: " + getPartNumber() + " (" + getPartDescription() + ")\n" + "quantity: " + getQuantity() + "\nprice per item: $" + getPricePerItem() + "\npayment amount: $" + getPaymentAmount();
	}
}
