package com.jlj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jlj.vo.ScreenimgVo;

/**
 * Screenimg entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "screenimg", catalog = "wsp")
public class Screenimg implements java.io.Serializable {

	// Fields

	private Integer id;
	private Wgw wgw;
	private Integer imginterval;
	private String bgimg;
	private String imageurl1;
	private String imageurl3;
	private String imageurl2;
	private String imageurl5;
	private String linkurl3;
	private String linkurl1;
	private String imageurl4;
	private String linkurl4;
	private String linkurl5;
	private String linkurl2;
	private Integer ison;
	private String publicaccount;

	private List<ScreenimgVo> screenimgvos = new ArrayList<ScreenimgVo>();
	// Constructors

	/** default constructor */
	public Screenimg() {
	}

	/** full constructor */
	public Screenimg(Wgw wgw, Integer imginterval, String bgimg,String imageurl1,
			String imageurl3, String imageurl2, String imageurl5,
			String linkurl3, String linkurl1, String imageurl4,
			String linkurl4, String linkurl5, String linkurl2, Integer ison,
			String publicaccount) {
		this.wgw = wgw;
		this.imginterval = imginterval;
		this.bgimg = bgimg;
		this.imageurl1 = imageurl1;
		this.imageurl3 = imageurl3;
		this.imageurl2 = imageurl2;
		this.imageurl5 = imageurl5;
		this.linkurl3 = linkurl3;
		this.linkurl1 = linkurl1;
		this.imageurl4 = imageurl4;
		this.linkurl4 = linkurl4;
		this.linkurl5 = linkurl5;
		this.linkurl2 = linkurl2;
		this.ison = ison;
		this.publicaccount = publicaccount;
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
	@JoinColumn(name = "wgwid")
	public Wgw getWgw() {
		return this.wgw;
	}

	public void setWgw(Wgw wgw) {
		this.wgw = wgw;
	}

	@Column(name = "imginterval")
	public Integer getImginterval() {
		return this.imginterval;
	}

	public void setImginterval(Integer imginterval) {
		this.imginterval = imginterval;
	}

	@Column(name = "imageurl1", length = 100)
	public String getImageurl1() {
		return this.imageurl1;
	}

	public void setImageurl1(String imageurl1) {
		this.imageurl1 = imageurl1;
	}

	@Column(name = "imageurl3", length = 100)
	public String getImageurl3() {
		return this.imageurl3;
	}

	public void setImageurl3(String imageurl3) {
		this.imageurl3 = imageurl3;
	}

	@Column(name = "imageurl2", length = 100)
	public String getImageurl2() {
		return this.imageurl2;
	}

	public void setImageurl2(String imageurl2) {
		this.imageurl2 = imageurl2;
	}

	@Column(name = "imageurl5", length = 100)
	public String getImageurl5() {
		return this.imageurl5;
	}

	public void setImageurl5(String imageurl5) {
		this.imageurl5 = imageurl5;
	}

	@Column(name = "linkurl3", length = 100)
	public String getLinkurl3() {
		return this.linkurl3;
	}

	public void setLinkurl3(String linkurl3) {
		this.linkurl3 = linkurl3;
	}

	@Column(name = "linkurl1", length = 100)
	public String getLinkurl1() {
		return this.linkurl1;
	}

	public void setLinkurl1(String linkurl1) {
		this.linkurl1 = linkurl1;
	}

	@Column(name = "imageurl4", length = 100)
	public String getImageurl4() {
		return this.imageurl4;
	}

	public void setImageurl4(String imageurl4) {
		this.imageurl4 = imageurl4;
	}

	@Column(name = "linkurl4", length = 100)
	public String getLinkurl4() {
		return this.linkurl4;
	}

	public void setLinkurl4(String linkurl4) {
		this.linkurl4 = linkurl4;
	}

	@Column(name = "linkurl5", length = 100)
	public String getLinkurl5() {
		return this.linkurl5;
	}

	public void setLinkurl5(String linkurl5) {
		this.linkurl5 = linkurl5;
	}

	@Column(name = "linkurl2", length = 100)
	public String getLinkurl2() {
		return this.linkurl2;
	}

	public void setLinkurl2(String linkurl2) {
		this.linkurl2 = linkurl2;
	}

	@Column(name = "ison")
	public Integer getIson() {
		return this.ison;
	}

	public void setIson(Integer ison) {
		this.ison = ison;
	}

	@Column(name = "publicaccount", length = 30)
	public String getPublicaccount() {
		return this.publicaccount;
	}

	public void setPublicaccount(String publicaccount) {
		this.publicaccount = publicaccount;
	}

	@Column(name = "bgimg", length = 100)
	public String getBgimg() {
		return bgimg;
	}

	public void setBgimg(String bgimg) {
		this.bgimg = bgimg;
	}

	@Transient
	public List<ScreenimgVo> getScreenimgvos() {
		return screenimgvos;
	}

	public void setScreenimgvos(List<ScreenimgVo> screenimgvos) {
		this.screenimgvos = screenimgvos;
	}

	
}