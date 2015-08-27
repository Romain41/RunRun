package com.example.runrun.data.entities;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Represents the {@link #Race}'s entity.<br>
 * 
 * @author BeepBeep
 */
@DatabaseTable
public class Race {
	// ******************************
	// Fields
	// ******************************
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField
	private Date date;
	@DatabaseField
	private float distance;
	
	// ******************************
	// Constructors
	// ******************************
	/**
	 * Default constructor.
	 * 
	 * @param date The {@link #Race}'s date.
	 * @param distance The {@link #Race}'s distance.
	 */
	public Race(Date date, float distance) {
		this.date = date;
		this.distance = distance;
	}

	/**
	 * Empty constructor.<br>
	 * Used by ORMLite for mapping purpose.
	 */
	public Race() {

	}

	// ******************************
	// Getters & setters
	// ******************************
	/**
	 * Returns the {@link #Race}'s identifier.
	 * 
	 * @return The {@link #Race}'s identifier.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Returns the {@link #Race}'s name.
	 * 
	 * @return The {@link #Race}'s name.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the {@link #Race}'s name.
	 * 
	 * @param name The {@link #Race}'s name.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Returns {@link #Race}'s height.
	 * 
	 * @return The {@link #Race}'s height.
	 */
	public float getDistance() {
		return distance;
	}

	/**
	 * Sets {@link #Race}'s height.
	 * 
	 * @param height The {@link #Race}'s height.
	 */
	public void setDistance(float distance) {
		this.distance = distance;
	}
}