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
 * Wtgrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wtgrecord", catalog = "wsp")
public class Wtgrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private Wtg wtg;
	private Integer num;
	private Date usetime;
	private String note;
	private Integer status;

	// Constructors

	/** default constructor */
	public Wtgrecord() {
	}

	/** full constructor */
	public Wtgrecord(Wscpscenter wscpscenter, Wtg wtg, Integer num,
			Date usetime, String note, Integer status) {
		this.wscpscenter = wscpscenter;
		this.wtg = wtg;
		this.num = num;
		this.usetime = usetime;
		this.note = note;
		this.status = status;
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
	@JoinColumn(name = "wtgid")
	public Wtg getWtg() {
		return this.wtg;
	}

	public void setWtg(Wtg wtg) {
		this.wtg = wtg;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
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

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}