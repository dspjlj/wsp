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
 * Whdtkjh entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "whdtkjh", catalog = "wsp")
public class Whdtkjh implements java.io.Serializable {

	// Fields

	private Integer id;
	private Whdtk whdtk;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private Integer rightanswer;

	// Constructors

	/** default constructor */
	public Whdtkjh() {
	}

	/** full constructor */
	public Whdtkjh(Whdtk whdtk, String question, String answer1,
			String answer2, String answer3, String answer4, Integer rightanswer) {
		this.whdtk = whdtk;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.rightanswer = rightanswer;
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
	@JoinColumn(name = "whdtkid")
	public Whdtk getWhdtk() {
		return this.whdtk;
	}

	public void setWhdtk(Whdtk whdtk) {
		this.whdtk = whdtk;
	}

	@Column(name = "question", length = 200)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "answer1", length = 40)
	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	@Column(name = "answer2", length = 40)
	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	@Column(name = "answer3", length = 40)
	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	@Column(name = "answer4", length = 40)
	public String getAnswer4() {
		return this.answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	@Column(name = "rightanswer")
	public Integer getRightanswer() {
		return this.rightanswer;
	}

	public void setRightanswer(Integer rightanswer) {
		this.rightanswer = rightanswer;
	}

}