package com.eldenringcalculator.buildclass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "buildclasses")
public class BuildClassEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "level", nullable = false)
	private int level;

	@Column(name = "dexterity", nullable = false)
	private int dexterity;

	@Column(name = "strength", nullable = false)
	private int strength;

	@Column(name = "intelect", nullable = false)
	private int intelect;

	@Column(name = "faith", nullable = false)
	private int faith;

	@Column(name = "arcane", nullable = false)
	private int arcane;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the dexterity
	 */
	public int getDexterity() {
		return dexterity;
	}
	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}
	/**
	 * @return the strength
	 */
	public int getStrength() {
		return strength;
	}
	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}
	/**
	 * @return the intelect
	 */
	public int getIntelect() {
		return intelect;
	}
	/**
	 * @param intelect the intelect to set
	 */
	public void setIntelect(int intelect) {
		this.intelect = intelect;
	}
	/**
	 * @return the faith
	 */
	public int getFaith() {
		return faith;
	}
	/**
	 * @param faith the faith to set
	 */
	public void setFaith(int faith) {
		this.faith = faith;
	}
	/**
	 * @return the arcane
	 */
	public int getArcane() {
		return arcane;
	}
	/**
	 * @param arcane the arcane to set
	 */
	public void setArcane(int arcane) {
		this.arcane = arcane;
	}
}
