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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wscpscenter entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscpscenter", catalog = "wsp")
public class Wscpscenter implements java.io.Serializable {

	// Fields

	private Integer id;
	private Whymember whymember;
	private Wsc wsc;
	private String phone;
	private String password;
	private Integer sypoint;
	private Float xfmoney;
	private Float symoney;
	private String username;
	private Date birthday;
	private String email;
	private String publicaccount;
	private Set<Wscaddress> wscaddresses = new HashSet<Wscaddress>(0);
	private Set<Whdscratchcardrecord> whdscratchcardrecords = new HashSet<Whdscratchcardrecord>(
			0);
	private Set<Whdstandingrecord> whdstandingrecords = new HashSet<Whdstandingrecord>(
			0);
	private Set<Wscprodiscount> wscprodiscounts = new HashSet<Wscprodiscount>(0);
	private Set<Wscprocollect> wscprocollects = new HashSet<Wscprocollect>(0);
	private Set<Whdgoldeneggrecord> whdgoldeneggrecords = new HashSet<Whdgoldeneggrecord>(
			0);
	private Set<Wdyrecord> wdyrecords = new HashSet<Wdyrecord>(0);
	private Set<Wtgrecord> wtgrecords = new HashSet<Wtgrecord>(0);
	private Set<Wtprecord> wtprecords = new HashSet<Wtprecord>(0);
	private Set<Whdcouponrecord> whdcouponrecords = new HashSet<Whdcouponrecord>(
			0);
	private Set<Whdbigwheelrecord> whdbigwheelrecords = new HashSet<Whdbigwheelrecord>(
			0);
	private Set<Whdluckyrecord> whdluckyrecords = new HashSet<Whdluckyrecord>(0);

	// Constructors

	/** default constructor */
	public Wscpscenter() {
	}

	/** full constructor */
	public Wscpscenter(Whymember whymember, Wsc wsc, String phone,
			String password, Integer sypoint, Float xfmoney, Float symoney,
			String username, Date birthday, String email, String publicaccount,
			Set<Wscaddress> wscaddresses,
			Set<Whdscratchcardrecord> whdscratchcardrecords,
			Set<Whdstandingrecord> whdstandingrecords,
			Set<Wscprodiscount> wscprodiscounts,
			Set<Wscprocollect> wscprocollects,
			Set<Whdgoldeneggrecord> whdgoldeneggrecords,
			Set<Wdyrecord> wdyrecords, Set<Wtgrecord> wtgrecords,
			Set<Wtprecord> wtprecords, Set<Whdcouponrecord> whdcouponrecords,
			Set<Whdbigwheelrecord> whdbigwheelrecords,
			Set<Whdluckyrecord> whdluckyrecords) {
		this.whymember = whymember;
		this.wsc = wsc;
		this.phone = phone;
		this.password = password;
		this.sypoint = sypoint;
		this.xfmoney = xfmoney;
		this.symoney = symoney;
		this.username = username;
		this.birthday = birthday;
		this.email = email;
		this.publicaccount = publicaccount;
		this.wscaddresses = wscaddresses;
		this.whdscratchcardrecords = whdscratchcardrecords;
		this.whdstandingrecords = whdstandingrecords;
		this.wscprodiscounts = wscprodiscounts;
		this.wscprocollects = wscprocollects;
		this.whdgoldeneggrecords = whdgoldeneggrecords;
		this.wdyrecords = wdyrecords;
		this.wtgrecords = wtgrecords;
		this.wtprecords = wtprecords;
		this.whdcouponrecords = whdcouponrecords;
		this.whdbigwheelrecords = whdbigwheelrecords;
		this.whdluckyrecords = whdluckyrecords;
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
	@JoinColumn(name = "whymemberid")
	public Whymember getWhymember() {
		return this.whymember;
	}

	public void setWhymember(Whymember whymember) {
		this.whymember = whymember;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wscid")
	public Wsc getWsc() {
		return this.wsc;
	}

	public void setWsc(Wsc wsc) {
		this.wsc = wsc;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "sypoint")
	public Integer getSypoint() {
		return this.sypoint;
	}

	public void setSypoint(Integer sypoint) {
		this.sypoint = sypoint;
	}

	@Column(name = "xfmoney", precision = 12, scale = 0)
	public Float getXfmoney() {
		return this.xfmoney;
	}

	public void setXfmoney(Float xfmoney) {
		this.xfmoney = xfmoney;
	}

	@Column(name = "symoney", precision = 12, scale = 0)
	public Float getSymoney() {
		return this.symoney;
	}

	public void setSymoney(Float symoney) {
		this.symoney = symoney;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "email", length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Wscaddress> getWscaddresses() {
		return this.wscaddresses;
	}

	public void setWscaddresses(Set<Wscaddress> wscaddresses) {
		this.wscaddresses = wscaddresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Whdscratchcardrecord> getWhdscratchcardrecords() {
		return this.whdscratchcardrecords;
	}

	public void setWhdscratchcardrecords(
			Set<Whdscratchcardrecord> whdscratchcardrecords) {
		this.whdscratchcardrecords = whdscratchcardrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Whdstandingrecord> getWhdstandingrecords() {
		return this.whdstandingrecords;
	}

	public void setWhdstandingrecords(Set<Whdstandingrecord> whdstandingrecords) {
		this.whdstandingrecords = whdstandingrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Wscprodiscount> getWscprodiscounts() {
		return this.wscprodiscounts;
	}

	public void setWscprodiscounts(Set<Wscprodiscount> wscprodiscounts) {
		this.wscprodiscounts = wscprodiscounts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Wscprocollect> getWscprocollects() {
		return this.wscprocollects;
	}

	public void setWscprocollects(Set<Wscprocollect> wscprocollects) {
		this.wscprocollects = wscprocollects;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Whdgoldeneggrecord> getWhdgoldeneggrecords() {
		return this.whdgoldeneggrecords;
	}

	public void setWhdgoldeneggrecords(
			Set<Whdgoldeneggrecord> whdgoldeneggrecords) {
		this.whdgoldeneggrecords = whdgoldeneggrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Wdyrecord> getWdyrecords() {
		return this.wdyrecords;
	}

	public void setWdyrecords(Set<Wdyrecord> wdyrecords) {
		this.wdyrecords = wdyrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Wtgrecord> getWtgrecords() {
		return this.wtgrecords;
	}

	public void setWtgrecords(Set<Wtgrecord> wtgrecords) {
		this.wtgrecords = wtgrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Wtprecord> getWtprecords() {
		return this.wtprecords;
	}

	public void setWtprecords(Set<Wtprecord> wtprecords) {
		this.wtprecords = wtprecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Whdcouponrecord> getWhdcouponrecords() {
		return this.whdcouponrecords;
	}

	public void setWhdcouponrecords(Set<Whdcouponrecord> whdcouponrecords) {
		this.whdcouponrecords = whdcouponrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Whdbigwheelrecord> getWhdbigwheelrecords() {
		return this.whdbigwheelrecords;
	}

	public void setWhdbigwheelrecords(Set<Whdbigwheelrecord> whdbigwheelrecords) {
		this.whdbigwheelrecords = whdbigwheelrecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscpscenter")
	public Set<Whdluckyrecord> getWhdluckyrecords() {
		return this.whdluckyrecords;
	}

	public void setWhdluckyrecords(Set<Whdluckyrecord> whdluckyrecords) {
		this.whdluckyrecords = whdluckyrecords;
	}

}