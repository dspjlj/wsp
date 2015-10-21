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
 * Whdcoupon entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdcoupon", catalog = "wsp")
public class Whdcoupon implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyword;
	private Date starttime;
	private Date endtime;
	private Integer status;
	private String showimg;
	private String description;
	private Integer num;
	private String publicaccount;
	private Set<Whdcouponrecord> whdcouponrecords = new HashSet<Whdcouponrecord>(
			0);

	// Constructors

	/** default constructor */
	public Whdcoupon() {
	}

	/** full constructor */
	public Whdcoupon(String name, String keyword, Date starttime, Date endtime,
			Integer status, String showimg, String description, Integer num,
			String publicaccount, Set<Whdcouponrecord> whdcouponrecords) {
		this.name = name;
		this.keyword = keyword;
		this.starttime = starttime;
		this.endtime = endtime;
		this.status = status;
		this.showimg = showimg;
		this.description = description;
		this.num = num;
		this.publicaccount = publicaccount;
		this.whdcouponrecords = whdcouponrecords;
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

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "showimg", length = 100)
	public String getShowimg() {
		return this.showimg;
	}

	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "whdcoupon")
	public Set<Whdcouponrecord> getWhdcouponrecords() {
		return this.whdcouponrecords;
	}

	public void setWhdcouponrecords(Set<Whdcouponrecord> whdcouponrecords) {
		this.whdcouponrecords = whdcouponrecords;
	}

}