package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdcouponrecord;

public interface IWhdcouponrecordService {

	public abstract void add(Whdcouponrecord whdcouponrecord) throws Exception;

	public abstract void delete(Whdcouponrecord whdcouponrecord);

	public abstract void deleteById(int id);

	public abstract void update(Whdcouponrecord whdcouponrecord);

	public abstract List<Whdcouponrecord> getWhdcouponrecords();

	public abstract Whdcouponrecord loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdcouponrecord> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdcouponrecord> getFrontWhdcouponrecordsByPublicAccount(
			String paccount);

}