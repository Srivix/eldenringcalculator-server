package com.eldenringcalculator.weapon.model;

import com.eldenringcalculator.weapontype.model.WeaponTypeDto;

public class WeaponDto {
	
	private Long id;
	
	private String name;
	
	private WeaponTypeDto weaponType;

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

}
