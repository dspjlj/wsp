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
 * Wdy entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wdy", catalog = "wsp")
public class Wdy implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyword;
	private Date starttime;
	private Date endtime;
	private String showimg;
	private String info;
	private Integer status;
	private Set<Wdytk> wdytks = new HashSet<Wdytk>(0);

	// Constructors

	/** default constructor */
	public Wdy() {
	}

	/** full constructor */
	public Wdy(String name, String keyword, Date starttime, Date endtime,
			String showimg, String info, Integer status, Set<Wdytk> wdytks) {
		this.name = name;
		this.keyword = keyword;
		this.starttime = starttime;
		this.endtime = endtime;
		this.showimg = showimg;
		this.info = info;
		this.status = status;
		this.wdytks = wdytks;
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

	@Column(name = "showimg", length = 100)
	public String getShowimg() {
		return this.showimg;
	}

	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}

	@Column(name = "info", length = 65535)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wdy")
	public Set<Wdytk> getWdytks() {
		return this.wdytks;
	}

	public void setWdytks(Set<Wdytk> wdytks) {
		this.wdytks = wdytks;
	}

}