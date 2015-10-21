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
 * Wscorderpro entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscorderpro", catalog = "wsp")
public class Wscorderpro implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscaddress wscaddress;
	private Wscproxgpz wscproxgpz;
	private Wscorder wscorder;
	private Wscproduct wscproduct;
	private Integer num;

	// Constructors

	/** default constructor */
	public Wscorderpro() {
	}

	/** full constructor */
	public Wscorderpro(Wscaddress wscaddress, Wscproxgpz wscproxgpz,
			Wscorder wscorder, Wscproduct wscproduct, Integer num) {
		this.wscaddress = wscaddress;
		this.wscproxgpz = wscproxgpz;
		this.wscorder = wscorder;
		this.wscproduct = wscproduct;
		this.num = num;
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
	@JoinColumn(name = "wscaddressid")
	public Wscaddress getWscaddress() {
		return this.wscaddress;
	}

	public void setWscaddress(Wscaddress wscaddress) {
		this.wscaddress = wscaddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wscproxgpzid")
	public Wscproxgpz getWscproxgpz() {
		return this.wscproxgpz;
	}

	public void setWscproxgpz(Wscproxgpz wscproxgpz) {
		this.wscproxgpz = wscproxgpz;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wscorderid")
	public Wscorder getWscorder() {
		return this.wscorder;
	}

	public void setWscorder(Wscorder wscorder) {
		this.wscorder = wscorder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wscproductid")
	public Wscproduct getWscproduct() {
		return this.wscproduct;
	}

	public void setWscproduct(Wscproduct wscproduct) {
		this.wscproduct = wscproduct;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}