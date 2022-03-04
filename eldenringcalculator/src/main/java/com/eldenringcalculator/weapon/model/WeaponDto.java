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

}
