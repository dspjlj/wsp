package com.jlj.service;

import java.util.List;

import com.jlj.model.Wyy;

public interface IWyyService {

	public abstract void add(Wyy wyy) throws Exception;

	public abstract void delete(Wyy wyy);

	public abstract void deleteById(int id);

	public abstract void update(Wyy wyy);

	public abstract List<Wyy> getWyys();

	public abstract Wyy loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wyy> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wyy> getFrontWyysByPublicAccount(String paccount);

}