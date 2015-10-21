package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Whk entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whk", catalog = "wsp")
public class Whk implements java.io.Serializable {

	// Fields

	private Integer id;
	private String keyword;
	private String title;
	private String coverimg;
	private String info;
	private Integer hktype;
	private Integer hkdh;
	private String hkzf;
	private String jkr;
	private String linkurl;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Whk() {
	}

	/** full constructor */
	public Whk(String keyword, String title, String coverimg, String info,
			Integer hktype, Integer hkdh, String hkzf, String jkr,
			String linkurl, String publicaccount) {
		this.keyword = keyword;
		this.title = title;
		this.coverimg = coverimg;
		this.info = info;
		this.hktype = hktype;
		this.hkdh = hkdh;
		this.hkzf = hkzf;
		this.jkr = jkr;
		this.linkurl = linkurl;
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

	@Column(name = "keyword", length = 50)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "coverimg", length = 100)
	public String getCoverimg() {
		return this.coverimg;
	}

	public void setCoverimg(String coverimg) {
		this.coverimg = coverimg;
	}

	@Column(name = "info", length = 300)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "hktype")
	public Integer getHktype() {
		return this.hktype;
	}

	public void setHktype(Integer hktype) {
		this.hktype = hktype;
	}

	@Column(name = "hkdh")
	public Integer getHkdh() {
		return this.hkdh;
	}

	public void setHkdh(Integer hkdh) {
		this.hkdh = hkdh;
	}

	@Column(name = "hkzf", length = 300)
	public String getHkzf() {
		return this.hkzf;
	}

	public void setHkzf(String hkzf) {
		this.hkzf = hkzf;
	}

	@Column(name = "jkr", length = 30)
	public String getJkr() {
		return this.jkr;
	}

	public void setJkr(String jkr) {
		this.jkr = jkr;
	}

	@Column(name = "linkurl", length = 100)
	public String getLinkurl() {
		return this.linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}