package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWdyDao;
import com.jlj.model.Wdy;
import com.jlj.service.IWdyService;
@Component("wdyService")
public class WdyServiceImp implements IWdyService {
	private IWdyDao wdyDao;
	public IWdyDao getWdyDao() {
		return wdyDao;
	}
	@Resource
	public void setWdyDao(IWdyDao wdyDao) {
		this.wdyDao = wdyDao;
	}

	public void add(Wdy wdy) throws Exception {
		wdyDao.save(wdy);
	}

	public void delete(Wdy wdy) {
		wdyDao.delete(wdy);
	}

	public void deleteById(int id) {
		wdyDao.deleteById(id);
	}
	
	public void update(Wdy wdy) {
		wdyDao.update(wdy);
	}
	
	public List<Wdy> getWdys() {
		return wdyDao.getWdys();
	}
	
	public Wdy loadById(int id) {
		return wdyDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wdy mo where mo.publicaccount=? ";
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
		return wdyDao.getUniqueResult(queryString,p);
	}

	public List<Wdy> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wdy mo where mo.publicaccount=? ";
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
		return wdyDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wdy> getFrontWdysByPublicAccount(String paccount) {
		String queryString = "from Wdy mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wdyDao.getObjectsByCondition(queryString, p);
	}

}
