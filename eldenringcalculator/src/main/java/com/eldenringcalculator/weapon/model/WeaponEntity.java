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
	
	@Column(name = "photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "weapontype", nullable = false)
	private WeaponTypeEntity weaponType;

	@Column(name = "dexreq")
	private int dexreq;
	
	@Column(name = "strengreq")
	private int strengreq;

	@Column(name = "intreq")
	private int intreq;
	
	@Column(name = "faithreq")
	private int faithreq;
	
	@Column(name = "arcanereq")
	private int arcanereq;
	
	@Column(name = "dexscaling")
	private char dexscaling;
	
	@Column(name = "strengscaling")
	private char strengscaling;
	
	@Column(name = "intscaling")
	private char intscaling;
	
	@Column(name = "faithscaling")
	private char faithscaling;
	
	@Column(name = "arcanescaling")
	private char arcanescaling;
	
	@Column(name = "weight")
	private float weight;
	
	@Column(name = "description")
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
	public WeaponTypeEntity getWeaponType() {
		return weaponType;
	}

	/**
	 * @param weaponType the weaponType to set
	 */
	public void setWeaponType(WeaponTypeEntity weaponType) {
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
