package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscprodiscountDao;
import com.jlj.model.Wscprodiscount;
import com.jlj.service.IWscprodiscountService;
@Component("wscprodiscountService")
public class WscprodiscountServiceImp implements IWscprodiscountService {
	private IWscprodiscountDao wscprodiscountDao;
	public IWscprodiscountDao getWscprodiscountDao() {
		return wscprodiscountDao;
	}
	@Resource
	public void setWscprodiscountDao(IWscprodiscountDao wscprodiscountDao) {
		this.wscprodiscountDao = wscprodiscountDao;
	}

	public void add(Wscprodiscount wscprodiscount) throws Exception {
		wscprodiscountDao.save(wscprodiscount);
	}

	public void delete(Wscprodiscount wscprodiscount) {
		wscprodiscountDao.delete(wscprodiscount);
	}

	public void deleteById(int id) {
		wscprodiscountDao.deleteById(id);
	}
	
	public void update(Wscprodiscount wscprodiscount) {
		wscprodiscountDao.update(wscprodiscount);
	}
	
	public List<Wscprodiscount> getWscprodiscounts() {
		return wscprodiscountDao.getWscprodiscounts();
	}
	
	public Wscprodiscount loadById(int id) {
		return wscprodiscountDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscprodiscount mo where mo.publicaccount=? ";
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
		return wscprodiscountDao.getUniqueResult(queryString,p);
	}

	public List<Wscprodiscount> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscprodiscount mo where mo.publicaccount=? ";
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
		return wscprodiscountDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscprodiscount> getFrontWscprodiscountsByPublicAccount(String paccount) {
		String queryString = "from Wscprodiscount mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscprodiscountDao.getObjectsByCondition(queryString, p);
	}

}
