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
 * Wdytk entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wdytk", catalog = "wsp")
public class Wdytk implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wdy wdy;
	private String question;
	private String xx1;
	private String xx2;
	private String xx3;
	private String xx4;
	private String xx5;
	private String xx6;
	private String xx7;
	private String xx8;
	private String xx9;
	private String xx10;
	private Integer tktype;
	private Set<Wdyrecord> wdyrecords = new HashSet<Wdyrecord>(0);

	// Constructors

	/** default constructor */
	public Wdytk() {
	}

	/** full constructor */
	public Wdytk(Wdy wdy, String question, String xx1, String xx2, String xx3,
			String xx4, String xx5, String xx6, String xx7, String xx8,
			String xx9, String xx10, Integer tktype, Set<Wdyrecord> wdyrecords) {
		this.wdy = wdy;
		this.question = question;
		this.xx1 = xx1;
		this.xx2 = xx2;
		this.xx3 = xx3;
		this.xx4 = xx4;
		this.xx5 = xx5;
		this.xx6 = xx6;
		this.xx7 = xx7;
		this.xx8 = xx8;
		this.xx9 = xx9;
		this.xx10 = xx10;
		this.tktype = tktype;
		this.wdyrecords = wdyrecords;
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
	@JoinColumn(name = "wdyid")
	public Wdy getWdy() {
		return this.wdy;
	}

	public void setWdy(Wdy wdy) {
		this.wdy = wdy;
	}

	@Column(name = "question", length = 65535)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "xx1", length = 20)
	public String getXx1() {
		return this.xx1;
	}

	public void setXx1(String xx1) {
		this.xx1 = xx1;
	}

	@Column(name = "xx2", length = 20)
	public String getXx2() {
		return this.xx2;
	}

	public void setXx2(String xx2) {
		this.xx2 = xx2;
	}

	@Column(name = "xx3", length = 20)
	public String getXx3() {
		return this.xx3;
	}

	public void setXx3(String xx3) {
		this.xx3 = xx3;
	}

	@Column(name = "xx4", length = 20)
	public String getXx4() {
		return this.xx4;
	}

	public void setXx4(String xx4) {
		this.xx4 = xx4;
	}

	@Column(name = "xx5", length = 20)
	public String getXx5() {
		return this.xx5;
	}

	public void setXx5(String xx5) {
		this.xx5 = xx5;
	}

	@Column(name = "xx6", length = 20)
	public String getXx6() {
		return this.xx6;
	}

	public void setXx6(String xx6) {
		this.xx6 = xx6;
	}

	@Column(name = "xx7", length = 20)
	public String getXx7() {
		return this.xx7;
	}

	public void setXx7(String xx7) {
		this.xx7 = xx7;
	}

	@Column(name = "xx8", length = 20)
	public String getXx8() {
		return this.xx8;
	}

	public void setXx8(String xx8) {
		this.xx8 = xx8;
	}

	@Column(name = "xx9", length = 20)
	public String getXx9() {
		return this.xx9;
	}

	public void setXx9(String xx9) {
		this.xx9 = xx9;
	}

	@Column(name = "xx10", length = 20)
	public String getXx10() {
		return this.xx10;
	}

	public void setXx10(String xx10) {
		this.xx10 = xx10;
	}

	@Column(name = "tktype")
	public Integer getTktype() {
		return this.tktype;
	}

	public void setTktype(Integer tktype) {
		this.tktype = tktype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wdytk")
	public Set<Wdyrecord> getWdyrecords() {
		return this.wdyrecords;
	}

	public void setWdyrecords(Set<Wdyrecord> wdyrecords) {
		this.wdyrecords = wdyrecords;
	}

}