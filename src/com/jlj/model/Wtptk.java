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
 * Wtptk entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wtptk", catalog = "wsp")
public class Wtptk implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wtp wtp;
	private String name;
	private String imageurl;
	private Set<Wtprecord> wtprecords = new HashSet<Wtprecord>(0);

	// Constructors

	/** default constructor */
	public Wtptk() {
	}

	/** full constructor */
	public Wtptk(Wtp wtp, String name, String imageurl,
			Set<Wtprecord> wtprecords) {
		this.wtp = wtp;
		this.name = name;
		this.imageurl = imageurl;
		this.wtprecords = wtprecords;
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
	@JoinColumn(name = "wtpid")
	public Wtp getWtp() {
		return this.wtp;
	}

	public void setWtp(Wtp wtp) {
		this.wtp = wtp;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "imageurl", length = 100)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wtptk")
	public Set<Wtprecord> getWtprecords() {
		return this.wtprecords;
	}

	public void setWtprecords(Set<Wtprecord> wtprecords) {
		this.wtprecords = wtprecords;
	}

}