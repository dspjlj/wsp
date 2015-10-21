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
 * Wsctype entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wsctype", catalog = "wsp")
public class Wsctype implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wsc wsc;
	private String name;
	private String info;
	private String imageurl;
	private Integer ison;
	private Integer orderid;
	private String publicaccount;
	private Set<Wscproduct> wscproducts = new HashSet<Wscproduct>(0);

	// Constructors

	/** default constructor */
	public Wsctype() {
	}

	/** full constructor */
	public Wsctype(Wsc wsc, String name, String info, String imageurl,
			Integer ison, Integer orderid, String publicaccount,
			Set<Wscproduct> wscproducts) {
		this.wsc = wsc;
		this.name = name;
		this.info = info;
		this.imageurl = imageurl;
		this.ison = ison;
		this.orderid = orderid;
		this.publicaccount = publicaccount;
		this.wscproducts = wscproducts;
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
	@JoinColumn(name = "wscid")
	public Wsc getWsc() {
		return this.wsc;
	}

	public void setWsc(Wsc wsc) {
		this.wsc = wsc;
	}

	@Column(name = "name", length = 30)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "info", length = 200)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wsctype")
	public Set<Wscproduct> getWscproducts() {
		return this.wscproducts;
	}

	public void setWscproducts(Set<Wscproduct> wscproducts) {
		this.wscproducts = wscproducts;
	}

}