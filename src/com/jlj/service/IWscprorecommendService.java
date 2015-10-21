package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscprorecommend;

public interface IWscprorecommendService {

	public abstract void add(Wscprorecommend wscprorecommend) throws Exception;

	public abstract void delete(Wscprorecommend wscprorecommend);

	public abstract void deleteById(int id);

	public abstract void update(Wscprorecommend wscprorecommend);

	public abstract List<Wscprorecommend> getWscprorecommends();

	public abstract Wscprorecommend loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscprorecommend> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscprorecommend> getFrontWscprorecommendsByPublicAccount(
			String paccount);

}