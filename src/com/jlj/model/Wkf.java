package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wkf entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wkf", catalog = "wsp")
public class Wkf implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String keyword;
	private String imageurl;
	private String info;
	private String fkcode;
	private String linkurl;
	private Integer ison;
	private Integer orderid;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Wkf() {
	}

	/** full constructor */
	public Wkf(String title, String keyword, String imageurl, String info,
			String fkcode, String linkurl, Integer ison, Integer orderid,
			String publicaccount) {
		this.title = title;
		this.keyword = keyword;
		this.imageurl = imageurl;
		this.info = info;
		this.fkcode = fkcode;
		this.linkurl = linkurl;
		this.ison = ison;
		this.orderid = orderid;
		this.publicaccount = publicaccount;
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

	@Column(name = "keyword", length = 100)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name = "info", length = 300)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "fkcode", length = 300)
	public String getFkcode() {
		return this.fkcode;
	}

	public void setFkcode(String fkcode) {
		this.fkcode = fkcode;
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

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}