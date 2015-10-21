package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdscratchcard;

public interface IWhdscratchcardService {

	public abstract void add(Whdscratchcard whdscratchcard) throws Exception;

	public abstract void delete(Whdscratchcard whdscratchcard);

	public abstract void deleteById(int id);

	public abstract void update(Whdscratchcard whdscratchcard);

	public abstract List<Whdscratchcard> getWhdscratchcards();

	public abstract Whdscratchcard loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdscratchcard> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdscratchcard> getFrontWhdscratchcardsByPublicAccount(
			String paccount);

}