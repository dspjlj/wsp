package com.jlj.service;

import java.util.List;

import com.jlj.model.Wtptk;

public interface IWtptkService {

	public abstract void add(Wtptk wtptk) throws Exception;

	public abstract void delete(Wtptk wtptk);

	public abstract void deleteById(int id);

	public abstract void update(Wtptk wtptk);

	public abstract List<Wtptk> getWtptks();

	public abstract Wtptk loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wtptk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wtptk> getFrontWtptksByPublicAccount(String paccount);

}