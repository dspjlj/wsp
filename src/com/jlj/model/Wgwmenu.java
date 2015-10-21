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
 * Wgwmenu entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wgwmenu", catalog = "wsp")
public class Wgwmenu implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wgw wgw;
	private String menu1;
	private String menu1url;
	private String menu2;
	private String menu2url;
	private String menu3;
	private String menu3url;
	private String menu4;
	private String menu4url;
	private String publicaccount;

	// Constructors

	/** default constructor */
	public Wgwmenu() {
	}

	/** full constructor */
	public Wgwmenu(Wgw wgw, String menu1, String menu1url, String menu2,
			String menu2url, String menu3, String menu3url, String menu4,
			String menu4url, String publicaccount) {
		this.wgw = wgw;
		this.menu1 = menu1;
		this.menu1url = menu1url;
		this.menu2 = menu2;
		this.menu2url = menu2url;
		this.menu3 = menu3;
		this.menu3url = menu3url;
		this.menu4 = menu4;
		this.menu4url = menu4url;
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

	@Column(name = "menu1", length = 50)
	public String getMenu1() {
		return this.menu1;
	}

	public void setMenu1(String menu1) {
		this.menu1 = menu1;
	}

	@Column(name = "menu1url", length = 100)
	public String getMenu1url() {
		return this.menu1url;
	}

	public void setMenu1url(String menu1url) {
		this.menu1url = menu1url;
	}

	@Column(name = "menu2", length = 50)
	public String getMenu2() {
		return this.menu2;
	}

	public void setMenu2(String menu2) {
		this.menu2 = menu2;
	}

	@Column(name = "menu2url", length = 100)
	public String getMenu2url() {
		return this.menu2url;
	}

	public void setMenu2url(String menu2url) {
		this.menu2url = menu2url;
	}

	@Column(name = "menu3", length = 50)
	public String getMenu3() {
		return this.menu3;
	}

	public void setMenu3(String menu3) {
		this.menu3 = menu3;
	}

	@Column(name = "menu3url", length = 100)
	public String getMenu3url() {
		return this.menu3url;
	}

	public void setMenu3url(String menu3url) {
		this.menu3url = menu3url;
	}

	@Column(name = "menu4", length = 50)
	public String getMenu4() {
		return this.menu4;
	}

	public void setMenu4(String menu4) {
		this.menu4 = menu4;
	}

	@Column(name = "menu4url", length = 100)
	public String getMenu4url() {
		return this.menu4url;
	}

	public void setMenu4url(String menu4url) {
		this.menu4url = menu4url;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

}