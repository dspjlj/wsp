package com.jlj.service;

import java.util.List;

import com.jlj.model.Wgame;

public interface IWgameService {

	public abstract void add(Wgame wgame) throws Exception;

	public abstract void delete(Wgame wgame);

	public abstract void deleteById(int id);

	public abstract void update(Wgame wgame);

	public abstract List<Wgame> getWgames();

	public abstract Wgame loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wgame> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Wgame> getFrontWgamesByPublicAccount(String paccount);

}