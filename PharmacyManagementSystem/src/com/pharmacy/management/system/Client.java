package com.pharmacy.management.system;

/**
 * @author Bob
 *
 */
public class Client {

	private int id;
	private String full_name;
	private String adress;
	
	/** Initialize new Client*/
	public Client(int id, String full_name, String adress) {
		this.id = id;
		this.full_name = full_name;
		this.setAdress(adress);
	}
	
	public int getId() {
		return id;
	}

	public String getFull_name() {
		return full_name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	/** Check Client Equality*/
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean isEqual = false;
		try {
			Client client = (Client) obj;
			
			isEqual = this.getId() == client.getId();
			
		} catch (Exception exception) {
			// TODO: handle exception
			System.err.println("Unable to identify object type, details \n"+ exception.getMessage());
		}
		
		return isEqual;
	}


}
