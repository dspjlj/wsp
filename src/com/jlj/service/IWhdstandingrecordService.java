package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdstandingrecord;

public interface IWhdstandingrecordService {

	public abstract void add(Whdstandingrecord whdstandingrecord)
			throws Exception;

	public abstract void delete(Whdstandingrecord whdstandingrecord);

	public abstract void deleteById(int id);

	public abstract void update(Whdstandingrecord whdstandingrecord);

	public abstract List<Whdstandingrecord> getWhdstandingrecords();

	public abstract Whdstandingrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdstandingrecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdstandingrecord> getFrontWhdstandingrecordsByPublicAccount(
			String paccount);

}