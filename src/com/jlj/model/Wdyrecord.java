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
 * Wdyrecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wdyrecord", catalog = "wsp")
public class Wdyrecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private Wdytk wdytk;
	private Date jointime;
	private String note;
	private String whatxx;

	// Constructors

	/** default constructor */
	public Wdyrecord() {
	}

	/** full constructor */
	public Wdyrecord(Wscpscenter wscpscenter, Wdytk wdytk, Date jointime,
			String note, String whatxx) {
		this.wscpscenter = wscpscenter;
		this.wdytk = wdytk;
		this.jointime = jointime;
		this.note = note;
		this.whatxx = whatxx;
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
	@JoinColumn(name = "wdytkid")
	public Wdytk getWdytk() {
		return this.wdytk;
	}

	public void setWdytk(Wdytk wdytk) {
		this.wdytk = wdytk;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "jointime", length = 19)
	public Date getJointime() {
		return this.jointime;
	}

	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}

	@Column(name = "note", length = 200)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "whatxx", length = 65535)
	public String getWhatxx() {
		return this.whatxx;
	}

	public void setWhatxx(String whatxx) {
		this.whatxx = whatxx;
	}

}