package com.jlj.service;

import java.util.List;

import com.jlj.model.Wlyblack;

public interface IWlyblackService {

	public abstract void add(Wlyblack wlyblack) throws Exception;

	public abstract void delete(Wlyblack wlyblack);

	public abstract void deleteById(int id);

	public abstract void update(Wlyblack wlyblack);

	public abstract List<Wlyblack> getWlyblacks();

	public abstract Wlyblack loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wlyblack> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wlyblack> getFrontWlyblacksByPublicAccount(
			String paccount);

}