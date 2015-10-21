package com.jlj.service;

import java.util.List;

import com.jlj.model.Wtgrecord;

public interface IWtgrecordService {

	public abstract void add(Wtgrecord wtgrecord) throws Exception;

	public abstract void delete(Wtgrecord wtgrecord);

	public abstract void deleteById(int id);

	public abstract void update(Wtgrecord wtgrecord);

	public abstract List<Wtgrecord> getWtgrecords();

	public abstract Wtgrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wtgrecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wtgrecord> getFrontWtgrecordsByPublicAccount(
			String paccount);

}