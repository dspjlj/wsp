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
 * Whdscratchcardrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdscratchcardrecord", catalog = "wsp")
public class Whdscratchcardrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private Whdscratchcard whdscratchcard;
	private String sncode;
	private Date usetime;
	private String note;
	private Integer islingjiang;

	// Constructors

	/** default constructor */
	public Whdscratchcardrecord() {
	}

	/** full constructor */
	public Whdscratchcardrecord(Wscpscenter wscpscenter,
			Whdscratchcard whdscratchcard, String sncode, Date usetime,
			String note, Integer islingjiang) {
		this.wscpscenter = wscpscenter;
		this.whdscratchcard = whdscratchcard;
		this.sncode = sncode;
		this.usetime = usetime;
		this.note = note;
		this.islingjiang = islingjiang;
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
	@JoinColumn(name = "whdscratchcardid")
	public Whdscratchcard getWhdscratchcard() {
		return this.whdscratchcard;
	}

	public void setWhdscratchcard(Whdscratchcard whdscratchcard) {
		this.whdscratchcard = whdscratchcard;
	}

	@Column(name = "sncode", length = 30)
	public String getSncode() {
		return this.sncode;
	}

	public void setSncode(String sncode) {
		this.sncode = sncode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "usetime", length = 19)
	public Date getUsetime() {
		return this.usetime;
	}

	public void setUsetime(Date usetime) {
		this.usetime = usetime;
	}

	@Column(name = "note", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "islingjiang")
	public Integer getIslingjiang() {
		return this.islingjiang;
	}

	public void setIslingjiang(Integer islingjiang) {
		this.islingjiang = islingjiang;
	}

}