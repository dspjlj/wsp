package com.jlj.service;

import java.util.List;

import com.jlj.model.Wsc;

public interface IWscService {

	public abstract void add(Wsc wsc) throws Exception;

	public abstract void delete(Wsc wsc);

	public abstract void deleteById(int id);

	public abstract void update(Wsc wsc);

	public abstract List<Wsc> getWscs();

	public abstract Wsc loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wsc> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wsc> getFrontWscsByPublicAccount(String paccount);

}