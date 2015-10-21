package com.jlj.service;

import java.util.List;

import com.jlj.model.Wkf;

public interface IWkfService {

	public abstract void add(Wkf wkf) throws Exception;

	public abstract void delete(Wkf wkf);

	public abstract void deleteById(int id);

	public abstract void update(Wkf wkf);

	public abstract List<Wkf> getWkfs();

	public abstract Wkf loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wkf> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wkf> getFrontWkfsByPublicAccount(String paccount);

}