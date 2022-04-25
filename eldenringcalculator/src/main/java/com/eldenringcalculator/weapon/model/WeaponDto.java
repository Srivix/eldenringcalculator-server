package com.eldenringcalculator.weapon.model;

import com.eldenringcalculator.weapontype.model.WeaponTypeDto;

public class WeaponDto {
	
	private Long id;
	private String name = "-";
	private String photo = "nophoto.png";
	private WeaponTypeDto weaponType;
	private int dexReq = 0;
	private int strengReq = 0;
	private int intReq = 0;
	private int faithReq = 0;
	private int arcaneReq = 0;
	private char dexScaling = '-';
	private char strengScaling = '-';
	private char intScaling = '-';
	private char faithScaling = '-';
	private char arcaneScaling = '-';
	private float weight;
	private String description = "-";
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
	 * @return the dexReq
	 */
	public int getDexReq() {
		return dexReq;
	}
	/**
	 * @param dexReq the dexReq to set
	 */
	public void setDexReq(int dexReq) {
		this.dexReq = dexReq;
	}
	/**
	 * @return the strengReq
	 */
	public int getStrengReq() {
		return strengReq;
	}
	/**
	 * @param strengReq the strengReq to set
	 */
	public void setStrengReq(int strengReq) {
		this.strengReq = strengReq;
	}
	/**
	 * @return the intReq
	 */
	public int getIntReq() {
		return intReq;
	}
	/**
	 * @param intReq the intReq to set
	 */
	public void setIntReq(int intReq) {
		this.intReq = intReq;
	}
	/**
	 * @return the faithReq
	 */
	public int getFaithReq() {
		return faithReq;
	}
	/**
	 * @param faithReq the faithReq to set
	 */
	public void setFaithReq(int faithReq) {
		this.faithReq = faithReq;
	}
	/**
	 * @return the arcaneReq
	 */
	public int getArcaneReq() {
		return arcaneReq;
	}
	/**
	 * @param arcaneReq the arcaneReq to set
	 */
	public void setArcaneReq(int arcaneReq) {
		this.arcaneReq = arcaneReq;
	}
	/**
	 * @return the dexScaling
	 */
	public char getDexScaling() {
		return dexScaling;
	}
	/**
	 * @param dexScaling the dexScaling to set
	 */
	public void setDexScaling(char dexScaling) {
		this.dexScaling = dexScaling;
	}
	/**
	 * @return the strengScaling
	 */
	public char getStrengScaling() {
		return strengScaling;
	}
	/**
	 * @param strengScaling the strengScaling to set
	 */
	public void setStrengScaling(char strengScaling) {
		this.strengScaling = strengScaling;
	}
	/**
	 * @return the intScaling
	 */
	public char getIntScaling() {
		return intScaling;
	}
	/**
	 * @param intScaling the intScaling to set
	 */
	public void setIntScaling(char intScaling) {
		this.intScaling = intScaling;
	}
	/**
	 * @return the faithScaling
	 */
	public char getFaithScaling() {
		return faithScaling;
	}
	/**
	 * @param faithScaling the faithScaling to set
	 */
	public void setFaithScaling(char faithScaling) {
		this.faithScaling = faithScaling;
	}
	/**
	 * @return the arcaneScaling
	 */
	public char getArcaneScaling() {
		return arcaneScaling;
	}
	/**
	 * @param arcaneScaling the arcaneScaling to set
	 */
	public void setArcaneScaling(char arcaneScaling) {
		this.arcaneScaling = arcaneScaling;
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

}
