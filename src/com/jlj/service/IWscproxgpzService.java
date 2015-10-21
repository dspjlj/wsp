package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscproxgpz;

public interface IWscproxgpzService {

	public abstract void add(Wscproxgpz wscproxgpz) throws Exception;

	public abstract void delete(Wscproxgpz wscproxgpz);

	public abstract void deleteById(int id);

	public abstract void update(Wscproxgpz wscproxgpz);

	public abstract List<Wscproxgpz> getWscproxgpzs();

	public abstract Wscproxgpz loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscproxgpz> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscproxgpz> getFrontWscproxgpzsByPublicAccount(
			String paccount);

}