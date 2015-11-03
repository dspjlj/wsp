package com.jlj.vo;

public class MenusonData {
	private String tit;
	private String typ;
	private String data;
	
	public MenusonData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenusonData(String tit, String typ, String data) {
		super();
		this.tit = tit;
		this.typ = typ;
		this.data = data;
	}

	public String getTit() {
		return tit;
	}

	public void setTit(String tit) {
		this.tit = tit;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "{"+this.tit+","+this.typ + ","+this.data+"}";
	}
	
}
