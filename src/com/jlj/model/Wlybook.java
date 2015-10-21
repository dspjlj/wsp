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
 * Wlybook entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wlybook", catalog = "wsp")
public class Wlybook implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wly wly;
	private String usename;
	private String openid;
	private String content;
	private Date writetime;
	private Integer status;

	// Constructors

	/** default constructor */
	public Wlybook() {
	}

	/** full constructor */
	public Wlybook(Wly wly, String usename, String openid, String content,
			Date writetime, Integer status) {
		this.wly = wly;
		this.usename = usename;
		this.openid = openid;
		this.content = content;
		this.writetime = writetime;
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
	@JoinColumn(name = "wlyid")
	public Wly getWly() {
		return this.wly;
	}

	public void setWly(Wly wly) {
		this.wly = wly;
	}

	@Column(name = "usename", length = 30)
	public String getUsename() {
		return this.usename;
	}

	public void setUsename(String usename) {
		this.usename = usename;
	}

	@Column(name = "openid", length = 30)
	public String getOpenid() {
		return this.openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "writetime", length = 19)
	public Date getWritetime() {
		return this.writetime;
	}

	public void setWritetime(Date writetime) {
		this.writetime = writetime;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}