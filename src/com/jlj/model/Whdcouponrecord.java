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
 * Whdcouponrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdcouponrecord", catalog = "wsp")
public class Whdcouponrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Whdcoupon whdcoupon;
	private Wscpscenter wscpscenter;
	private Date usetime;
	private String sncode;
	private String note;

	// Constructors

	/** default constructor */
	public Whdcouponrecord() {
	}

	/** full constructor */
	public Whdcouponrecord(Whdcoupon whdcoupon, Wscpscenter wscpscenter,
			Date usetime, String sncode, String note) {
		this.whdcoupon = whdcoupon;
		this.wscpscenter = wscpscenter;
		this.usetime = usetime;
		this.sncode = sncode;
		this.note = note;
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
	@JoinColumn(name = "whdcouponid")
	public Whdcoupon getWhdcoupon() {
		return this.whdcoupon;
	}

	public void setWhdcoupon(Whdcoupon whdcoupon) {
		this.whdcoupon = whdcoupon;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wscpscenterid")
	public Wscpscenter getWscpscenter() {
		return this.wscpscenter;
	}

	public void setWscpscenter(Wscpscenter wscpscenter) {
		this.wscpscenter = wscpscenter;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "usetime", length = 19)
	public Date getUsetime() {
		return this.usetime;
	}

	public void setUsetime(Date usetime) {
		this.usetime = usetime;
	}

	@Column(name = "sncode", length = 20)
	public String getSncode() {
		return this.sncode;
	}

	public void setSncode(String sncode) {
		this.sncode = sncode;
	}

	@Column(name = "note", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}