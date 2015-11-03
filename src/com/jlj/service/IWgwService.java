package com.jlj.service;

import java.util.List;

import com.jlj.model.Wgw;

public interface IWgwService {

	public abstract void add(Wgw wgw) throws Exception;

	public abstract void delete(Wgw wgw);

	public abstract void deleteById(int id);

	public abstract void update(Wgw wgw);

	public abstract List<Wgw> getWgws();

	public abstract Wgw loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wgw> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wgw> getFrontWgwsByPublicAccount(String paccount);

	public abstract Wgw queryWgwByPublicAccount(String paccount);

	public abstract void updateTemplateByPublicAccount(int template1,
			int template2, int template3, int template4, String paccount);

}