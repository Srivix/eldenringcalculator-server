package com.eldenringcalculator.weapon.model;

import com.eldenringcalculator.weapontype.model.WeaponTypeDto;

public class WeaponDto {
	
	private Long id;
	private String name;
	private String photo;
	private WeaponTypeDto weaponType;
	private int dexreq;
	private int strengreq;
	private int intreq;
	private int faithreq;
	private int arcanereq;
	private char dexscaling;
	private char strengscaling;
	private char intscaling;
	private char faithscaling;
	private char arcanescaling;
	private float weight;
	private String description;

	/**
	 * @return the dexreq
	 */
	public int getDexreq() {
		return dexreq;
	}

	/**
	 * @param dexreq the dexreq to set
	 */
	public void setDexreq(int dexreq) {
		this.dexreq = dexreq;
	}

	/**
	 * @return the strengreq
	 */
	public int getStrengreq() {
		return strengreq;
	}

	/**
	 * @param strengreq the strengreq to set
	 */
	public void setStrengreq(int strengreq) {
		this.strengreq = strengreq;
	}

	/**
	 * @return the intreq
	 */
	public int getIntreq() {
		return intreq;
	}

	/**
	 * @param intreq the intreq to set
	 */
	public void setIntreq(int intreq) {
		this.intreq = intreq;
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
	 * @return the weaponType
	 */
	public WeaponTypeDto getWeaponType() {
		return weaponType;
	}

	/**
	 * @param weaponType the weaponType to set
	 */
	public void setWeaponType(WeaponTypeDto weaponType) {
		this.weaponType = weaponType;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the faithreq
	 */
	public int getFaithreq() {
		return faithreq;
	}

	/**
	 * @param faithreq the faithreq to set
	 */
	public void setFaithreq(int faithreq) {
		this.faithreq = faithreq;
	}

	/**
	 * @return the arcanereq
	 */
	public int getArcanereq() {
		return arcanereq;
	}

	/**
	 * @param arcanereq the arcanereq to set
	 */
	public void setArcanereq(int arcanereq) {
		this.arcanereq = arcanereq;
	}

	/**
	 * @return the dexscaling
	 */
	public char getDexscaling() {
		return dexscaling;
	}

	/**
	 * @param dexscaling the dexscaling to set
	 */
	public void setDexscaling(char dexscaling) {
		this.dexscaling = dexscaling;
	}

	/**
	 * @return the intscaling
	 */
	public char getIntscaling() {
		return intscaling;
	}

	/**
	 * @param intscaling the intscaling to set
	 */
	public void setIntscaling(char intscaling) {
		this.intscaling = intscaling;
	}

	/**
	 * @return the faithscaling
	 */
	public char getFaithscaling() {
		return faithscaling;
	}

	/**
	 * @param faithscaling the faithscaling to set
	 */
	public void setFaithscaling(char faithscaling) {
		this.faithscaling = faithscaling;
	}

	/**
	 * @return the arcanescaling
	 */
	public char getArcanescaling() {
		return arcanescaling;
	}

	/**
	 * @param arcanescaling the arcanescaling to set
	 */
	public void setArcanescaling(char arcanescaling) {
		this.arcanescaling = arcanescaling;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the strengscaling
	 */
	public char getStrengscaling() {
		return strengscaling;
	}

	/**
	 * @param strengscaling the strengscaling to set
	 */
	public void setStrengscaling(char strengscaling) {
		this.strengscaling = strengscaling;
	}

}
