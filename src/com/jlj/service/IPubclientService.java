package com.jlj.service;

import java.util.List;

import com.jlj.model.Pubclient;

public interface IPubclientService {

	public abstract void add(Pubclient pubclient) throws Exception;

	public abstract void delete(Pubclient pubclient);

	public abstract void deleteById(int id);

	public abstract void update(Pubclient pubclient);

	public abstract List<Pubclient> getPubclients();

	public abstract Pubclient loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int selfid);

	public abstract List<Pubclient> queryList(int con, String convalue,
			int selfid, int page, int size);

	public abstract Pubclient queryPubclientByFrontpa(String frontpa);


	public abstract int getAllTotalCount(int con, String convalue);

	public abstract List<Pubclient> queryAllList(int con, String convalue,
			int page, int size);

	public abstract Pubclient getById(int id);

	public abstract void updateAppAuthById(String appid, String appsecret,
			int pubid);

}