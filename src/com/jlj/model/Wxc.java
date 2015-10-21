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
 * Wxc entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wxc", catalog = "wsp")
public class Wxc implements java.io.Serializable {

	// Fields

	private Integer id;
	private String topimg;
	private Integer showtype;
	private String linkurl;
	private String publicaccount;
	private Set<Album> albums = new HashSet<Album>(0);

	// Constructors

	/** default constructor */
	public Wxc() {
	}

	/** full constructor */
	public Wxc(String topimg, Integer showtype, String linkurl,
			String publicaccount, Set<Album> albums) {
		this.topimg = topimg;
		this.showtype = showtype;
		this.linkurl = linkurl;
		this.publicaccount = publicaccount;
		this.albums = albums;
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

	@Column(name = "topimg", length = 100)
	public String getTopimg() {
		return this.topimg;
	}

	public void setTopimg(String topimg) {
		this.topimg = topimg;
	}

	@Column(name = "showtype")
	public Integer getShowtype() {
		return this.showtype;
	}

	public void setShowtype(Integer showtype) {
		this.showtype = showtype;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wxc")
	public Set<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

}