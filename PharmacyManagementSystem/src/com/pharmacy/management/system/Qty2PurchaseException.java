package com.pharmacy.management.system;

public class Qty2PurchaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Trace an error, when the Quantity to purchase is exceeded the available quantity*/
	public Qty2PurchaseException() {
		System.out.println("Quantity to purchase is out of avalaible Qty :)"); 
	}
}
