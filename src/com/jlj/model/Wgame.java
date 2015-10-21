package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wgame entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wgame", catalog = "wsp")
public class Wgame implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String info;
	private String linkurl;
	private Integer ison;
	private Integer orderid;

	// Constructors

	/** default constructor */
	public Wgame() {
	}

	/** full constructor */
	public Wgame(String title, String info, String linkurl, Integer ison,
			Integer orderid) {
		this.title = title;
		this.info = info;
		this.linkurl = linkurl;
		this.ison = ison;
		this.orderid = orderid;
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

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "info", length = 100)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "linkurl", length = 100)
	public String getLinkurl() {
		return this.linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}