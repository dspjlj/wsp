package com.jlj.service;

import java.util.List;

import com.jlj.model.Wlybook;

public interface IWlybookService {

	public abstract void add(Wlybook wlybook) throws Exception;

	public abstract void delete(Wlybook wlybook);

	public abstract void deleteById(int id);

	public abstract void update(Wlybook wlybook);

	public abstract List<Wlybook> getWlybooks();

	public abstract Wlybook loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wlybook> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wlybook> getFrontWlybooksByPublicAccount(
			String paccount);

}