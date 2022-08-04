/*
Module Name : Player
Date of creation: 04-08-2022
Name of creator of module: Saikat Bhattacharjee
History of modification: First creation
Summary of what the module does: POJO class to deserialize Player JSON into object
Functions in the module: Getters and setters
Variables accessed by the module: 
	name -> name of the player 
	country -> Home country of the player
	role -> role of the player in a team
	price_in_crores -> Player remuneration
*/

package objectClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
	private String name;
	private String country;
	private String role;
	@JsonProperty("price-in-crores")
	private float price_in_crores;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public float getPrice_in_crores() {
		return price_in_crores;
	}

	public void setPrice_in_crores(float price_in_crores) {
		this.price_in_crores = price_in_crores;
	}

}
