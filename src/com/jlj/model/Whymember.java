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
 * Whymember entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whymember", catalog = "wsp")
public class Whymember implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String keyword;
	private Date starttime;
	private Date endtime;
	private String infoimage;
	private String frontimage;
	private String namecolor;
	private String numbercolor;
	private String info;
	private String shuoming;
	private String notice;
	private String tequan;
	private String jfactivity;
	private Integer cardnumber;
	private String address;
	private String phone;
	private String location;
	private Integer evdaypoint;
	private Set<Wscpscenter> wscpscenters = new HashSet<Wscpscenter>(0);

	// Constructors

	/** default constructor */
	public Whymember() {
	}

	/** full constructor */
	public Whymember(String name, String keyword, Date starttime, Date endtime,
			String infoimage, String frontimage, String namecolor,
			String numbercolor, String info, String shuoming, String notice,
			String tequan, String jfactivity, Integer cardnumber,
			String address, String phone, String location, Integer evdaypoint,
			Set<Wscpscenter> wscpscenters) {
		this.name = name;
		this.keyword = keyword;
		this.starttime = starttime;
		this.endtime = endtime;
		this.infoimage = infoimage;
		this.frontimage = frontimage;
		this.namecolor = namecolor;
		this.numbercolor = numbercolor;
		this.info = info;
		this.shuoming = shuoming;
		this.notice = notice;
		this.tequan = tequan;
		this.jfactivity = jfactivity;
		this.cardnumber = cardnumber;
		this.address = address;
		this.phone = phone;
		this.location = location;
		this.evdaypoint = evdaypoint;
		this.wscpscenters = wscpscenters;
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

	@Column(name = "name", length = 60)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "keyword", length = 40)
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

	@Column(name = "infoimage", length = 100)
	public String getInfoimage() {
		return this.infoimage;
	}

	public void setInfoimage(String infoimage) {
		this.infoimage = infoimage;
	}

	@Column(name = "frontimage", length = 100)
	public String getFrontimage() {
		return this.frontimage;
	}

	public void setFrontimage(String frontimage) {
		this.frontimage = frontimage;
	}

	@Column(name = "namecolor", length = 10)
	public String getNamecolor() {
		return this.namecolor;
	}

	public void setNamecolor(String namecolor) {
		this.namecolor = namecolor;
	}

	@Column(name = "numbercolor", length = 10)
	public String getNumbercolor() {
		return this.numbercolor;
	}

	public void setNumbercolor(String numbercolor) {
		this.numbercolor = numbercolor;
	}

	@Column(name = "info", length = 40)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "shuoming", length = 65535)
	public String getShuoming() {
		return this.shuoming;
	}

	public void setShuoming(String shuoming) {
		this.shuoming = shuoming;
	}

	@Column(name = "notice", length = 65535)
	public String getNotice() {
		return this.notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	@Column(name = "tequan", length = 65535)
	public String getTequan() {
		return this.tequan;
	}

	public void setTequan(String tequan) {
		this.tequan = tequan;
	}

	@Column(name = "jfactivity", length = 65535)
	public String getJfactivity() {
		return this.jfactivity;
	}

	public void setJfactivity(String jfactivity) {
		this.jfactivity = jfactivity;
	}

	@Column(name = "cardnumber")
	public Integer getCardnumber() {
		return this.cardnumber;
	}

	public void setCardnumber(Integer cardnumber) {
		this.cardnumber = cardnumber;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "location", length = 50)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "evdaypoint")
	public Integer getEvdaypoint() {
		return this.evdaypoint;
	}

	public void setEvdaypoint(Integer evdaypoint) {
		this.evdaypoint = evdaypoint;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "whymember")
	public Set<Wscpscenter> getWscpscenters() {
		return this.wscpscenters;
	}

	public void setWscpscenters(Set<Wscpscenter> wscpscenters) {
		this.wscpscenters = wscpscenters;
	}

}