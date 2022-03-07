package com.eldenringcalculator.build.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eldenringcalculator.buildclass.model.BuildClassEntity;
import com.eldenringcalculator.weapon.model.WeaponEntity;

@Entity
@Table(name = "build")
public class BuildEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "buildclass")
	private BuildClassEntity buildclass;
	
	@Column(name = "level")
	private int level;
	
	@Column(name = "hp")
	private int hp;
	
	@Column(name = "fp")
	private int fp;
	
	@Column(name = "stamina")
	private int stamina;
	
	@Column(name = "vigor")
	private int vigor;
	
	@Column(name = "mind")
	private int mind;
	
	@Column(name = "endurance")
	private int endurance;

	@Column(name = "dexterity")
	private int dexterity;
	
	@Column(name = "strength")
	private int strength;
	
	@Column(name = "intelect")
	private int intelect;
	
	@Column(name = "faith")
	private int faith;
	
	@Column(name = "arcane")
	private int arcane;
	
	@ManyToOne
	@JoinColumn(name = "weapon1")
	private WeaponEntity weapon1;

	@ManyToOne
	@JoinColumn(name = "weapon2")
	private WeaponEntity weapon2;

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
	 * @return the hp
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * @param hp the hp to set
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return the fp
	 */
	public int getFp() {
		return fp;
	}

	/**
	 * @param fp the fp to set
	 */
	public void setFp(int fp) {
		this.fp = fp;
	}

	/**
	 * @return the stamina
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * @param stamina the stamina to set
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	/**
	 * @return the vigor
	 */
	public int getVigor() {
		return vigor;
	}

	/**
	 * @param vigor the vigor to set
	 */
	public void setVigor(int vigor) {
		this.vigor = vigor;
	}

	/**
	 * @return the mind
	 */
	public int getMind() {
		return mind;
	}

	/**
	 * @param mind the mind to set
	 */
	public void setMind(int mind) {
		this.mind = mind;
	}

	/**
	 * @return the endurance
	 */
	public int getEndurance() {
		return endurance;
	}

	/**
	 * @param endurance the endurance to set
	 */
	public void setEndurance(int endurance) {
		this.endurance = endurance;
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
