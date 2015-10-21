package com.jlj.service;

import java.util.List;

import com.jlj.model.Wtprecord;

public interface IWtprecordService {

	public abstract void add(Wtprecord wtprecord) throws Exception;

	public abstract void delete(Wtprecord wtprecord);

	public abstract void deleteById(int id);

	public abstract void update(Wtprecord wtprecord);

	public abstract List<Wtprecord> getWtprecords();

	public abstract Wtprecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wtprecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wtprecord> getFrontWtprecordsByPublicAccount(
			String paccount);

}