package com.jlj.service;

import java.util.List;

import com.jlj.model.Bgmusic;

public interface IBgmusicService {

	public abstract void add(Bgmusic bgmusic) throws Exception;

	public abstract void delete(Bgmusic bgmusic);

	public abstract void deleteById(int id);

	public abstract void update(Bgmusic bgmusic);

	public abstract List<Bgmusic> getBgmusics();

	public abstract Bgmusic loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Bgmusic> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Bgmusic> getFrontBgmusicsByPublicAccount(
			String paccount);

	public abstract Bgmusic queryBgmusicByPublicAccount(String paccount);

	public abstract Bgmusic queryBgmusicByWgwId(int wgwid);

}