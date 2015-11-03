package com.jlj.vo;

import java.util.HashMap;
import java.util.Map;

public class MenuVo {
	private String typ;
	private String data;
	private String tit;
	private Map<String,MenusonData> subdata=new HashMap<String, MenusonData>();
	
	public MenuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuVo(String typ, String data, String tit,
			Map<String,MenusonData> subdata) {
		super();
		this.typ = typ;
		this.data = data;
		this.tit = tit;
		this.subdata = subdata;
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
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public Map<String,MenusonData> getSubdata() {
		return subdata;
	}
	public void setSubdata(Map<String,MenusonData> subdata) {
		this.subdata = subdata;
	}
	
}
