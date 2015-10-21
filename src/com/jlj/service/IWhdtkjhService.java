package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdtkjh;

public interface IWhdtkjhService {

	public abstract void add(Whdtkjh whdtkjh) throws Exception;

	public abstract void delete(Whdtkjh whdtkjh);

	public abstract void deleteById(int id);

	public abstract void update(Whdtkjh whdtkjh);

	public abstract List<Whdtkjh> getWhdtkjhs();

	public abstract Whdtkjh loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdtkjh> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdtkjh> getFrontWhdtkjhsByPublicAccount(
			String paccount);

}