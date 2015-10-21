package com.jlj.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wlyblack entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wlyblack", catalog = "wsp")
public class Wlyblack implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wly wly;
	private String name;
	private String openid;
	private Date blacktime;

	// Constructors

	/** default constructor */
	public Wlyblack() {
	}

	/** full constructor */
	public Wlyblack(Wly wly, String name, String openid, Date blacktime) {
		this.wly = wly;
		this.name = name;
		this.openid = openid;
		this.blacktime = blacktime;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wlyid")
	public Wly getWly() {
		return this.wly;
	}

	public void setWly(Wly wly) {
		this.wly = wly;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "openid", length = 30)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "blacktime", length = 19)
	public Date getBlacktime() {
		return this.blacktime;
	}

	public void setBlacktime(Date blacktime) {
		this.blacktime = blacktime;
	}

}