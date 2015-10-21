package com.jlj.model;

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

/**
 * Whdtk entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdtk", catalog = "wsp")
public class Whdtk implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer num;
	private String publicaccount;
	private Set<Whdstanding> whdstandings = new HashSet<Whdstanding>(0);
	private Set<Whdtkjh> whdtkjhs = new HashSet<Whdtkjh>(0);

	// Constructors

	/** default constructor */
	public Whdtk() {
	}

	/** full constructor */
	public Whdtk(String name, Integer num, String publicaccount,
			Set<Whdstanding> whdstandings, Set<Whdtkjh> whdtkjhs) {
		this.name = name;
		this.num = num;
		this.publicaccount = publicaccount;
		this.whdstandings = whdstandings;
		this.whdtkjhs = whdtkjhs;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "whdtk")
	public Set<Whdstanding> getWhdstandings() {
		return this.whdstandings;
	}

	public void setWhdstandings(Set<Whdstanding> whdstandings) {
		this.whdstandings = whdstandings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "whdtk")
	public Set<Whdtkjh> getWhdtkjhs() {
		return this.whdtkjhs;
	}

	public void setWhdtkjhs(Set<Whdtkjh> whdtkjhs) {
		this.whdtkjhs = whdtkjhs;
	}

}