package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscproarg;

public interface IWscproargService {

	public abstract void add(Wscproarg wscproarg) throws Exception;

	public abstract void delete(Wscproarg wscproarg);

	public abstract void deleteById(int id);

	public abstract void update(Wscproarg wscproarg);

	public abstract List<Wscproarg> getWscproargs();

	public abstract Wscproarg loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscproarg> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscproarg> getFrontWscproargsByPublicAccount(
			String paccount);

}