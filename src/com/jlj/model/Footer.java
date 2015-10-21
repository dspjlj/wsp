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
 * Footer entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "footer", catalog = "wsp")
public class Footer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wgw wgw;
	private String foottitle;
	private Integer ison;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Footer() {
	}

	/** full constructor */
	public Footer(Wgw wgw, String foottitle, Integer ison, String publicaccount) {
		this.wgw = wgw;
		this.foottitle = foottitle;
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

	@Column(name = "foottitle", length = 100)
	public String getFoottitle() {
		return this.foottitle;
	}

	public void setFoottitle(String foottitle) {
		this.foottitle = foottitle;
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