package com.eldenringcalculator.build.model;

import java.util.Date;

import org.springframework.data.domain.Pageable;

public class BuildSearchDto {

	private Pageable pageable;
	private String username;
	private String name;
	private String weapon1name;
	private String weapon2name;
	private Date startDate;
	private Date endDate;
	
    /**
    * @return pageable
    */
    public Pageable getPageable() {

        return this.pageable;
    }

    /**
    * @param pageable new value of {@link #getPageable}.
    */
    public void setPageable(Pageable pageable) {

        this.pageable = pageable;
    }

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return the weapon1name
	 */
	public String getWeapon1name() {
		return weapon1name;
	}

	/**
	 * @param weapon1name the weapon1name to set
	 */
	public void setWeapon1name(String weapon1name) {
		this.weapon1name = weapon1name;
	}

	/**
	 * @return the weapon2name
	 */
	public String getWeapon2name() {
		return weapon2name;
	}

	/**
	 * @param weapon2name the weapon2name to set
	 */
	public void setWeapon2name(String weapon2name) {
		this.weapon2name = weapon2name;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
