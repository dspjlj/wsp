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
 * Dspuser entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "dspuser", catalog = "wsp")
public class Dspuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String address;
	private String realname;
	private String phone;
	private String email;
	private String qq;
	private Integer limits;
	private Date regdate;
	private Integer ison;
	private Integer usernum;
	private Integer pubnum;
	private Integer upuser;
	private Set<Pubclient> pubclients = new HashSet<Pubclient>(0);

	// Constructors

	/** default constructor */
	public Dspuser() {
	}

	/** full constructor */
	public Dspuser(String username, String password, String address,
			String realname, String phone, String email, String qq,
			Integer limits, Date regdate, Integer ison, Integer usernum,
			Integer pubnum, Integer upuser, Set<Pubclient> pubclients) {
		this.username = username;
		this.password = password;
		this.address = address;
		this.realname = realname;
		this.phone = phone;
		this.email = email;
		this.qq = qq;
		this.limits = limits;
		this.regdate = regdate;
		this.ison = ison;
		this.usernum = usernum;
		this.pubnum = pubnum;
		this.upuser = upuser;
		this.pubclients = pubclients;
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

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "realname", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "limits")
	public Integer getLimits() {
		return this.limits;
	}

	public void setLimits(Integer limits) {
		this.limits = limits;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "regdate", length = 10)
	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "usernum")
	public Integer getUsernum() {
		return this.usernum;
	}

	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}

	@Column(name = "pubnum")
	public Integer getPubnum() {
		return this.pubnum;
	}

	public void setPubnum(Integer pubnum) {
		this.pubnum = pubnum;
	}

	@Column(name = "upuser")
	public Integer getUpuser() {
		return this.upuser;
	}

	public void setUpuser(Integer upuser) {
		this.upuser = upuser;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dspuser")
	public Set<Pubclient> getPubclients() {
		return this.pubclients;
	}

	public void setPubclients(Set<Pubclient> pubclients) {
		this.pubclients = pubclients;
	}

}