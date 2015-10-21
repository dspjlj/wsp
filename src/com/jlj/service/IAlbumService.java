package com.jlj.service;

import java.util.List;

import com.jlj.model.Album;

public interface IAlbumService {

	public abstract void add(Album album) throws Exception;

	public abstract void delete(Album album);

	public abstract void deleteById(int id);

	public abstract void update(Album album);

	public abstract List<Album> getAlbums();

	public abstract Album loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Album> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size);

	public abstract List<Album> getFrontAlbumsByPublicAccount(String paccount);

}