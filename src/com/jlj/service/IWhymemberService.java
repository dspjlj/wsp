package com.jlj.service;

import java.util.List;

import com.jlj.model.Whymember;

public interface IWhymemberService {

	public abstract void add(Whymember whymember) throws Exception;

	public abstract void delete(Whymember whymember);

	public abstract void deleteById(int id);

	public abstract void update(Whymember whymember);

	public abstract List<Whymember> getWhymembers();

	public abstract Whymember loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whymember> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whymember> getFrontWhymembersByPublicAccount(
			String paccount);

}