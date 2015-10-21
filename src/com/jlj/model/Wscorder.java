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
 * Wscorder entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscorder", catalog = "wsp")
public class Wscorder implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscaddress wscaddress;
	private String ordernumber;
	private Date ordertime;
	private Date sendtime;
	private String username;
	private String phone;
	private Float promoney;
	private Float carrymoney;
	private String discounttype;
	private Float discountmoney;
	private String paytype;
	private Float allmoney;
	private Integer status;
	private String logisticscomp;
	private String logisticsnumber;
	private Set<Wscorderpro> wscorderpros = new HashSet<Wscorderpro>(0);

	// Constructors

	/** default constructor */
	public Wscorder() {
	}

	/** full constructor */
	public Wscorder(Wscaddress wscaddress, String ordernumber, Date ordertime,
			Date sendtime, String username, String phone, Float promoney,
			Float carrymoney, String discounttype, Float discountmoney,
			String paytype, Float allmoney, Integer status,
			String logisticscomp, String logisticsnumber,
			Set<Wscorderpro> wscorderpros) {
		this.wscaddress = wscaddress;
		this.ordernumber = ordernumber;
		this.ordertime = ordertime;
		this.sendtime = sendtime;
		this.username = username;
		this.phone = phone;
		this.promoney = promoney;
		this.carrymoney = carrymoney;
		this.discounttype = discounttype;
		this.discountmoney = discountmoney;
		this.paytype = paytype;
		this.allmoney = allmoney;
		this.status = status;
		this.logisticscomp = logisticscomp;
		this.logisticsnumber = logisticsnumber;
		this.wscorderpros = wscorderpros;
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
	@JoinColumn(name = "wscaddressid")
	public Wscaddress getWscaddress() {
		return this.wscaddress;
	}

	public void setWscaddress(Wscaddress wscaddress) {
		this.wscaddress = wscaddress;
	}

	@Column(name = "ordernumber", length = 20)
	public String getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ordertime", length = 19)
	public Date getOrdertime() {
		return this.ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "sendtime", length = 19)
	public Date getSendtime() {
		return this.sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	@Column(name = "username", length = 30)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "promoney", precision = 12, scale = 0)
	public Float getPromoney() {
		return this.promoney;
	}

	public void setPromoney(Float promoney) {
		this.promoney = promoney;
	}

	@Column(name = "carrymoney", precision = 12, scale = 0)
	public Float getCarrymoney() {
		return this.carrymoney;
	}

	public void setCarrymoney(Float carrymoney) {
		this.carrymoney = carrymoney;
	}

	@Column(name = "discounttype", length = 30)
	public String getDiscounttype() {
		return this.discounttype;
	}

	public void setDiscounttype(String discounttype) {
		this.discounttype = discounttype;
	}

	@Column(name = "discountmoney", precision = 12, scale = 0)
	public Float getDiscountmoney() {
		return this.discountmoney;
	}

	public void setDiscountmoney(Float discountmoney) {
		this.discountmoney = discountmoney;
	}

	@Column(name = "paytype", length = 30)
	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	@Column(name = "allmoney", precision = 12, scale = 0)
	public Float getAllmoney() {
		return this.allmoney;
	}

	public void setAllmoney(Float allmoney) {
		this.allmoney = allmoney;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "logisticscomp", length = 50)
	public String getLogisticscomp() {
		return this.logisticscomp;
	}

	public void setLogisticscomp(String logisticscomp) {
		this.logisticscomp = logisticscomp;
	}

	@Column(name = "logisticsnumber", length = 20)
	public String getLogisticsnumber() {
		return this.logisticsnumber;
	}

	public void setLogisticsnumber(String logisticsnumber) {
		this.logisticsnumber = logisticsnumber;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscorder")
	public Set<Wscorderpro> getWscorderpros() {
		return this.wscorderpros;
	}

	public void setWscorderpros(Set<Wscorderpro> wscorderpros) {
		this.wscorderpros = wscorderpros;
	}

}