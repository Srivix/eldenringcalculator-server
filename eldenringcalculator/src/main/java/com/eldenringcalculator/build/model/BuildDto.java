package com.eldenringcalculator.build.model;

import java.util.Date;

import com.eldenringcalculator.buildclass.model.BuildClassDto;
import com.eldenringcalculator.buildstate.model.BuildStateDto;
import com.eldenringcalculator.user.model.UserDto;
import com.eldenringcalculator.weapon.model.WeaponDto;

public class BuildDto {
	
	private Long id;
	private String name;
	private BuildClassDto buildclass;
	private int level;
	private int dexterity;	
	private int strength;
	private int intelect;
	private int faith;
	private int arcane;
	private WeaponDto weapon1;
	private WeaponDto weapon2;
	private UserDto createdby;
	private Date created;
	private BuildStateDto state;
	
	/**
	 * @return the createdby
	 */
	public UserDto getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdby the createdby to set
	 */
	public void setCreatedby(UserDto createdby) {
		this.createdby = createdby;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the state
	 */
	public BuildStateDto getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(BuildStateDto state) {
		this.state = state;
	}

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

	/**
	 * @return the buildclass
	 */
	public BuildClassDto getBuildclass() {
		return buildclass;
	}

	/**
	 * @param buildclass the buildclass to set
	 */
	public void setBuildclass(BuildClassDto buildclass) {
		this.buildclass = buildclass;
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
