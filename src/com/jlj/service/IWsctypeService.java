package com.jlj.service;

import java.util.List;

import com.jlj.model.Wsctype;

public interface IWsctypeService {

	public abstract void add(Wsctype wsctype) throws Exception;

	public abstract void delete(Wsctype wsctype);

	public abstract void deleteById(int id);

	public abstract void update(Wsctype wsctype);

	public abstract List<Wsctype> getWsctypes();

	public abstract Wsctype loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wsctype> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wsctype> getFrontWsctypesByPublicAccount(
			String paccount);

}