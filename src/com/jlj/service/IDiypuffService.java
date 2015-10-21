package com.jlj.service;

import java.util.List;

import com.jlj.model.Diypuff;

public interface IDiypuffService {

	public abstract void add(Diypuff diypuff) throws Exception;

	public abstract void delete(Diypuff diypuff);

	public abstract void deleteById(int id);

	public abstract void update(Diypuff diypuff);

	public abstract List<Diypuff> getDiypuffs();

	public abstract Diypuff loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Diypuff> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Diypuff> getFrontDiypuffsByPublicAccount(
			String paccount);

}