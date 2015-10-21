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
 * Whdbigwheel entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdbigwheel", catalog = "wsp")
public class Whdbigwheel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyword;
	private Date starttime;
	private Date endtime;
	private Integer status;
	private String showimg;
	private String description;
	private String jpname1;
	private String jpcontent1;
	private Integer jpnum1;
	private Float jpgl1;
	private String jpname2;
	private String jpcontent2;
	private Integer jpnum2;
	private Float jpgl2;
	private String jpname3;
	private String jpcontent3;
	private Integer jpnum3;
	private Float jpgl3;
	private Integer isshownum;
	private Integer evpstimes;
	private Integer evpsdaytime;
	private Integer evdayjpnum;
	private String publicaccount;
	private Set<Whdbigwheelrecord> whdbigwheelrecords = new HashSet<Whdbigwheelrecord>(
			0);

	// Constructors

	/** default constructor */
	public Whdbigwheel() {
	}

	/** full constructor */
	public Whdbigwheel(String name, String keyword, Date starttime,
			Date endtime, Integer status, String showimg, String description,
			String jpname1, String jpcontent1, Integer jpnum1, Float jpgl1,
			String jpname2, String jpcontent2, Integer jpnum2, Float jpgl2,
			String jpname3, String jpcontent3, Integer jpnum3, Float jpgl3,
			Integer isshownum, Integer evpstimes, Integer evpsdaytime,
			Integer evdayjpnum, String publicaccount,
			Set<Whdbigwheelrecord> whdbigwheelrecords) {
		this.name = name;
		this.keyword = keyword;
		this.starttime = starttime;
		this.endtime = endtime;
		this.status = status;
		this.showimg = showimg;
		this.description = description;
		this.jpname1 = jpname1;
		this.jpcontent1 = jpcontent1;
		this.jpnum1 = jpnum1;
		this.jpgl1 = jpgl1;
		this.jpname2 = jpname2;
		this.jpcontent2 = jpcontent2;
		this.jpnum2 = jpnum2;
		this.jpgl2 = jpgl2;
		this.jpname3 = jpname3;
		this.jpcontent3 = jpcontent3;
		this.jpnum3 = jpnum3;
		this.jpgl3 = jpgl3;
		this.isshownum = isshownum;
		this.evpstimes = evpstimes;
		this.evpsdaytime = evpsdaytime;
		this.evdayjpnum = evdayjpnum;
		this.publicaccount = publicaccount;
		this.whdbigwheelrecords = whdbigwheelrecords;
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

	@Column(name = "keyword", length = 0)
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

	@Column(name = "jpname1", length = 20)
	public String getJpname1() {
		return this.jpname1;
	}

	public void setJpname1(String jpname1) {
		this.jpname1 = jpname1;
	}

	@Column(name = "jpcontent1", length = 100)
	public String getJpcontent1() {
		return this.jpcontent1;
	}

	public void setJpcontent1(String jpcontent1) {
		this.jpcontent1 = jpcontent1;
	}

	@Column(name = "jpnum1")
	public Integer getJpnum1() {
		return this.jpnum1;
	}

	public void setJpnum1(Integer jpnum1) {
		this.jpnum1 = jpnum1;
	}

	@Column(name = "jpgl1", precision = 12, scale = 0)
	public Float getJpgl1() {
		return this.jpgl1;
	}

	public void setJpgl1(Float jpgl1) {
		this.jpgl1 = jpgl1;
	}

	@Column(name = "jpname2", length = 20)
	public String getJpname2() {
		return this.jpname2;
	}

	public void setJpname2(String jpname2) {
		this.jpname2 = jpname2;
	}

	@Column(name = "jpcontent2", length = 100)
	public String getJpcontent2() {
		return this.jpcontent2;
	}

	public void setJpcontent2(String jpcontent2) {
		this.jpcontent2 = jpcontent2;
	}

	@Column(name = "jpnum2")
	public Integer getJpnum2() {
		return this.jpnum2;
	}

	public void setJpnum2(Integer jpnum2) {
		this.jpnum2 = jpnum2;
	}

	@Column(name = "jpgl2", precision = 12, scale = 0)
	public Float getJpgl2() {
		return this.jpgl2;
	}

	public void setJpgl2(Float jpgl2) {
		this.jpgl2 = jpgl2;
	}

	@Column(name = "jpname3", length = 20)
	public String getJpname3() {
		return this.jpname3;
	}

	public void setJpname3(String jpname3) {
		this.jpname3 = jpname3;
	}

	@Column(name = "jpcontent3", length = 100)
	public String getJpcontent3() {
		return this.jpcontent3;
	}

	public void setJpcontent3(String jpcontent3) {
		this.jpcontent3 = jpcontent3;
	}

	@Column(name = "jpnum3")
	public Integer getJpnum3() {
		return this.jpnum3;
	}

	public void setJpnum3(Integer jpnum3) {
		this.jpnum3 = jpnum3;
	}

	@Column(name = "jpgl3", precision = 12, scale = 0)
	public Float getJpgl3() {
		return this.jpgl3;
	}

	public void setJpgl3(Float jpgl3) {
		this.jpgl3 = jpgl3;
	}

	@Column(name = "isshownum")
	public Integer getIsshownum() {
		return this.isshownum;
	}

	public void setIsshownum(Integer isshownum) {
		this.isshownum = isshownum;
	}

	@Column(name = "evpstimes")
	public Integer getEvpstimes() {
		return this.evpstimes;
	}

	public void setEvpstimes(Integer evpstimes) {
		this.evpstimes = evpstimes;
	}

	@Column(name = "evpsdaytime")
	public Integer getEvpsdaytime() {
		return this.evpsdaytime;
	}

	public void setEvpsdaytime(Integer evpsdaytime) {
		this.evpsdaytime = evpsdaytime;
	}

	@Column(name = "evdayjpnum")
	public Integer getEvdayjpnum() {
		return this.evdayjpnum;
	}

	public void setEvdayjpnum(Integer evdayjpnum) {
		this.evdayjpnum = evdayjpnum;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "whdbigwheel")
	public Set<Whdbigwheelrecord> getWhdbigwheelrecords() {
		return this.whdbigwheelrecords;
	}

	public void setWhdbigwheelrecords(Set<Whdbigwheelrecord> whdbigwheelrecords) {
		this.whdbigwheelrecords = whdbigwheelrecords;
	}

}