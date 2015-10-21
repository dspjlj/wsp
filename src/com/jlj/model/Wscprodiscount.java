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
 * Wscprodiscount entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscprodiscount", catalog = "wsp")
public class Wscprodiscount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private Wscproduct wscproduct;
	private Float discount;

	// Constructors

	/** default constructor */
	public Wscprodiscount() {
	}

	/** full constructor */
	public Wscprodiscount(Wscpscenter wscpscenter, Wscproduct wscproduct,
			Float discount) {
		this.wscpscenter = wscpscenter;
		this.wscproduct = wscproduct;
		this.discount = discount;
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

	@Column(name = "discount", precision = 12, scale = 0)
	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}