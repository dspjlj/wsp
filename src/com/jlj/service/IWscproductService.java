package com.jlj.service;

import java.util.List;

import com.jlj.model.Wscproduct;

public interface IWscproductService {

	public abstract void add(Wscproduct wscproduct) throws Exception;

	public abstract void delete(Wscproduct wscproduct);

	public abstract void deleteById(int id);

	public abstract void update(Wscproduct wscproduct);

	public abstract List<Wscproduct> getWscproducts();

	public abstract Wscproduct loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wscproduct> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wscproduct> getFrontWscproductsByPublicAccount(
			String paccount);

}