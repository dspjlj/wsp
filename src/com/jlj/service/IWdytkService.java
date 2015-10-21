package com.jlj.service;

import java.util.List;

import com.jlj.model.Wdytk;

public interface IWdytkService {

	public abstract void add(Wdytk wdytk) throws Exception;

	public abstract void delete(Wdytk wdytk);

	public abstract void deleteById(int id);

	public abstract void update(Wdytk wdytk);

	public abstract List<Wdytk> getWdytks();

	public abstract Wdytk loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wdytk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wdytk> getFrontWdytksByPublicAccount(String paccount);

}