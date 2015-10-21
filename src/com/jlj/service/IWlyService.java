package com.jlj.service;

import java.util.List;

import com.jlj.model.Wly;

public interface IWlyService {

	public abstract void add(Wly wly) throws Exception;

	public abstract void delete(Wly wly);

	public abstract void deleteById(int id);

	public abstract void update(Wly wly);

	public abstract List<Wly> getWlys();

	public abstract Wly loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wly> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wly> getFrontWlysByPublicAccount(String paccount);

}