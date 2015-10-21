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
 * Wyyorder entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wyyorder", catalog = "wsp")
public class Wyyorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wyy wyy;
	private String user;
	private String phone;
	private Date yydate;
	private Date createtime;
	private String note;
	private Integer status;

	// Constructors

	/** default constructor */
	public Wyyorder() {
	}

	/** full constructor */
	public Wyyorder(Wyy wyy, String user, String phone, Date yydate,
			Date createtime, String note, Integer status) {
		this.wyy = wyy;
		this.user = user;
		this.phone = phone;
		this.yydate = yydate;
		this.createtime = createtime;
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
	@JoinColumn(name = "wyyid")
	public Wyy getWyy() {
		return this.wyy;
	}

	public void setWyy(Wyy wyy) {
		this.wyy = wyy;
	}

	@Column(name = "user", length = 20)
	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "yydate", length = 19)
	public Date getYydate() {
		return this.yydate;
	}

	public void setYydate(Date yydate) {
		this.yydate = yydate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "note", length = 65535)
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