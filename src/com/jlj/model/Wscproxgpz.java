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
 * Wscproxgpz entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscproxgpz", catalog = "wsp")
public class Wscproxgpz implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscproduct wscproduct;
	private String name;
	private Integer ison;
	private Integer orderid;
	private Set<Wscorderpro> wscorderpros = new HashSet<Wscorderpro>(0);

	// Constructors

	/** default constructor */
	public Wscproxgpz() {
	}

	/** full constructor */
	public Wscproxgpz(Wscproduct wscproduct, String name, Integer ison,
			Integer orderid, Set<Wscorderpro> wscorderpros) {
		this.wscproduct = wscproduct;
		this.name = name;
		this.ison = ison;
		this.orderid = orderid;
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
	@JoinColumn(name = "wscproductid")
	public Wscproduct getWscproduct() {
		return this.wscproduct;
	}

	public void setWscproduct(Wscproduct wscproduct) {
		this.wscproduct = wscproduct;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "orderid")
	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wscproxgpz")
	public Set<Wscorderpro> getWscorderpros() {
		return this.wscorderpros;
	}

	public void setWscorderpros(Set<Wscorderpro> wscorderpros) {
		this.wscorderpros = wscorderpros;
	}

}