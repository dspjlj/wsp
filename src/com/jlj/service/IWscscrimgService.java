package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscscrimg;

public interface IWscscrimgService {

	public abstract void add(Wscscrimg wscscrimg) throws Exception;

	public abstract void delete(Wscscrimg wscscrimg);

	public abstract void deleteById(int id);

	public abstract void update(Wscscrimg wscscrimg);

	public abstract List<Wscscrimg> getWscscrimgs();

	public abstract Wscscrimg loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscscrimg> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscscrimg> getFrontWscscrimgsByPublicAccount(
			String paccount);

}