package com.jlj.service;

import java.util.List;

import com.jlj.model.Dspuser;

public interface IDspuserService {

	public abstract void add(Dspuser dspuser) throws Exception;

	public abstract void delete(Dspuser dspuser);

	public abstract void deleteById(int id);

	public abstract void update(Dspuser dspuser);

	public abstract List<Dspuser> getDspusers();

	public abstract Dspuser loadById(int id);

	public abstract int getPageCount(int totalCount, int size);

	public abstract int getTotalCount(int con, String convalue, int pid);

	public abstract List<Dspuser> queryList(int con, String convalue,
			int pid, int page, int size);

	public abstract Dspuser userlogin(String username, String password);

	public abstract void updateBaseInfoById(String phone, String qq,
			String email, int id);

	public abstract void updatePwd(String newpwd, int id);

	public abstract int getAllTotalCount(int con, String convalue);

	public abstract List<Dspuser> queryAllList(int con, String convalue,
			int page, int size);

	public abstract void updateFreezeStatusById(int status, int id);
	
	

}