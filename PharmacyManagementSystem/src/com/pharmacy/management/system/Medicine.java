/**
 * 
 */
package com.pharmacy.management.system;

/**
 * @author Bob
 *
 */
public class Medicine {

	private String ref;
	private String label;
	private double price;
	private int stockQty;

	/** Initialize new Medicine*/
	public Medicine(String ref, String label, double price, int stockQty) {
		this.ref = ref;
		this.label = label;
		this.price = price;
		this.stockQty = stockQty;
	}
	
	public String getRef() {
		return ref;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setStockQty(int stockQty) {
		this.stockQty = stockQty;
	}

	/** Adjust Medicine Stock*/
	public void ajustStock(int qty) {
		this.setStockQty(stockQty += qty);
	}

	public int getStockQty() {
		return stockQty;
	}

	public double getPrice() {
		return price;
	}

	public String getLabel() {
		return label;
	}
	
	/** Describe Medicine*/
	@Override
	public String toString() {
		return "Medicine [ref=" + ref + ", label=" + label + ", price=" + price + ", stockQty=" + stockQty + "]";
	}

	/** Check Medicine Equality*/
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isEqual = false;
		try {
			Medicine medicine = (Medicine) obj;
			
			isEqual = this.getRef() == medicine.getRef();
			
		} catch (Exception exception) {
			// TODO: handle exception
			System.err.println("Unable to identify object type, details \n"+ exception.getMessage());
		}
		
		return isEqual;
	}
}
