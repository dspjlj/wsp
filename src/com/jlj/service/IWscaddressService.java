package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscaddress;

public interface IWscaddressService {

	public abstract void add(Wscaddress wscaddress) throws Exception;

	public abstract void delete(Wscaddress wscaddress);

	public abstract void deleteById(int id);

	public abstract void update(Wscaddress wscaddress);

	public abstract List<Wscaddress> getWscaddresss();

	public abstract Wscaddress loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscaddress> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wscaddress> getFrontWscaddresssByPublicAccount(String paccount);

}