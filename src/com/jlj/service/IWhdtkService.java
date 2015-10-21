package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdtk;

public interface IWhdtkService {

	public abstract void add(Whdtk whdtk) throws Exception;

	public abstract void delete(Whdtk whdtk);

	public abstract void deleteById(int id);

	public abstract void update(Whdtk whdtk);

	public abstract List<Whdtk> getWhdtks();

	public abstract Whdtk loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdtk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Whdtk> getFrontWhdtksByPublicAccount(String paccount);

}