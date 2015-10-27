package com.jlj.vo;

public class NewVo {
	private Integer id;
	private String tit;
	private String pic;
	private String con;
	private String url;
	
	
	public NewVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewVo(Integer id,String tit, String pic, String con, String url) {
		super();
		this.id = id;
		this.tit = tit;
		this.pic = pic;
		this.con = con;
		this.url = url;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
