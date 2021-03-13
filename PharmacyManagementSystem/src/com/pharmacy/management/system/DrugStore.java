package com.pharmacy.management.system;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bob
 *
 */
public class DrugStore {
	private String code;
	private String name;
	private String adress;
	private String comercial_register;
	private String email;
	private String phone;
	
	private List<Client> clients;;
	private List<Medicine> medicines;

	/** Initialize new DrugStore*/
	public DrugStore(String code, String name, String adress, String comercial_register, String email, String phone) {
		this.code = code;
		this.name = name;
		this.adress = adress;
		this.comercial_register = comercial_register;
		this.email = email;
		this.phone = phone;
		this.clients = new ArrayList<Client>();
		this.medicines = new ArrayList<Medicine>();
	}

	public String getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAdress() {
		return adress;
	}

	public String getComercial_register() {
		return comercial_register;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setComercial_register(String comercial_register) {
		this.comercial_register = comercial_register;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		String description = this.getName() + ", Adress: "+ this.getAdress() + "\n";
		description += "Phone: "+ this.getPhone() + "\n";
		description += "Email: "+ this.getEmail();
		
		return description;
	}

	/** get all medicine*/
	public List<Medicine> getMedicines() {
		return this.medicines;
	}
	
	/** Get all clients*/
	public List<Client> getClients() {
		return this.clients;
	}
	
	/** Add client to DrugStore*/
	public void addNewClient(Client client) throws objectAlreadyExistsException {
		
		if(this.clients.equals(client)) {
			throw new objectAlreadyExistsException();
		}
		
		this.clients.add(client);
	}
	
	/** Add medicine to DrugStore*/
	public void addNewMedicine(Medicine medicine) throws objectAlreadyExistsException {
		if(this.medicines.equals(medicine)){
			throw new objectAlreadyExistsException();
		}
		
		this.medicines.add(medicine);
	}
}