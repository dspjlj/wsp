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
 * Wtprecord entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wtprecord", catalog = "wsp")
public class Wtprecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wtptk wtptk;
	private Wscpscenter wscpscenter;
	private Wtp wtp;
	private Date jointime;

	// Constructors

	/** default constructor */
	public Wtprecord() {
	}

	/** full constructor */
	public Wtprecord(Wtptk wtptk, Wscpscenter wscpscenter, Wtp wtp,
			Date jointime) {
		this.wtptk = wtptk;
		this.wscpscenter = wscpscenter;
		this.wtp = wtp;
		this.jointime = jointime;
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
	@JoinColumn(name = "wtptkid")
	public Wtptk getWtptk() {
		return this.wtptk;
	}

	public void setWtptk(Wtptk wtptk) {
		this.wtptk = wtptk;
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
	@JoinColumn(name = "wtpid")
	public Wtp getWtp() {
		return this.wtp;
	}

	public void setWtp(Wtp wtp) {
		this.wtp = wtp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "jointime", length = 19)
	public Date getJointime() {
		return this.jointime;
	}

	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}

}