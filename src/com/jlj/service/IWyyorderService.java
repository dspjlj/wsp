package com.jlj.service;

import java.util.List;

import com.jlj.model.Wyyorder;

public interface IWyyorderService {

	public abstract void add(Wyyorder wyyorder) throws Exception;

	public abstract void delete(Wyyorder wyyorder);

	public abstract void deleteById(int id);

	public abstract void update(Wyyorder wyyorder);

	public abstract List<Wyyorder> getWyyorders();

	public abstract Wyyorder loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wyyorder> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wyyorder> getFrontWyyordersByPublicAccount(
			String paccount);

}