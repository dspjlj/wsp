package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWtgDao;
import com.jlj.model.Wtg;
import com.jlj.service.IWtgService;
@Component("wtgService")
public class WtgServiceImp implements IWtgService {
	private IWtgDao wtgDao;
	public IWtgDao getWtgDao() {
		return wtgDao;
	}
	@Resource
	public void setWtgDao(IWtgDao wtgDao) {
		this.wtgDao = wtgDao;
	}

	public void add(Wtg wtg) throws Exception {
		wtgDao.save(wtg);
	}

	public void delete(Wtg wtg) {
		wtgDao.delete(wtg);
	}

	public void deleteById(int id) {
		wtgDao.deleteById(id);
	}
	
	public void update(Wtg wtg) {
		wtgDao.update(wtg);
	}
	
	public List<Wtg> getWtgs() {
		return wtgDao.getWtgs();
	}
	
	public Wtg loadById(int id) {
		return wtgDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wtg mo where mo.publicaccount=? ";
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
		return wtgDao.getUniqueResult(queryString,p);
	}

	public List<Wtg> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wtg mo where mo.publicaccount=? ";
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
		return wtgDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wtg> getFrontWtgsByPublicAccount(String paccount) {
		String queryString = "from Wtg mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wtgDao.getObjectsByCondition(queryString, p);
	}

}
