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
 * Pagearticle entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pagearticle", catalog = "wsp")
public class Pagearticle implements java.io.Serializable {

	// Fields

	private Integer id;
	private Bigtype bigtype;
	private String name;
	private String shortname;
	private String imageurl;
	private Integer ison;
	private Date createtime;
	private String videourl;
	private String description;
	private Integer articletype;
	private String linkurl;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Pagearticle() {
	}

	/** full constructor */
	public Pagearticle(Bigtype bigtype, String name, String shortname,
			String imageurl, Integer ison, Date createtime, String videourl,
			String description, Integer articletype, String linkurl,
			String publicaccount) {
		this.bigtype = bigtype;
		this.name = name;
		this.shortname = shortname;
		this.imageurl = imageurl;
		this.ison = ison;
		this.createtime = createtime;
		this.videourl = videourl;
		this.description = description;
		this.articletype = articletype;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "btid")
	public Bigtype getBigtype() {
		return this.bigtype;
	}

	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "shortname", length = 100)
	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createtime", length = 19)
	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(name = "videourl")
	public String getVideourl() {
		return this.videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "articletype")
	public Integer getArticletype() {
		return this.articletype;
	}

	public void setArticletype(Integer articletype) {
		this.articletype = articletype;
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