package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Diypuff entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "diypuff", catalog = "wsp")
public class Diypuff implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String ewmimg;
	private String funinfo;
	private String copyright;
	private String linkurl;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Diypuff() {
	}

	/** full constructor */
	public Diypuff(String title, String ewmimg, String funinfo,
			String copyright, String linkurl, String publicaccount) {
		this.title = title;
		this.ewmimg = ewmimg;
		this.funinfo = funinfo;
		this.copyright = copyright;
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

	@Column(name = "title", length = 40)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "ewmimg", length = 100)
	public String getEwmimg() {
		return this.ewmimg;
	}

	public void setEwmimg(String ewmimg) {
		this.ewmimg = ewmimg;
	}

	@Column(name = "funinfo", length = 65535)
	public String getFuninfo() {
		return this.funinfo;
	}

	public void setFuninfo(String funinfo) {
		this.funinfo = funinfo;
	}

	@Column(name = "copyright", length = 50)
	public String getCopyright() {
		return this.copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
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