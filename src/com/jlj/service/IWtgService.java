package com.jlj.service;

import java.util.List;

import com.jlj.model.Wtg;

public interface IWtgService {

	public abstract void add(Wtg wtg) throws Exception;

	public abstract void delete(Wtg wtg);

	public abstract void deleteById(int id);

	public abstract void update(Wtg wtg);

	public abstract List<Wtg> getWtgs();

	public abstract Wtg loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wtg> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wtg> getFrontWtgsByPublicAccount(String paccount);

}