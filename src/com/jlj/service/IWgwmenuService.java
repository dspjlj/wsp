package com.jlj.service;

import java.util.List;

import com.jlj.model.Wgwmenu;

public interface IWgwmenuService {

	public abstract void add(Wgwmenu wgwmenu) throws Exception;

	public abstract void delete(Wgwmenu wgwmenu);

	public abstract void deleteById(int id);

	public abstract void update(Wgwmenu wgwmenu);

	public abstract List<Wgwmenu> getWgwmenus();

	public abstract Wgwmenu loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int status,
			String publicaccount);

	public abstract List<Wgwmenu> queryList(int con, String convalue,
			int status, String publicaccount, int page, int size);

	public abstract List<Wgwmenu> getFrontWgwmenusByPublicAccount(
			String paccount);

}