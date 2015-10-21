package com.jlj.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Wly entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wly", catalog = "wsp")
public class Wly implements java.io.Serializable {

	// Fields

	private Integer id;
	private String keyword;
	private String name;
	private String imageurl;
	private String topimage;
	private Integer ison;
	private String ownopenid;
	private String linkurl;
	private String publicaccount;
	private Set<Wlybook> wlybooks = new HashSet<Wlybook>(0);
	private Set<Wlyblack> wlyblacks = new HashSet<Wlyblack>(0);

	// Constructors

	/** default constructor */
	public Wly() {
	}

	/** full constructor */
	public Wly(String keyword, String name, String imageurl, String topimage,
			Integer ison, String ownopenid, String linkurl,
			String publicaccount, Set<Wlybook> wlybooks, Set<Wlyblack> wlyblacks) {
		this.keyword = keyword;
		this.name = name;
		this.imageurl = imageurl;
		this.topimage = topimage;
		this.ison = ison;
		this.ownopenid = ownopenid;
		this.linkurl = linkurl;
		this.publicaccount = publicaccount;
		this.wlybooks = wlybooks;
		this.wlyblacks = wlyblacks;
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

	@Column(name = "keyword", length = 30)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name = "topimage", length = 100)
	public String getTopimage() {
		return this.topimage;
	}

	public void setTopimage(String topimage) {
		this.topimage = topimage;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "ownopenid", length = 20)
	public String getOwnopenid() {
		return this.ownopenid;
	}

	public void setOwnopenid(String ownopenid) {
		this.ownopenid = ownopenid;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wly")
	public Set<Wlybook> getWlybooks() {
		return this.wlybooks;
	}

	public void setWlybooks(Set<Wlybook> wlybooks) {
		this.wlybooks = wlybooks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wly")
	public Set<Wlyblack> getWlyblacks() {
		return this.wlyblacks;
	}

	public void setWlyblacks(Set<Wlyblack> wlyblacks) {
		this.wlyblacks = wlyblacks;
	}

}