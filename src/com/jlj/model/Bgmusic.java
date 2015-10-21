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
 * Bgmusic entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bgmusic", catalog = "wsp")
public class Bgmusic implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wgw wgw;
	private String name;
	private String musicurl;
	private Integer ison;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Bgmusic() {
	}

	/** full constructor */
	public Bgmusic(Wgw wgw, String name, String musicurl, Integer ison,
			String publicaccount) {
		this.wgw = wgw;
		this.name = name;
		this.musicurl = musicurl;
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
	@JoinColumn(name = "wgwid")
	public Wgw getWgw() {
		return this.wgw;
	}

	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "musicurl")
	public String getMusicurl() {
		return this.musicurl;
	}

	public void setMusicurl(String musicurl) {
		this.musicurl = musicurl;
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