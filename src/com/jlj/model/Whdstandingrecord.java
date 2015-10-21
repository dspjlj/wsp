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
 * Whdstandingrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdstandingrecord", catalog = "wsp")
public class Whdstandingrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private Whdstanding whdstanding;
	private Integer datinum;
	private Integer rightnum;
	private Integer todaydatinum;
	private Integer datidaynum;
	private Date usetime;
	private String note;
	private Integer islingjiang;

	// Constructors

	/** default constructor */
	public Whdstandingrecord() {
	}

	/** full constructor */
	public Whdstandingrecord(Wscpscenter wscpscenter, Whdstanding whdstanding,
			Integer datinum, Integer rightnum, Integer todaydatinum,
			Integer datidaynum, Date usetime, String note, Integer islingjiang) {
		this.wscpscenter = wscpscenter;
		this.whdstanding = whdstanding;
		this.datinum = datinum;
		this.rightnum = rightnum;
		this.todaydatinum = todaydatinum;
		this.datidaynum = datidaynum;
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
	@JoinColumn(name = "whdstandingid")
	public Whdstanding getWhdstanding() {
		return this.whdstanding;
	}

	public void setWhdstanding(Whdstanding whdstanding) {
		this.whdstanding = whdstanding;
	}

	@Column(name = "datinum")
	public Integer getDatinum() {
		return this.datinum;
	}

	public void setDatinum(Integer datinum) {
		this.datinum = datinum;
	}

	@Column(name = "rightnum")
	public Integer getRightnum() {
		return this.rightnum;
	}

	public void setRightnum(Integer rightnum) {
		this.rightnum = rightnum;
	}

	@Column(name = "todaydatinum")
	public Integer getTodaydatinum() {
		return this.todaydatinum;
	}

	public void setTodaydatinum(Integer todaydatinum) {
		this.todaydatinum = todaydatinum;
	}

	@Column(name = "datidaynum")
	public Integer getDatidaynum() {
		return this.datidaynum;
	}

	public void setDatidaynum(Integer datidaynum) {
		this.datidaynum = datidaynum;
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