/**
 * 
 */
package com.pharmacy.management.system;

/**
 * @author Bob
 *
 */
public class objectAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Trace an error, when the object to add already exists*/
	public objectAlreadyExistsException() {
		System.out.println("Object already exists :)"); 
	}
}
