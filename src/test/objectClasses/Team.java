/*
Module Name : Team
Date of creation: 04-08-2022
Name of creator of module: Saikat Bhattacharjee
History of modification: First creation
Summary of what the module does: POJO class to deserialize Team JSON into object
Functions in the module: Getters and setters
Variables accessed by the module: 
	name -> name of the team 
	location -> location of the team
	player -> a list of current player in the team 
*/
package objectClasses;

import java.util.ArrayList;



public class Team {
	
	private String name;
	private String location;
	private ArrayList<Player> player;
	
	public ArrayList<Player> getPlayer() {
		return player;
	}
	public void setPlayer(ArrayList<Player> player) {
		this.player = player;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
