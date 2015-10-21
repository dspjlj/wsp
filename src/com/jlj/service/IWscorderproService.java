package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscorderpro;

public interface IWscorderproService {

	public abstract void add(Wscorderpro wscorderpro) throws Exception;

	public abstract void delete(Wscorderpro wscorderpro);

	public abstract void deleteById(int id);

	public abstract void update(Wscorderpro wscorderpro);

	public abstract List<Wscorderpro> getWscorderpros();

	public abstract Wscorderpro loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscorderpro> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscorderpro> getFrontWscorderprosByPublicAccount(
			String paccount);

}