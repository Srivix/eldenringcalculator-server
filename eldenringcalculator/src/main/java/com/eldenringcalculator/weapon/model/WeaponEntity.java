package com.eldenringcalculator.weapon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eldenringcalculator.weapontype.model.WeaponTypeEntity;

@Entity
@Table(name = "Weapon")
public class WeaponEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "weapontype", nullable = false)
	private WeaponTypeEntity weaponType;

	@Column(name = "dexreq")
	private int dexreq;
	
	@Column(name = "strengreq")
	private int strengreq;

	@Column(name = "intreq")
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
	public WeaponTypeEntity getWeaponType() {
		return weaponType;
	}

	/**
	 * @param weaponType the weaponType to set
	 */
	public void setWeaponType(WeaponTypeEntity weaponType) {
		this.weaponType = weaponType;
	}

}
