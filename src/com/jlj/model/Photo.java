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
 * Photo entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "photo", catalog = "wsp")
public class Photo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Album album;
	private String photoimg;
	private String title;
	private String description;

	// Constructors

	/** default constructor */
	public Photo() {
	}

	/** full constructor */
	public Photo(Album album, String photoimg, String title, String description) {
		this.album = album;
		this.photoimg = photoimg;
		this.title = title;
		this.description = description;
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
	@JoinColumn(name = "albumid")
	public Album getAlbum() {
		return this.album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Column(name = "photoimg", length = 100)
	public String getPhotoimg() {
		return this.photoimg;
	}

	public void setPhotoimg(String photoimg) {
		this.photoimg = photoimg;
	}

	@Column(name = "title", length = 40)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}