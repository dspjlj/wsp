package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdluckyrecord;

public interface IWhdluckyrecordService {

	public abstract void add(Whdluckyrecord whdluckyrecord) throws Exception;

	public abstract void delete(Whdluckyrecord whdluckyrecord);

	public abstract void deleteById(int id);

	public abstract void update(Whdluckyrecord whdluckyrecord);

	public abstract List<Whdluckyrecord> getWhdluckyrecords();

	public abstract Whdluckyrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdluckyrecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdluckyrecord> getFrontWhdluckyrecordsByPublicAccount(
			String paccount);

}