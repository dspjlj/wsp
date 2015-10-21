package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscpscenter;

public interface IWscpscenterService {

	public abstract void add(Wscpscenter wscpscenter) throws Exception;

	public abstract void delete(Wscpscenter wscpscenter);

	public abstract void deleteById(int id);

	public abstract void update(Wscpscenter wscpscenter);

	public abstract List<Wscpscenter> getWscpscenters();

	public abstract Wscpscenter loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscpscenter> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscpscenter> getFrontWscpscentersByPublicAccount(
			String paccount);

}