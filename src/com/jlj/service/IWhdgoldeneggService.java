package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdgoldenegg;

public interface IWhdgoldeneggService {

	public abstract void add(Whdgoldenegg whdgoldenegg) throws Exception;

	public abstract void delete(Whdgoldenegg whdgoldenegg);

	public abstract void deleteById(int id);

	public abstract void update(Whdgoldenegg whdgoldenegg);

	public abstract List<Whdgoldenegg> getWhdgoldeneggs();

	public abstract Whdgoldenegg loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdgoldenegg> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdgoldenegg> getFrontWhdgoldeneggsByPublicAccount(
			String paccount);

}