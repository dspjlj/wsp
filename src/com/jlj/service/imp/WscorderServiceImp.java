package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscorderDao;
import com.jlj.model.Wscorder;
import com.jlj.service.IWscorderService;
@Component("wscorderService")
public class WscorderServiceImp implements IWscorderService {
	private IWscorderDao wscorderDao;
	public IWscorderDao getWscorderDao() {
		return wscorderDao;
	}
	@Resource
	public void setWscorderDao(IWscorderDao wscorderDao) {
		this.wscorderDao = wscorderDao;
	}

	public void add(Wscorder wscorder) throws Exception {
		wscorderDao.save(wscorder);
	}

	public void delete(Wscorder wscorder) {
		wscorderDao.delete(wscorder);
	}

	public void deleteById(int id) {
		wscorderDao.deleteById(id);
	}
	
	public void update(Wscorder wscorder) {
		wscorderDao.update(wscorder);
	}
	
	public List<Wscorder> getWscorders() {
		return wscorderDao.getWscorders();
	}
	
	public Wscorder loadById(int id) {
		return wscorderDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscorder mo where mo.publicaccount=? ";
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
		return wscorderDao.getUniqueResult(queryString,p);
	}

	public List<Wscorder> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscorder mo where mo.publicaccount=? ";
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
		return wscorderDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscorder> getFrontWscordersByPublicAccount(String paccount) {
		String queryString = "from Wscorder mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscorderDao.getObjectsByCondition(queryString, p);
	}

}
