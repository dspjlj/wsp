package com.jlj.model;

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

/**
 * Wscaddress entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscaddress", catalog = "wsp")
public class Wscaddress implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscpscenter wscpscenter;
	private String receiver;
	private String phone;
	private String province;
	private String city;
	private String detail;
	private Set<Wscorderpro> wscorderpros = new HashSet<Wscorderpro>(0);
	private Set<Wscorder> wscorders = new HashSet<Wscorder>(0);

	// Constructors

	/** default constructor */
	public Wscaddress() {
	}

	/** full constructor */
	public Wscaddress(Wscpscenter wscpscenter, String receiver, String phone,
			String province, String city, String detail,
			Set<Wscorderpro> wscorderpros, Set<Wscorder> wscorders) {
		this.wscpscenter = wscpscenter;
		this.receiver = receiver;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.detail = detail;
		this.wscorderpros = wscorderpros;
		this.wscorders = wscorders;
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
	@JoinColumn(name = "wscpscenterid")
	public Wscpscenter getWscpscenter() {
		return this.wscpscenter;
	}

	public void setWscpscenter(Wscpscenter wscpscenter) {
		this.wscpscenter = wscpscenter;
	}

	@Column(name = "receiver", length = 20)
	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "province", length = 20)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "detail", length = 100)
	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscaddress")
	public Set<Wscorderpro> getWscorderpros() {
		return this.wscorderpros;
	}

	public void setWscorderpros(Set<Wscorderpro> wscorderpros) {
		this.wscorderpros = wscorderpros;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscaddress")
	public Set<Wscorder> getWscorders() {
		return this.wscorders;
	}

	public void setWscorders(Set<Wscorder> wscorders) {
		this.wscorders = wscorders;
	}

}