package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscpscenterDao;
import com.jlj.model.Wscpscenter;
import com.jlj.service.IWscpscenterService;
@Component("wscpscenterService")
public class WscpscenterServiceImp implements IWscpscenterService {
	private IWscpscenterDao wscpscenterDao;
	public IWscpscenterDao getWscpscenterDao() {
		return wscpscenterDao;
	}
	@Resource
	public void setWscpscenterDao(IWscpscenterDao wscpscenterDao) {
		this.wscpscenterDao = wscpscenterDao;
	}

	public void add(Wscpscenter wscpscenter) throws Exception {
		wscpscenterDao.save(wscpscenter);
	}

	public void delete(Wscpscenter wscpscenter) {
		wscpscenterDao.delete(wscpscenter);
	}

	public void deleteById(int id) {
		wscpscenterDao.deleteById(id);
	}
	
	public void update(Wscpscenter wscpscenter) {
		wscpscenterDao.update(wscpscenter);
	}
	
	public List<Wscpscenter> getWscpscenters() {
		return wscpscenterDao.getWscpscenters();
	}
	
	public Wscpscenter loadById(int id) {
		return wscpscenterDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscpscenter mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//条件1
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return wscpscenterDao.getUniqueResult(queryString,p);
	}

	public List<Wscpscenter> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscpscenter mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//条件1
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.orderid asc ";
		return wscpscenterDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscpscenter> getFrontWscpscentersByPublicAccount(String paccount) {
		String queryString = "from Wscpscenter mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscpscenterDao.getObjectsByCondition(queryString, p);
	}

}
