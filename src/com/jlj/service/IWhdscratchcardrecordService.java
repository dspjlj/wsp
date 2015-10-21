package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdscratchcardrecord;

public interface IWhdscratchcardrecordService {

	public abstract void add(Whdscratchcardrecord whdscratchcardrecord)
			throws Exception;

	public abstract void delete(Whdscratchcardrecord whdscratchcardrecord);

	public abstract void deleteById(int id);

	public abstract void update(Whdscratchcardrecord whdscratchcardrecord);

	public abstract List<Whdscratchcardrecord> getWhdscratchcardrecords();

	public abstract Whdscratchcardrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdscratchcardrecord> queryList(int con,
			String convalue, int status, String publicaccount, int page,
			int size);

	public abstract List<Whdscratchcardrecord> getFrontWhdscratchcardrecordsByPublicAccount(
			String paccount);

}