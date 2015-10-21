package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdgoldeneggrecord;

public interface IWhdgoldeneggrecordService {

	public abstract void add(Whdgoldeneggrecord whdgoldeneggrecord)
			throws Exception;

	public abstract void delete(Whdgoldeneggrecord whdgoldeneggrecord);

	public abstract void deleteById(int id);

	public abstract void update(Whdgoldeneggrecord whdgoldeneggrecord);

	public abstract List<Whdgoldeneggrecord> getWhdgoldeneggrecords();

	public abstract Whdgoldeneggrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdgoldeneggrecord> queryList(int con,
			String convalue, int status, String publicaccount, int page,
			int size);

	public abstract List<Whdgoldeneggrecord> getFrontWhdgoldeneggrecordsByPublicAccount(
			String paccount);

}