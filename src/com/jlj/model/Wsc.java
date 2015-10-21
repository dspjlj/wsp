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
 * Wsc entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wsc", catalog = "wsp")
public class Wsc implements java.io.Serializable {

	// Fields

	private Integer id;
	private String keyword;
	private String title;
	private String linkurl;
	private String imageurl;
	private Integer ison;
	private String info;
	private Integer template1;
	private String publicaccount;
	private Set<Wsctype> wsctypes = new HashSet<Wsctype>(0);
	private Set<Wscpscenter> wscpscenters = new HashSet<Wscpscenter>(0);
	private Set<Wscscrimg> wscscrimgs = new HashSet<Wscscrimg>(0);

	// Constructors

	/** default constructor */
	public Wsc() {
	}

	/** full constructor */
	public Wsc(String keyword, String title, String linkurl, String imageurl,
			Integer ison, String info, Integer template1, String publicaccount,
			Set<Wsctype> wsctypes, Set<Wscpscenter> wscpscenters,
			Set<Wscscrimg> wscscrimgs) {
		this.keyword = keyword;
		this.title = title;
		this.linkurl = linkurl;
		this.imageurl = imageurl;
		this.ison = ison;
		this.info = info;
		this.template1 = template1;
		this.publicaccount = publicaccount;
		this.wsctypes = wsctypes;
		this.wscpscenters = wscpscenters;
		this.wscscrimgs = wscscrimgs;
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

	@Column(name = "keyword", length = 20)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "title", length = 60)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "linkurl", length = 100)
	public String getLinkurl() {
		return this.linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
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

	@Column(name = "info", length = 300)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "template1")
	public Integer getTemplate1() {
		return this.template1;
	}

	public void setTemplate1(Integer template1) {
		this.template1 = template1;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wsc")
	public Set<Wsctype> getWsctypes() {
		return this.wsctypes;
	}

	public void setWsctypes(Set<Wsctype> wsctypes) {
		this.wsctypes = wsctypes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wsc")
	public Set<Wscpscenter> getWscpscenters() {
		return this.wscpscenters;
	}

	public void setWscpscenters(Set<Wscpscenter> wscpscenters) {
		this.wscpscenters = wscpscenters;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wsc")
	public Set<Wscscrimg> getWscscrimgs() {
		return this.wscscrimgs;
	}

	public void setWscscrimgs(Set<Wscscrimg> wscscrimgs) {
		this.wscscrimgs = wscscrimgs;
	}

}