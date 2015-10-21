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
 * Wscprocollect entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscprocollect", catalog = "wsp")
public class Wscprocollect implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private Wscproduct wscproduct;

	// Constructors

	/** default constructor */
	public Wscprocollect() {
	}

	/** full constructor */
	public Wscprocollect(Wscpscenter wscpscenter, Wscproduct wscproduct) {
		this.wscpscenter = wscpscenter;
		this.wscproduct = wscproduct;
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
	@JoinColumn(name = "wscpscenterid")
	public Wscpscenter getWscpscenter() {
		return this.wscpscenter;
	}

	public void setWscpscenter(Wscpscenter wscpscenter) {
		this.wscpscenter = wscpscenter;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wscproductid")
	public Wscproduct getWscproduct() {
		return this.wscproduct;
	}

	public void setWscproduct(Wscproduct wscproduct) {
		this.wscproduct = wscproduct;
	}

}