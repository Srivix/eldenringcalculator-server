package com.eldenringcalculator.build.model;

import com.eldenringcalculator.weapon.model.WeaponDto;

public class BuildDto {
	
	private Long id;

	private String name;
	
	private int level;

	private int dexterity;	

	private int strength;
	
	private int intelect;

	private WeaponDto weapon1;

	private WeaponDto weapon2;
	
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
	 * @return the weapon1
	 */
	public WeaponDto getWeapon1() {
		return weapon1;
	}

	/**
	 * @param weapon1 the weapon1 to set
	 */
	public void setWeapon1(WeaponDto weapon1) {
		this.weapon1 = weapon1;
	}

	/**
	 * @return the weapon2
	 */
	public WeaponDto getWeapon2() {
		return weapon2;
	}

	/**
	 * @param weapon2 the weapon2 to set
	 */
	public void setWeapon2(WeaponDto weapon2) {
		this.weapon2 = weapon2;
	}
}
