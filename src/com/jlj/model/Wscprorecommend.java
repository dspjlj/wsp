package com.jlj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Wscprorecommend entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wscprorecommend", catalog = "wsp")
public class Wscprorecommend implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wscproduct wscproduct;
	private String recommends;

	// Constructors

	/** default constructor */
	public Wscprorecommend() {
	}

	/** full constructor */
	public Wscprorecommend(Wscproduct wscproduct, String recommends) {
		this.wscproduct = wscproduct;
		this.recommends = recommends;
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

	@Column(name = "recommends", length = 30)
	public String getRecommends() {
		return this.recommends;
	}

	public void setRecommends(String recommends) {
		this.recommends = recommends;
	}

}