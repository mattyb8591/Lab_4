package edu.utsa.cs3443.myapplication.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import edu.utsa.cs3443.myapplication.AirshipActivity;
import edu.utsa.cs3443.myapplication.MainActivity;

/**
 * The Fleet class that represents the Whole fleet of airships that have wizards on board
 * 
 * @author mathewrobillard
 */

public class Fleet {
	
	private String name;
	private ArrayList<Airship> airships;
	
	/**
	 * Constructor for the fleet of airships
	 * 
	 * @param name, name of the Fleet
	 */
	public Fleet(String name) {
		this.name = name;
		airships = new ArrayList<Airship>();
	}
	
	/**
	 * Gets the total size of the fleet
	 * 
	 * @param airships, ArrayList of airship objects
	 * @return returns an integer of the number of airships in the fleet
	 */
	public int getSizeOfFleet(ArrayList<Airship> airships) {
		return airships.size();
	}
	
	/**
	 * Adds an airship object to the ArrayList of airships
	 * 
	 * @param airship, airship object
	 */
	public void addAirship(Airship airship) {
		if(airship == null) {
			return;
		}
        airships.add(airship);
    }
	
	/**
	 * Prints out the whole fleet of airships with wizards on it
	 * 
	 * @return returns the toString representation of the Fleet
	 */
	public String toString() {
		
		String all = "";
		for(int i = 0; i < getSizeOfFleet(airships); i++) {
			if(airships.get(i) != null) {
				all += airships.get(i).toString();
			}
		}
		return "------------------------------\n" + getName() 
		+ "\n------------------------------\n" + all;
	}

	/**
	 * Reads from both csv files and places each wizard on their corresponding airship ArrayList
	 * and places each airship in the ArrauList of airships
	 *
	 * @param activity, controller class activity
	 */
	public void loadAirships(Activity activity) {

		AssetManager manager = activity.getAssets();
		Scanner scan = null;
		Scanner scan2 = null;
		String filename_fleet = "fleet.csv";
		String filename_wizard = "wizards.csv";
		Airship airship = null;
		Wizard wizard = null;
		String[] tokens = null;

		try {
			InputStream file = manager.open(filename_fleet);
			InputStream file2 = manager.open(filename_wizard);
			scan = new Scanner(file);
			scan2 = new Scanner(file2);
			scan.nextLine();
			scan2.nextLine();
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				tokens = line.split(",");
				airship = new Airship(tokens[0], tokens[1], tokens[2]);
				addAirship(airship);
			}

			while (scan2.hasNextLine()){
				String line2 = scan2.nextLine();
				String[] tokens2 = line2.split(",");
				wizard = new Wizard(tokens2[0], tokens2[1], tokens2[2], tokens2[3], tokens2[4]);

				for(int i = 0; i < airships.size(); i++){
					System.out.println(airships.get(i).toString());
					if(tokens2[4].equals(airships.get(i).getRegistry())){
						airships.get(i).addWizard(wizard);
						System.out.println(wizard.toString() + " Added to this airship");
					}
				}
			}

		}
		catch(IOException e){
			throw new RuntimeException(e);
        }
    }
	
	/**
	 * Sets the airship
	 * 
	 * @param airships, ArrayList of airship objects
	 */
	public void setAirship(ArrayList<Airship> airships) {
		this.airships = airships;
	}
	
	/**
	 * Gets the Airship object at a specific index
	 * 
	 * @param index, index of the ArrayList of airship objects
	 * @return returns an airship object 
	 */
	public Airship getAirship(int index) {
		return this.airships.get(index);
	}
	
	/**
	 * Sets the name of the fleet
	 * 
	 * @param name, name of the fleet
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the fleet
	 * 
	 * @return returns the name of the fleet
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the ArrayList of airships
	 *
	 * @return returns the ArrayList of airships
	 */
	public ArrayList<Airship> getAirships(){
		return this.airships;
	}

}
