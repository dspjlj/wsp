package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscprocollect;

public interface IWscprocollectService {

	public abstract void add(Wscprocollect wscprocollect) throws Exception;

	public abstract void delete(Wscprocollect wscprocollect);

	public abstract void deleteById(int id);

	public abstract void update(Wscprocollect wscprocollect);

	public abstract List<Wscprocollect> getWscprocollects();

	public abstract Wscprocollect loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscprocollect> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscprocollect> getFrontWscprocollectsByPublicAccount(
			String paccount);

}