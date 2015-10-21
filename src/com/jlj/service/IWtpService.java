package com.jlj.service;

import java.util.List;

import com.jlj.model.Wtp;

public interface IWtpService {

	public abstract void add(Wtp wtp) throws Exception;

	public abstract void delete(Wtp wtp);

	public abstract void deleteById(int id);

	public abstract void update(Wtp wtp);

	public abstract List<Wtp> getWtps();

	public abstract Wtp loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wtp> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wtp> getFrontWtpsByPublicAccount(String paccount);

}