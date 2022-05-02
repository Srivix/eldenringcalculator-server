package com.eldenringcalculator.buildclass.model;

public class BuildClassDto {
	
	private Long id;
	private String name = "-";
	private int level = 0;
	private int dexterity= 0;
	private int strength= 0;
	private int intelect= 0;
	private int faith= 0;
	private int arcane= 0;
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
