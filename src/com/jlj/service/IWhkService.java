package com.jlj.service;

import java.util.List;

import com.jlj.model.Whk;

public interface IWhkService {

	public abstract void add(Whk whk) throws Exception;

	public abstract void delete(Whk whk);

	public abstract void deleteById(int id);

	public abstract void update(Whk whk);

	public abstract List<Whk> getWhks();

	public abstract Whk loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Whk> getFrontWhksByPublicAccount(String paccount);

}