package com.jlj.service;

import java.util.List;

import com.jlj.model.Bigtype;

public interface IBigtypeService {

	public abstract void add(Bigtype bigtype) throws Exception;

	public abstract void delete(Bigtype bigtype);

	public abstract void deleteById(int id);

	public abstract void update(Bigtype bigtype);

	public abstract List<Bigtype> getBigtypes();

	public abstract Bigtype loadById(int id);

	public abstract int getPageCount(int con, String convalue, int status,
			String publicaccount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Bigtype> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Bigtype> getBigtypesByPublicAccount(String paccount);
	
	public abstract List<Bigtype> getFrontBigtypesByPublicAccount(String paccount);

	public abstract int getTotalCount(String paccount);

	public abstract int getPageCount(int totalCount, int size);

	public abstract List<Bigtype> queryList(String paccount, int page, int size);

	public abstract int getTotalCount(int pid, String paccount);

	public abstract List<Bigtype> queryList(int pid, String paccount, int page,
			int size);

	public abstract List<Bigtype> getBigtypesBycondition(int ison, int ttype,
			int hastype, String paccount);

	public abstract List<Bigtype> queryIndexBigtypesByWgwId(int wgwid);

	public abstract List<Bigtype> querySonBigtypesByParentBigtypeId(int bigtypeid);

	public abstract List<Bigtype> getBigtypesBycondition(int ison, int hastype,
			String paccount);

	public abstract List<Bigtype> queryFrontBigtypesByCondition(String frontpa);

}