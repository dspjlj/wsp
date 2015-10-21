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
 * Wscprocomment entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscprocomment", catalog = "wsp")
public class Wscprocomment implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscproduct wscproduct;
	private String commentman;
	private String comcontent;
	private Date comtime;
	private Integer level;
	private Integer isshenhe;

	// Constructors

	/** default constructor */
	public Wscprocomment() {
	}

	/** full constructor */
	public Wscprocomment(Wscproduct wscproduct, String commentman,
			String comcontent, Date comtime, Integer level, Integer isshenhe) {
		this.wscproduct = wscproduct;
		this.commentman = commentman;
		this.comcontent = comcontent;
		this.comtime = comtime;
		this.level = level;
		this.isshenhe = isshenhe;
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
	@JoinColumn(name = "wscproductid")
	public Wscproduct getWscproduct() {
		return this.wscproduct;
	}

	public void setWscproduct(Wscproduct wscproduct) {
		this.wscproduct = wscproduct;
	}

	@Column(name = "commentman", length = 30)
	public String getCommentman() {
		return this.commentman;
	}

	public void setCommentman(String commentman) {
		this.commentman = commentman;
	}

	@Column(name = "comcontent", length = 30)
	public String getComcontent() {
		return this.comcontent;
	}

	public void setComcontent(String comcontent) {
		this.comcontent = comcontent;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "comtime", length = 19)
	public Date getComtime() {
		return this.comtime;
	}

	public void setComtime(Date comtime) {
		this.comtime = comtime;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "isshenhe")
	public Integer getIsshenhe() {
		return this.isshenhe;
	}

	public void setIsshenhe(Integer isshenhe) {
		this.isshenhe = isshenhe;
	}

}