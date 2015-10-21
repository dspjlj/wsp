package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdbigwheelrecord;

public interface IWhdbigwheelrecordService {

	public abstract void add(Whdbigwheelrecord whdbigwheelrecord)
			throws Exception;

	public abstract void delete(Whdbigwheelrecord whdbigwheelrecord);

	public abstract void deleteById(int id);

	public abstract void update(Whdbigwheelrecord whdbigwheelrecord);

	public abstract List<Whdbigwheelrecord> getWhdbigwheelrecords();

	public abstract Whdbigwheelrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdbigwheelrecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdbigwheelrecord> getFrontWhdbigwheelrecordsByPublicAccount(
			String paccount);

}