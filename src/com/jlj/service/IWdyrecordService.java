package com.jlj.service;

import java.util.List;

import com.jlj.model.Wdyrecord;

public interface IWdyrecordService {

	public abstract void add(Wdyrecord wdyrecord) throws Exception;

	public abstract void delete(Wdyrecord wdyrecord);

	public abstract void deleteById(int id);

	public abstract void update(Wdyrecord wdyrecord);

	public abstract List<Wdyrecord> getWdyrecords();

	public abstract Wdyrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wdyrecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wdyrecord> getFrontWdyrecordsByPublicAccount(
			String paccount);

}