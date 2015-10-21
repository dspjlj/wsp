package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdbigwheel;

public interface IWhdbigwheelService {

	public abstract void add(Whdbigwheel whdbigwheel) throws Exception;

	public abstract void delete(Whdbigwheel whdbigwheel);

	public abstract void deleteById(int id);

	public abstract void update(Whdbigwheel whdbigwheel);

	public abstract List<Whdbigwheel> getWhdbigwheels();

	public abstract Whdbigwheel loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdbigwheel> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdbigwheel> getFrontWhdbigwheelsByPublicAccount(
			String paccount);

}