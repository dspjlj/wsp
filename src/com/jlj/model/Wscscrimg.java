package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Wscscrimg entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscscrimg", catalog = "wsp")
public class Wscscrimg implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wsc wsc;
	private String name;
	private Integer imginterval;
	private String imageurl1;
	private String linkurl1;
	private String imageurl2;
	private String linkurl2;
	private String imageurl3;
	private String linkurl3;
	private String imageurl4;
	private String linkurl4;
	private Integer ison;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Wscscrimg() {
	}

	/** full constructor */
	public Wscscrimg(Wsc wsc, String name, Integer imginterval,
			String imageurl1, String linkurl1, String imageurl2,
			String linkurl2, String imageurl3, String linkurl3,
			String imageurl4, String linkurl4, Integer ison,
			String publicaccount) {
		this.wsc = wsc;
		this.name = name;
		this.imginterval = imginterval;
		this.imageurl1 = imageurl1;
		this.linkurl1 = linkurl1;
		this.imageurl2 = imageurl2;
		this.linkurl2 = linkurl2;
		this.imageurl3 = imageurl3;
		this.linkurl3 = linkurl3;
		this.imageurl4 = imageurl4;
		this.linkurl4 = linkurl4;
		this.ison = ison;
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
	@JoinColumn(name = "wscid")
	public Wsc getWsc() {
		return this.wsc;
	}

	public void setWsc(Wsc wsc) {
		this.wsc = wsc;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "imginterval")
	public Integer getImginterval() {
		return this.imginterval;
	}

	public void setImginterval(Integer imginterval) {
		this.imginterval = imginterval;
	}

	@Column(name = "imageurl1", length = 100)
	public String getImageurl1() {
		return this.imageurl1;
	}

	public void setImageurl1(String imageurl1) {
		this.imageurl1 = imageurl1;
	}

	@Column(name = "linkurl1", length = 100)
	public String getLinkurl1() {
		return this.linkurl1;
	}

	public void setLinkurl1(String linkurl1) {
		this.linkurl1 = linkurl1;
	}

	@Column(name = "imageurl2", length = 100)
	public String getImageurl2() {
		return this.imageurl2;
	}

	public void setImageurl2(String imageurl2) {
		this.imageurl2 = imageurl2;
	}

	@Column(name = "linkurl2", length = 100)
	public String getLinkurl2() {
		return this.linkurl2;
	}

	public void setLinkurl2(String linkurl2) {
		this.linkurl2 = linkurl2;
	}

	@Column(name = "imageurl3", length = 100)
	public String getImageurl3() {
		return this.imageurl3;
	}

	public void setImageurl3(String imageurl3) {
		this.imageurl3 = imageurl3;
	}

	@Column(name = "linkurl3", length = 100)
	public String getLinkurl3() {
		return this.linkurl3;
	}

	public void setLinkurl3(String linkurl3) {
		this.linkurl3 = linkurl3;
	}

	@Column(name = "imageurl4", length = 100)
	public String getImageurl4() {
		return this.imageurl4;
	}

	public void setImageurl4(String imageurl4) {
		this.imageurl4 = imageurl4;
	}

	@Column(name = "linkurl4", length = 100)
	public String getLinkurl4() {
		return this.linkurl4;
	}

	public void setLinkurl4(String linkurl4) {
		this.linkurl4 = linkurl4;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}