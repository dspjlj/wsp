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
 * Album entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "album", catalog = "wsp")
public class Album implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wxc wxc;
	private String name;
	private String keyword;
	private String tuwenimg;
	private String xcimg;
	private String info;
	private Integer ison;
	private Integer orderid;
	private Set<Photo> photos = new HashSet<Photo>(0);

	// Constructors

	/** default constructor */
	public Album() {
	}

	/** full constructor */
	public Album(Wxc wxc, String name, String keyword, String tuwenimg,
			String xcimg, String info, Integer ison, Integer orderid,
			Set<Photo> photos) {
		this.wxc = wxc;
		this.name = name;
		this.keyword = keyword;
		this.tuwenimg = tuwenimg;
		this.xcimg = xcimg;
		this.info = info;
		this.ison = ison;
		this.orderid = orderid;
		this.photos = photos;
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
	@JoinColumn(name = "wxcid")
	public Wxc getWxc() {
		return this.wxc;
	}

	public void setWxc(Wxc wxc) {
		this.wxc = wxc;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "keyword", length = 20)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "tuwenimg", length = 100)
	public String getTuwenimg() {
		return this.tuwenimg;
	}

	public void setTuwenimg(String tuwenimg) {
		this.tuwenimg = tuwenimg;
	}

	@Column(name = "xcimg", length = 100)
	public String getXcimg() {
		return this.xcimg;
	}

	public void setXcimg(String xcimg) {
		this.xcimg = xcimg;
	}

	@Column(name = "info", length = 200)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "album")
	public Set<Photo> getPhotos() {
		return this.photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

}