/**
 * 
 */
package com.pharmacy.management.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Bob
 *
 */
public class Bill {
	private String code;
	private Date date;
	private int tva;
	
	private Client client;
	private DrugStore drugStore;
	private List<PurchaseItem> purchasedItems;
	
	/** Initialize new Bill for Client*/
	public Bill(String code, Date date, int tva, Client client, DrugStore drugStore) {
		super();
		this.code = code;
		this.date = date;
		this.tva = tva;
		this.client = client;
		this.drugStore = drugStore;
		
		purchasedItems = new ArrayList<PurchaseItem>();
	}

	public String getCode() {
		return code;
	}

	public Date getDate() {
		return date;
	}
	
	public double getTva() {
		return tva;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public void setTva(int  tva) {
		this.tva = tva;
	}
		
	/** Add new PurchaseItem*/
	public void PurchaseItem(PurchaseItem purchaseItem) throws objectAlreadyExistsException{
		if(this.purchasedItems.equals(purchaseItem)){
			throw new objectAlreadyExistsException();
		}
		
		this.purchasedItems.add(purchaseItem);
	}
	
	/** Calculate Total Price For Client to Pay (TVA also included) */
	private double getTotalPrice() {
		double ht_price = this.purchasedItems.stream().mapToDouble(item -> item.getPurchaseItemPrice()).sum();
		double ttc_price = ht_price * (1 + this.getTva() /100);
		
		return ttc_price;
	}
	
	/** Print Bill - Is Better to use Builder Design Pattern*/
	public String bill2Print() {
		String billContent = getBillHeader() + "\n";
		billContent += getBillPurchasedItems();
		billContent += getBillTotalPrice() + "\n\n\n";
		billContent += getBillFooter();
		
		return billContent;
	}
	
	/** Construct Bill's Header*/
	private String getBillHeader() {
		var header = "Code:\t"+ this.getCode() + "\t\t\t\tDate:\t"+ this.getDate() + "\n";
		header += "Client:\t" + this.client.getFull_name() + "\n";
		header += "Adress:\t"+ this.client.getAdress() + "\t\t\tTVA:\t"+ this.getTva() + "%\n\n";
		
		return header;
	}
	
	/** Construct PurchasedItems Section*/
	private String getBillPurchasedItems() {
		String purchaseItemsContent = "--------------------------------------------------------------------------------------------------\n";
		purchaseItemsContent += "|\t\tLabel\t\t|\tPrice ($)\t|\tQty\t|\tTTC Price ($)\t |\n";
		purchaseItemsContent += "-------------------------------------------------------------------------------------------------|\n";
		for(PurchaseItem item: this.purchasedItems) {
			purchaseItemsContent += item.toString() + "\n";
			purchaseItemsContent += "-------------------------------------------------------------------------------------------------|\n";
		}
		return purchaseItemsContent;
	}
	
	/** Construct Bill's Total Price to Pay by Client*/
	private String getBillTotalPrice() {
		String totalPriceContent = "| \t\t\t\t\t\t\t\t\t Total($): "+this.getTotalPrice()+"\t |";
		totalPriceContent += "\n--------------------------------------------------------------------------------------------------\n";

		return totalPriceContent;
	}
	
	/** Construct Bill's Footer*/
	private String getBillFooter() {
		String footer = "-------------------------------------------------------------------------------------------------\n";
		footer += this.drugStore.toString();
		return footer;
	}
	
	
}
