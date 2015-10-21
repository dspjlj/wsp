package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscprodiscount;

public interface IWscprodiscountService {

	public abstract void add(Wscprodiscount wscprodiscount) throws Exception;

	public abstract void delete(Wscprodiscount wscprodiscount);

	public abstract void deleteById(int id);

	public abstract void update(Wscprodiscount wscprodiscount);

	public abstract List<Wscprodiscount> getWscprodiscounts();

	public abstract Wscprodiscount loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscprodiscount> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscprodiscount> getFrontWscprodiscountsByPublicAccount(
			String paccount);

}