package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdstandingDao;
import com.jlj.model.Whdstanding;
import com.jlj.service.IWhdstandingService;
@Component("whdstandingService")
public class WhdstandingServiceImp implements IWhdstandingService {
	private IWhdstandingDao whdstandingDao;
	public IWhdstandingDao getWhdstandingDao() {
		return whdstandingDao;
	}
	@Resource
	public void setWhdstandingDao(IWhdstandingDao whdstandingDao) {
		this.whdstandingDao = whdstandingDao;
	}

	public void add(Whdstanding whdstanding) throws Exception {
		whdstandingDao.save(whdstanding);
	}

	public void delete(Whdstanding whdstanding) {
		whdstandingDao.delete(whdstanding);
	}

	public void deleteById(int id) {
		whdstandingDao.deleteById(id);
	}
	
	public void update(Whdstanding whdstanding) {
		whdstandingDao.update(whdstanding);
	}
	
	public List<Whdstanding> getWhdstandings() {
		return whdstandingDao.getWhdstandings();
	}
	
	public Whdstanding loadById(int id) {
		return whdstandingDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdstanding mo where mo.publicaccount=? ";
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
		return whdstandingDao.getUniqueResult(queryString,p);
	}

	public List<Whdstanding> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdstanding mo where mo.publicaccount=? ";
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
		return whdstandingDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdstanding> getFrontWhdstandingsByPublicAccount(String paccount) {
		String queryString = "from Whdstanding mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdstandingDao.getObjectsByCondition(queryString, p);
	}

}
