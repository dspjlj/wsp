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
 * Wyy entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wyy", catalog = "wsp")
public class Wyy implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyword;
	private String imageurl;
	private String yyaddress;
	private String yyphone;
	private String yyimageurl;
	private String mapstr;
	private String mapx;
	private String mapy;
	private String info;
	private String detail;
	private Integer ison;
	private Integer orderid;
	private String publicaccount;
	private Set<Wyyorder> wyyorders = new HashSet<Wyyorder>(0);

	// Constructors

	/** default constructor */
	public Wyy() {
	}

	/** full constructor */
	public Wyy(String name, String keyword, String imageurl, String yyaddress,
			String yyphone, String yyimageurl, String mapstr, String mapx,
			String mapy, String info, String detail, Integer ison,
			Integer orderid, String publicaccount, Set<Wyyorder> wyyorders) {
		this.name = name;
		this.keyword = keyword;
		this.imageurl = imageurl;
		this.yyaddress = yyaddress;
		this.yyphone = yyphone;
		this.yyimageurl = yyimageurl;
		this.mapstr = mapstr;
		this.mapx = mapx;
		this.mapy = mapy;
		this.info = info;
		this.detail = detail;
		this.ison = ison;
		this.orderid = orderid;
		this.publicaccount = publicaccount;
		this.wyyorders = wyyorders;
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

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name = "yyaddress", length = 100)
	public String getYyaddress() {
		return this.yyaddress;
	}

	public void setYyaddress(String yyaddress) {
		this.yyaddress = yyaddress;
	}

	@Column(name = "yyphone", length = 20)
	public String getYyphone() {
		return this.yyphone;
	}

	public void setYyphone(String yyphone) {
		this.yyphone = yyphone;
	}

	@Column(name = "yyimageurl", length = 100)
	public String getYyimageurl() {
		return this.yyimageurl;
	}

	public void setYyimageurl(String yyimageurl) {
		this.yyimageurl = yyimageurl;
	}

	@Column(name = "mapstr", length = 100)
	public String getMapstr() {
		return this.mapstr;
	}

	public void setMapstr(String mapstr) {
		this.mapstr = mapstr;
	}

	@Column(name = "mapx", length = 20)
	public String getMapx() {
		return this.mapx;
	}

	public void setMapx(String mapx) {
		this.mapx = mapx;
	}

	@Column(name = "mapy", length = 20)
	public String getMapy() {
		return this.mapy;
	}

	public void setMapy(String mapy) {
		this.mapy = mapy;
	}

	@Column(name = "info", length = 200)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "detail", length = 65535)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wyy")
	public Set<Wyyorder> getWyyorders() {
		return this.wyyorders;
	}

	public void setWyyorders(Set<Wyyorder> wyyorders) {
		this.wyyorders = wyyorders;
	}

}