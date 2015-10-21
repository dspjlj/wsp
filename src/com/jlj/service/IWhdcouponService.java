package com.jlj.service;

import java.util.List;

import com.jlj.model.Whdcoupon;

public interface IWhdcouponService {

	public abstract void add(Whdcoupon whdcoupon) throws Exception;

	public abstract void delete(Whdcoupon whdcoupon);

	public abstract void deleteById(int id);

	public abstract void update(Whdcoupon whdcoupon);

	public abstract List<Whdcoupon> getWhdcoupons();

	public abstract Whdcoupon loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Whdcoupon> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Whdcoupon> getFrontWhdcouponsByPublicAccount(
			String paccount);

}