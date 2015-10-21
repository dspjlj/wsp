package com.jlj.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wtg entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wtg", catalog = "wsp")
public class Wtg implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyword;
	private Float discount;
	private Float price;
	private Date starttime;
	private Date endtime;
	private String proimg;
	private String description;
	private String exalert;
	private Integer status;
	private String publicaccount;
	private Set<Wtgrecord> wtgrecords = new HashSet<Wtgrecord>(0);

	// Constructors

	/** default constructor */
	public Wtg() {
	}

	/** full constructor */
	public Wtg(String name, String keyword, Float discount, Float price,
			Date starttime, Date endtime, String proimg, String description,
			String exalert, Integer status, String publicaccount,
			Set<Wtgrecord> wtgrecords) {
		this.name = name;
		this.keyword = keyword;
		this.discount = discount;
		this.price = price;
		this.starttime = starttime;
		this.endtime = endtime;
		this.proimg = proimg;
		this.description = description;
		this.exalert = exalert;
		this.status = status;
		this.publicaccount = publicaccount;
		this.wtgrecords = wtgrecords;
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

	@Column(name = "name", length = 40)
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

	@Column(name = "discount", precision = 12, scale = 0)
	public Float getDiscount() {
		return this.discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "starttime", length = 19)
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endtime", length = 19)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "proimg", length = 100)
	public String getProimg() {
		return this.proimg;
	}

	public void setProimg(String proimg) {
		this.proimg = proimg;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "exalert", length = 65535)
	public String getExalert() {
		return this.exalert;
	}

	public void setExalert(String exalert) {
		this.exalert = exalert;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wtg")
	public Set<Wtgrecord> getWtgrecords() {
		return this.wtgrecords;
	}

	public void setWtgrecords(Set<Wtgrecord> wtgrecords) {
		this.wtgrecords = wtgrecords;
	}

}