package com.pharmacy.management.system;

import java.util.Date;

/**
 * @author Bob
 *
 */
public class Program {

	public static void main(String args[]) {
		/**Create new DrugStore*/
		DrugStore yacout_pharmacy = new DrugStore("RF245X75", "YAKOUT PHARMACY", "Agdal N 45, Rabat - Morocco", "RC: 1457812", "yacout@contact.com", "+212 5 12 13 14 15");
		
		/**Create Clients*/
		Client bob_1 = new Client(1, "Bob 1", "Mehdia, Kenitra - Morocco");
		
		
		/** Add new Clients to DrugStore*/
		try {
			yacout_pharmacy.addNewClient(bob_1);
		} catch (objectAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/** Create Medicines*/
		Medicine doliprane = new Medicine("doliRf147", "Doliprane      ", 11.45, 10);
		Medicine c1000 = new Medicine("doli124H14", "Doliprane C1000", 47.32, 7);
		
		/** Fill DrugStore with New Medicines*/
		try {
			yacout_pharmacy.addNewMedicine(doliprane);
			yacout_pharmacy.addNewMedicine(c1000);
		} catch (objectAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/** Create new bill for Bob_1*/
		Bill bob_1_bill = new Bill("bill1_bob_1_2021", new Date(), 20, bob_1, yacout_pharmacy);
		
		/** Perform purchasing item for Bob_1*/
		try {
			PurchaseItem item1_c1000 = new PurchaseItem(1, 2, c1000);
			PurchaseItem item2_doliprane = new PurchaseItem(2, 4, doliprane);
			
			/** Add new items to Bob's Bill*/
			bob_1_bill.PurchaseItem(item1_c1000);
			bob_1_bill.PurchaseItem(item2_doliprane);
			
		} catch (Qty2PurchaseException | objectAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/** Print Bob's Bill*/
		System.out.println(bob_1_bill.bill2Print()); 
	}
}
