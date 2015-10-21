package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWyyorderDao;
import com.jlj.model.Wyyorder;
import com.jlj.service.IWyyorderService;
@Component("wyyorderService")
public class WyyorderServiceImp implements IWyyorderService {
	private IWyyorderDao wyyorderDao;
	public IWyyorderDao getWyyorderDao() {
		return wyyorderDao;
	}
	@Resource
	public void setWyyorderDao(IWyyorderDao wyyorderDao) {
		this.wyyorderDao = wyyorderDao;
	}

	public void add(Wyyorder wyyorder) throws Exception {
		wyyorderDao.save(wyyorder);
	}

	public void delete(Wyyorder wyyorder) {
		wyyorderDao.delete(wyyorder);
	}

	public void deleteById(int id) {
		wyyorderDao.deleteById(id);
	}
	
	public void update(Wyyorder wyyorder) {
		wyyorderDao.update(wyyorder);
	}
	
	public List<Wyyorder> getWyyorders() {
		return wyyorderDao.getWyyorders();
	}
	
	public Wyyorder loadById(int id) {
		return wyyorderDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wyyorder mo where mo.publicaccount=? ";
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
		return wyyorderDao.getUniqueResult(queryString,p);
	}

	public List<Wyyorder> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wyyorder mo where mo.publicaccount=? ";
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
		return wyyorderDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wyyorder> getFrontWyyordersByPublicAccount(String paccount) {
		String queryString = "from Wyyorder mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wyyorderDao.getObjectsByCondition(queryString, p);
	}

}
