package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdlucky;

public interface IWhdluckyService {

	public abstract void add(Whdlucky whdlucky) throws Exception;

	public abstract void delete(Whdlucky whdlucky);

	public abstract void deleteById(int id);

	public abstract void update(Whdlucky whdlucky);

	public abstract List<Whdlucky> getWhdluckys();

	public abstract Whdlucky loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdlucky> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdlucky> getFrontWhdluckysByPublicAccount(
			String paccount);

}