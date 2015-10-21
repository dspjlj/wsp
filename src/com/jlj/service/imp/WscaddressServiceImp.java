package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscaddressDao;
import com.jlj.model.Wscaddress;
import com.jlj.service.IWscaddressService;
@Component("wscaddressService")
public class WscaddressServiceImp implements IWscaddressService {
	private IWscaddressDao wscaddressDao;
	public IWscaddressDao getWscaddressDao() {
		return wscaddressDao;
	}
	@Resource
	public void setWscaddressDao(IWscaddressDao wscaddressDao) {
		this.wscaddressDao = wscaddressDao;
	}

	public void add(Wscaddress wscaddress) throws Exception {
		wscaddressDao.save(wscaddress);
	}

	public void delete(Wscaddress wscaddress) {
		wscaddressDao.delete(wscaddress);
	}

	public void deleteById(int id) {
		wscaddressDao.deleteById(id);
	}
	
	public void update(Wscaddress wscaddress) {
		wscaddressDao.update(wscaddress);
	}
	
	public List<Wscaddress> getWscaddresss() {
		return wscaddressDao.getWscaddresss();
	}
	
	public Wscaddress loadById(int id) {
		return wscaddressDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscaddress mo where mo.publicaccount=? ";
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
		return wscaddressDao.getUniqueResult(queryString,p);
	}

	public List<Wscaddress> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscaddress mo where mo.publicaccount=? ";
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
		return wscaddressDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscaddress> getFrontWscaddresssByPublicAccount(String paccount) {
		String queryString = "from Wscaddress mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscaddressDao.getObjectsByCondition(queryString, p);
	}

}
