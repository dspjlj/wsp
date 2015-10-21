package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Lbs entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "lbs", catalog = "wsp")
public class Lbs implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String province;
	private String city;
	private String area;
	private String bigtype;
	private String sontype;
	private String address;
	private String xyloaction;
	private String phone;
	private String showimg;
	private String info;
	private String publcaccount;

	// Constructors

	/** default constructor */
	public Lbs() {
	}

	/** full constructor */
	public Lbs(String name, String province, String city, String area,
			String bigtype, String sontype, String address, String xyloaction,
			String phone, String showimg, String info, String publcaccount) {
		this.name = name;
		this.province = province;
		this.city = city;
		this.area = area;
		this.bigtype = bigtype;
		this.sontype = sontype;
		this.address = address;
		this.xyloaction = xyloaction;
		this.phone = phone;
		this.showimg = showimg;
		this.info = info;
		this.publcaccount = publcaccount;
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

	@Column(name = "province", length = 40)
	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "city", length = 40)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "area", length = 40)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "bigtype", length = 40)
	public String getBigtype() {
		return this.bigtype;
	}

	public void setBigtype(String bigtype) {
		this.bigtype = bigtype;
	}

	@Column(name = "sontype", length = 40)
	public String getSontype() {
		return this.sontype;
	}

	public void setSontype(String sontype) {
		this.sontype = sontype;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "xyloaction", length = 40)
	public String getXyloaction() {
		return this.xyloaction;
	}

	public void setXyloaction(String xyloaction) {
		this.xyloaction = xyloaction;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "showimg", length = 100)
	public String getShowimg() {
		return this.showimg;
	}

	public void setShowimg(String showimg) {
		this.showimg = showimg;
	}

	@Column(name = "info", length = 200)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "publcaccount", length = 30)
	public String getPublcaccount() {
		return this.publcaccount;
	}

	public void setPublcaccount(String publcaccount) {
		this.publcaccount = publcaccount;
	}

}