package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscorder;

public interface IWscorderService {

	public abstract void add(Wscorder wscorder) throws Exception;

	public abstract void delete(Wscorder wscorder);

	public abstract void deleteById(int id);

	public abstract void update(Wscorder wscorder);

	public abstract List<Wscorder> getWscorders();

	public abstract Wscorder loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscorder> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscorder> getFrontWscordersByPublicAccount(
			String paccount);

}