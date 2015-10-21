package com.jlj.service;

import java.util.List;

import com.jlj.model.Wxc;

public interface IWxcService {

	public abstract void add(Wxc wxc) throws Exception;

	public abstract void delete(Wxc wxc);

	public abstract void deleteById(int id);

	public abstract void update(Wxc wxc);

	public abstract List<Wxc> getWxcs();

	public abstract Wxc loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wxc> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wxc> getFrontWxcsByPublicAccount(String paccount);

}