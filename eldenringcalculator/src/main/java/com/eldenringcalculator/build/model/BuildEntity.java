package com.eldenringcalculator.build.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eldenringcalculator.buildclass.model.BuildClassEntity;
import com.eldenringcalculator.buildstate.model.BuildStateEntity;
import com.eldenringcalculator.user.model.UserEntity;
import com.eldenringcalculator.weapon.model.WeaponEntity;

@Entity
@Table(name = "builds")
public class BuildEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "buildclass", nullable = false)
	private BuildClassEntity buildclass;
	
	@Column(name = "level", nullable = false)
	private int level;
	
	@Column(name = "dexterity", nullable = false)
	private int dexterity;
	
	@Column(name = "strength", nullable = false)
	private int strength;
	
	@Column(name = "intelect", nullable = false)
	private int intelect;
	
	@Column(name = "faith", nullable = false)
	private int faith;
	
	@Column(name = "arcane", nullable = false)
	private int arcane;
	
	@ManyToOne
	@JoinColumn(name = "weapon1")
	private WeaponEntity weapon1;

	@ManyToOne
	@JoinColumn(name = "weapon2")
	private WeaponEntity weapon2;
	
	@ManyToOne
	@JoinColumn(name = "createdby")
	private UserEntity createdby;

	@Column(name = "created", nullable = false)
	private Date created;
	
	@ManyToOne
	@JoinColumn(name = "state" , nullable = false)
	private BuildStateEntity state;
	
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
	public WeaponEntity getWeapon1() {
		return weapon1;
	}

	/**
	 * @param weapon1 the weapon1 to set
	 */
	public void setWeapon1(WeaponEntity weapon1) {
		this.weapon1 = weapon1;
	}

	/**
	 * @return the weapon2
	 */
	public WeaponEntity getWeapon2() {
		return weapon2;
	}

	/**
	 * @param weapon2 the weapon2 to set
	 */
	public void setWeapon2(WeaponEntity weapon2) {
		this.weapon2 = weapon2;
	}

	/**
	 * @return the buildclass
	 */
	public BuildClassEntity getBuildclass() {
		return buildclass;
	}

	/**
	 * @param buildclass the buildclass to set
	 */
	public void setBuildclass(BuildClassEntity buildclass) {
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

	/**
	 * @return the createdBy
	 */
	public UserEntity getCreatedby() {
		return createdby;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedby(UserEntity createdby) {
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
	public BuildStateEntity getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(BuildStateEntity state) {
		this.state = state;
	}
}
