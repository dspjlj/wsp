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
 * Wgw entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wgw", catalog = "wsp")
public class Wgw implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String linkurl;
	private String info;
	private Integer template1;
	private Integer template2;
	private Integer template3;
	private Integer template4;
	private String publicaccount;
	private Set<Screenimg> screenimgs = new HashSet<Screenimg>(0);
	private Set<Bgmusic> bgmusics = new HashSet<Bgmusic>(0);
	private Set<Wgwmenu> wgwmenus = new HashSet<Wgwmenu>(0);
	private Set<Footer> footers = new HashSet<Footer>(0);
	private Set<Bigtype> bigtypes = new HashSet<Bigtype>(0);

	// Constructors

	/** default constructor */
	public Wgw() {
	}

	/** full constructor */
	public Wgw(String title, String linkurl, 
			String info, Integer template1, Integer template2,
			Integer template3, Integer template4, String publicaccount,
			Set<Screenimg> screenimgs, Set<Bgmusic> bgmusics,
			Set<Wgwmenu> wgwmenus, Set<Footer> footers, Set<Bigtype> bigtypes) {
		this.title = title;
		this.linkurl = linkurl;
		this.info = info;
		this.template1 = template1;
		this.template2 = template2;
		this.template3 = template3;
		this.template4 = template4;
		this.publicaccount = publicaccount;
		this.screenimgs = screenimgs;
		this.bgmusics = bgmusics;
		this.wgwmenus = wgwmenus;
		this.footers = footers;
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

	@Column(name = "template2")
	public Integer getTemplate2() {
		return this.template2;
	}

	public void setTemplate2(Integer template2) {
		this.template2 = template2;
	}

	@Column(name = "template3")
	public Integer getTemplate3() {
		return this.template3;
	}

	public void setTemplate3(Integer template3) {
		this.template3 = template3;
	}

	@Column(name = "template4")
	public Integer getTemplate4() {
		return this.template4;
	}

	public void setTemplate4(Integer template4) {
		this.template4 = template4;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wgw")
	public Set<Screenimg> getScreenimgs() {
		return this.screenimgs;
	}

	public void setScreenimgs(Set<Screenimg> screenimgs) {
		this.screenimgs = screenimgs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wgw")
	public Set<Bgmusic> getBgmusics() {
		return this.bgmusics;
	}

	public void setBgmusics(Set<Bgmusic> bgmusics) {
		this.bgmusics = bgmusics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wgw")
	public Set<Wgwmenu> getWgwmenus() {
		return this.wgwmenus;
	}

	public void setWgwmenus(Set<Wgwmenu> wgwmenus) {
		this.wgwmenus = wgwmenus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wgw")
	public Set<Footer> getFooters() {
		return this.footers;
	}

	public void setFooters(Set<Footer> footers) {
		this.footers = footers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wgw")
	public Set<Bigtype> getBigtypes() {
		return this.bigtypes;
	}

	public void setBigtypes(Set<Bigtype> bigtypes) {
		this.bigtypes = bigtypes;
	}

}