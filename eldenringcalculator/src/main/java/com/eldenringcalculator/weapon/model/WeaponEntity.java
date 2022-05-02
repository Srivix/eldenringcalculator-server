package com.eldenringcalculator.weapon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.eldenringcalculator.weapontype.model.WeaponTypeEntity;

@Entity
@Table(name = "weapons")
public class WeaponEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@NotEmpty
	@Size(min = 4)
	@Column(unique = true,name = "name", nullable = false)
	private String name;
	
	@Column(name = "photo", nullable = false)
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "weapontype", nullable = false)
	private WeaponTypeEntity weaponType;

	@Column(name = "dexreq", nullable = false)
	private int dexReq;
	
	@Column(name = "strengreq", nullable = false)
	private int strengReq;

	@Column(name = "intreq", nullable = false)
	private int intReq;
	
	@Column(name = "faithreq", nullable = false)
	private int faithReq;
	
	@Column(name = "arcanereq", nullable = false)
	private int arcaneReq;
	
	@Column(name = "dexscaling", nullable = false)
	private char dexScaling;
	
	@Column(name = "strengscaling", nullable = false)
	private char strengScaling;
	
	@Column(name = "intscaling", nullable = false)
	private char intScaling;
	
	@Column(name = "faithscaling", nullable = false)
	private char faithScaling;
	
	@Column(name = "arcanescaling", nullable = false)
	private char arcaneScaling;
	
	@Column(name = "weight")
	private float weight;
	
	@Column(name = "description", nullable = false)
	private String description;

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
