package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWkfDao;
import com.jlj.model.Wkf;
import com.jlj.service.IWkfService;
@Component("wkfService")
public class WkfServiceImp implements IWkfService {
	private IWkfDao wkfDao;
	public IWkfDao getWkfDao() {
		return wkfDao;
	}
	@Resource
	public void setWkfDao(IWkfDao wkfDao) {
		this.wkfDao = wkfDao;
	}

	public void add(Wkf wkf) throws Exception {
		wkfDao.save(wkf);
	}

	public void delete(Wkf wkf) {
		wkfDao.delete(wkf);
	}

	public void deleteById(int id) {
		wkfDao.deleteById(id);
	}
	
	public void update(Wkf wkf) {
		wkfDao.update(wkf);
	}
	
	public List<Wkf> getWkfs() {
		return wkfDao.getWkfs();
	}
	
	public Wkf loadById(int id) {
		return wkfDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wkf mo where mo.publicaccount=? ";
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
		return wkfDao.getUniqueResult(queryString,p);
	}

	public List<Wkf> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wkf mo where mo.publicaccount=? ";
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
		return wkfDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wkf> getFrontWkfsByPublicAccount(String paccount) {
		String queryString = "from Wkf mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wkfDao.getObjectsByCondition(queryString, p);
	}

}
