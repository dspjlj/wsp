package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWlyDao;
import com.jlj.model.Wly;
import com.jlj.service.IWlyService;
@Component("wlyService")
public class WlyServiceImp implements IWlyService {
	private IWlyDao wlyDao;
	public IWlyDao getWlyDao() {
		return wlyDao;
	}
	@Resource
	public void setWlyDao(IWlyDao wlyDao) {
		this.wlyDao = wlyDao;
	}

	public void add(Wly wly) throws Exception {
		wlyDao.save(wly);
	}

	public void delete(Wly wly) {
		wlyDao.delete(wly);
	}

	public void deleteById(int id) {
		wlyDao.deleteById(id);
	}
	
	public void update(Wly wly) {
		wlyDao.update(wly);
	}
	
	public List<Wly> getWlys() {
		return wlyDao.getWlys();
	}
	
	public Wly loadById(int id) {
		return wlyDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wly mo where mo.publicaccount=? ";
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
		return wlyDao.getUniqueResult(queryString,p);
	}

	public List<Wly> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wly mo where mo.publicaccount=? ";
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
		return wlyDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wly> getFrontWlysByPublicAccount(String paccount) {
		String queryString = "from Wly mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wlyDao.getObjectsByCondition(queryString, p);
	}

}
