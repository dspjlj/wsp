package com.jlj.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bigtype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bigtype", catalog = "wsp")
public class Bigtype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wgw wgw;
	private Bigtype bigtype;
	private String name;
	private String enname;
	private String imageurl;
	private Integer ison;
	private Integer orderid;
	private Integer ttype;
	private String linkurl;
	private Integer isend;
	private String publicaccount;
	private Set<Pagearticle> pagearticles = new HashSet<Pagearticle>(0);
	private Set<Bigtype> bigtypes = new HashSet<Bigtype>(0);

	// Constructors

	/** default constructor */
	public Bigtype() {
	}

	/** full constructor */
	public Bigtype(Wgw wgw, Bigtype bigtype, String name, String enname,
			String imageurl, Integer ison, Integer orderid, Integer ttype,
			String linkurl, Integer isend, String publicaccount,
			Set<Pagearticle> pagearticles, Set<Bigtype> bigtypes) {
		this.wgw = wgw;
		this.bigtype = bigtype;
		this.name = name;
		this.enname = enname;
		this.imageurl = imageurl;
		this.ison = ison;
		this.orderid = orderid;
		this.ttype = ttype;
		this.linkurl = linkurl;
		this.isend = isend;
		this.publicaccount = publicaccount;
		this.pagearticles = pagearticles;
		this.bigtypes = bigtypes;
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
	@JoinColumn(name = "wgwid")
	public Wgw getWgw() {
		return this.wgw;
	}

	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bigtypeid")
	public Bigtype getBigtype() {
		return this.bigtype;
	}

	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "enname", length = 30)
	public String getEnname() {
		return this.enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
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

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@Column(name = "ttype")
	public Integer getTtype() {
		return this.ttype;
	}

	public void setTtype(Integer ttype) {
		this.ttype = ttype;
	}

	@Column(name = "linkurl", length = 100)
	public String getLinkurl() {
		return this.linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	@Column(name = "isend")
	public Integer getIsend() {
		return this.isend;
	}

	public void setIsend(Integer isend) {
		this.isend = isend;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bigtype")
	public Set<Pagearticle> getPagearticles() {
		return this.pagearticles;
	}

	public void setPagearticles(Set<Pagearticle> pagearticles) {
		this.pagearticles = pagearticles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bigtype")
	public Set<Bigtype> getBigtypes() {
		return this.bigtypes;
	}

	public void setBigtypes(Set<Bigtype> bigtypes) {
		this.bigtypes = bigtypes;
	}

}