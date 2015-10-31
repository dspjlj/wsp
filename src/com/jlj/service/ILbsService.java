package com.jlj.service;

import java.util.List;

import com.jlj.model.Lbs;

public interface ILbsService {

	public abstract void add(Lbs lbs) throws Exception;

	public abstract void delete(Lbs lbs);

	public abstract void deleteById(int id);

	public abstract void update(Lbs lbs);

	public abstract List<Lbs> getLbss();

	public abstract Lbs loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, 
			String publicaccount);

	public abstract List<Lbs> queryList(int con, String convalue, 
			String publicaccount, int page, int size);

	public abstract List<Lbs> getFrontLbssByPublicAccount(String paccount);

	public abstract void deleteByIds(String ids);

}