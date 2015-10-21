package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscprocomment;

public interface IWscprocommentService {

	public abstract void add(Wscprocomment wscprocomment) throws Exception;

	public abstract void delete(Wscprocomment wscprocomment);

	public abstract void deleteById(int id);

	public abstract void update(Wscprocomment wscprocomment);

	public abstract List<Wscprocomment> getWscprocomments();

	public abstract Wscprocomment loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscprocomment> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscprocomment> getFrontWscprocommentsByPublicAccount(
			String paccount);

}