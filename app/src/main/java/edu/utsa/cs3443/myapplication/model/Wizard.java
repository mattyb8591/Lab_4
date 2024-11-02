package edu.utsa.cs3443.myapplication.model;


/**
 * This class represents the Wizard object
 * 
 * @author mathewrobillard
 */
public class Wizard {
	
	private String name;
	private String role;
	private String rank;
	private String species;
	private String assignment;
	private String imageFile;
	
	/**
	 * Constructor for the wizard object including the assignment
	 * 
	 * @param name, name of the wizard
	 * @param role, role of the wizard
	 * @param rank, rank of the wizard
	 * @param species, species
	 * @param assignment, assignment of the wizard
	 */
	public Wizard(String name, String role, String rank, String species, String assignment) {
		this.name = name;
		this.role = role;
		this.rank = rank;
		this.species = species;
		this.assignment = assignment;
		this.imageFile = name.toLowerCase();
	}
	
	/**
	 * Constructor for the wizard object excluding the assignment
	 * 
	 * @param name, name of the wizard
	 * @param role, role of the wizard
	 * @param rank, rank of the wizard
	 * @param species, species
	 */
	public Wizard(String name, String role, String rank, String species) {
		this.name = name;
		this.role = role;
		this.rank = rank;
		this.species = species;
	}
	
	/**
	 * Prints out the toString representation of the wizard object
	 * 
	 * @return returns the toString representation of the wizard object
	 */
	public String toString() {
		return "- " + getName() + " (" + getRank() + ") " + "- " + getRole() + " [" + getSpecies() + "]\n";
	}
	
	/**
	 * Sets the name of the wizard
	 * 
	 * @param name, name of the wizard
	 */
	public void setName(String name) {
		this.name  = name;
	}
	
	/**
	 * Gets the name of the wizard
	 * 
	 * @return returns the name of the wizard
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the role of the wizard
	 * 
	 * @param role, role of the wizard
	 */
	public void setRole(String role) {
		this.role  = role;
	}
	
	/**
	 * Gets the role of the wizard
	 * 
	 * @return returns the role of the wizard
	 */
	public String getRole() {
		return this.role;
	}
	
	/**
	 * Sets the rank of the wizard
	 * 
	 * @param rank, rank of the wizard
	 */
	public void setRank(String rank) {
		this.rank  = rank;
	}
	
	/**
	 * Gets the rank of the wizard
	 * 
	 * @return returns the rank of the wizard
	 */
	public String getRank() {
		return this.rank;
	}
	
	/**
	 * Sets the species of the wizard
	 * 
	 * @param species, species of the wizard
	 */
	public void setSpecies(String species) {
		this.species  = species;
	}
	
	/**
	 * Gets the species of the wizard
	 * 
	 * @return returns the species of the wizard
	 */
	public String getSpecies() {
		return this.species;
	}
	
	/**
	 * Sets the name of the assignment
	 * 
	 * @param assignment, assignment of the wizard
	 */
	public void setAssignment(String assignment) {
		this.assignment  = assignment;
	}
	
	/**
	 * Gets the assignment of the wizard
	 * 
	 * @return returns the assignment of the wizard
	 */
	public String getAssignment() {
		return this.assignment;
	}

	public String getImageFile(){
		return this.imageFile;
	}
	
	
}
