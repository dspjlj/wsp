package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Wscproarg entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscproarg", catalog = "wsp")
public class Wscproarg implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscproduct wscproduct;
	private String name;
	private String csvalue;
	private Integer ison;
	private Integer orderid;

	// Constructors

	/** default constructor */
	public Wscproarg() {
	}

	/** full constructor */
	public Wscproarg(Wscproduct wscproduct, String name, String csvalue,
			Integer ison, Integer orderid) {
		this.wscproduct = wscproduct;
		this.name = name;
		this.csvalue = csvalue;
		this.ison = ison;
		this.orderid = orderid;
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
	@JoinColumn(name = "wscproductid")
	public Wscproduct getWscproduct() {
		return this.wscproduct;
	}

	public void setWscproduct(Wscproduct wscproduct) {
		this.wscproduct = wscproduct;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "csvalue", length = 30)
	public String getCsvalue() {
		return this.csvalue;
	}

	public void setCsvalue(String csvalue) {
		this.csvalue = csvalue;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}