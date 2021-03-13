/**
 * 
 */
package com.pharmacy.management.system;

/**
 * @author Bob
 *
 */
public class PurchaseItem {
	private int id;
	private int qty2Purchase;
	private Medicine medicine;

	/** Create new Purchase Item 
	 * @throws Qty2PurchaseException */
	public PurchaseItem(int id, int qty2Purchase, Medicine medicine) throws Qty2PurchaseException {
		super();
		this.id = id;
		this.medicine = medicine;
		this.setPurchasedQty(qty2Purchase);
	}

	public int getId() {
		return id;
	}

	public int getQty2Purchase() {
		return qty2Purchase;
	}

	/** Set Quantity to purchase*/
	public void setPurchasedQty(int qty) throws Qty2PurchaseException{
		if(qty > this.medicine.getStockQty())
		{
			throw new Qty2PurchaseException();
		}
		
		this.qty2Purchase = qty;
		
		// Is deduct quantity
		int qty2Deduct = qty * -1;
		this.ajustMedcineQty(qty2Deduct);
	}
	
	/** Adjust Medicine available Quantity After the transaction*/
	private void ajustMedcineQty(int qty) {
		this.medicine.setStockQty(qty);
	}

	/** Calculate PurchaseItem Price */
	public double getPurchaseItemPrice() {
		return this.medicine.getPrice() * this.getQty2Purchase();
	}

	/** Describe PurchaseItem (should be updated) */
	@Override
	public String toString() {
		String description = "| " + this.medicine.getLabel() + " \t\t| " + this.medicine.getPrice() + " \t\t| "+ this.getQty2Purchase() + " \t\t| " + this.getPurchaseItemPrice() + " \t\t |";
		return description;
	}

}
