package edu.utsa.cs3443.myapplication.model;

import java.util.ArrayList;

/**
 * This class represents the airships that have wizards on board
 * 
 * @author mathewrobillard
 */

public class Airship {
	
	private String name;
	private String registry;
	private String airshipClass;
	private ArrayList<Wizard> wizards;
	
	/**
	 * Constructor for the Airship object
	 * 
	 * @param name, name of the airship
	 * @param registry, registry of the airship
	 * @param airshipClass, class of the airship 
	 */
	public Airship(String name, String registry, String airshipClass) {
		this.name = name;
		this.registry = registry;
		this.airshipClass = airshipClass;
		wizards = new ArrayList<Wizard>();
	}
	
	/**
	 * Prints out the Airship name and all of the wizards on board
	 * 
	 * @return returns the toString of the airship and the wizards on board
	 */
	public String toString() {
		String all = "";
		for(int i = 0; i < getNumberOfWizards(); i++) {
			all += wizards.get(i).toString();
		}
		return getName() + ", " + getAirshipClass() + ". " + "Registry: " + getRegistry() + "\n" + getNumberOfWizards() + " wizards Assigned.\n" + all + "\n";
	}
	
	/**
	 * Adds a wizard object to the ArrayList of wizards
	 * 
	 * @param wizard, Wizard object
	 */
	public void addWizard(Wizard wizard) {
		if(wizard == null) {
			return;
		}
		wizards.add(wizard);
	}
	
	/**
	 * Gets the size of the ArrayList of wizards
	 * 
	 * @return returns the size of the ArrayList of wizards
	 */
	public int getNumberOfWizards() {
		return wizards.size();
	}
	
	/**
	 * Sets the wizard object
	 * 
	 * @param wizards, ArrayList of wizard objects
	 */
	public void setWizards(ArrayList<Wizard> wizards) {
		this.wizards = wizards;
	}
	
	/**
	 * gets the ArrayList of wizards
	 * 
	 * @return returns the ArrayList of wizards
	 */
	public ArrayList<Wizard> getWizards(){
		return this.wizards;
	}
	
	/**
	 * Sets the name of the airship
	 * 
	 * @param name, name of the airship
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the airship
	 * 
	 * @return returns the name of the airship 
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * sets the registry of the airship
	 * 
	 * @param registry, registry of the airship
	 */
	public void setRegistry(String registry) {
		this.registry = registry;
	}
	
	/**
	 * Gets the registry of the airship
	 * 
	 * @return returns the registry of the airship
	 */
	public String getRegistry() {
		return this.registry;
	}
	
	/**
	 * Sets the class of the airship
	 * 
	 * @param airshipClass, class of the airship
	 */
	public void setAirshipClass(String airshipClass) {
		this.airshipClass = airshipClass;
	}
	
	/**
	 * Gets the class of the airship 
	 * 
	 * @return returns the class of the airship
	 */
	public String getAirshipClass() {
		return this.airshipClass;
	}
}
