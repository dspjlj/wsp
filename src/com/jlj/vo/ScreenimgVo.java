package com.jlj.vo;

public class ScreenimgVo {
	private String imageurl;
	private String linkurl;
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getLinkurl() {
		return linkurl;
	}
	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}
	public ScreenimgVo() {
		super();
	}
	public ScreenimgVo(String imageurl, String linkurl) {
		super();
		this.imageurl = imageurl;
		this.linkurl = linkurl;
	}
	
}
