package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWyyDao;
import com.jlj.model.Wyy;
import com.jlj.service.IWyyService;
@Component("wyyService")
public class WyyServiceImp implements IWyyService {
	private IWyyDao wyyDao;
	public IWyyDao getWyyDao() {
		return wyyDao;
	}
	@Resource
	public void setWyyDao(IWyyDao wyyDao) {
		this.wyyDao = wyyDao;
	}

	public void add(Wyy wyy) throws Exception {
		wyyDao.save(wyy);
	}

	public void delete(Wyy wyy) {
		wyyDao.delete(wyy);
	}

	public void deleteById(int id) {
		wyyDao.deleteById(id);
	}
	
	public void update(Wyy wyy) {
		wyyDao.update(wyy);
	}
	
	public List<Wyy> getWyys() {
		return wyyDao.getWyys();
	}
	
	public Wyy loadById(int id) {
		return wyyDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wyy mo where mo.publicaccount=? ";
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
		return wyyDao.getUniqueResult(queryString,p);
	}

	public List<Wyy> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wyy mo where mo.publicaccount=? ";
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
		return wyyDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wyy> getFrontWyysByPublicAccount(String paccount) {
		String queryString = "from Wyy mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wyyDao.getObjectsByCondition(queryString, p);
	}

}
