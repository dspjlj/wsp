package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscprocollectDao;
import com.jlj.model.Wscprocollect;
import com.jlj.service.IWscprocollectService;
@Component("wscprocollectService")
public class WscprocollectServiceImp implements IWscprocollectService {
	private IWscprocollectDao wscprocollectDao;
	public IWscprocollectDao getWscprocollectDao() {
		return wscprocollectDao;
	}
	@Resource
	public void setWscprocollectDao(IWscprocollectDao wscprocollectDao) {
		this.wscprocollectDao = wscprocollectDao;
	}

	public void add(Wscprocollect wscprocollect) throws Exception {
		wscprocollectDao.save(wscprocollect);
	}

	public void delete(Wscprocollect wscprocollect) {
		wscprocollectDao.delete(wscprocollect);
	}

	public void deleteById(int id) {
		wscprocollectDao.deleteById(id);
	}
	
	public void update(Wscprocollect wscprocollect) {
		wscprocollectDao.update(wscprocollect);
	}
	
	public List<Wscprocollect> getWscprocollects() {
		return wscprocollectDao.getWscprocollects();
	}
	
	public Wscprocollect loadById(int id) {
		return wscprocollectDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscprocollect mo where mo.publicaccount=? ";
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
		return wscprocollectDao.getUniqueResult(queryString,p);
	}

	public List<Wscprocollect> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscprocollect mo where mo.publicaccount=? ";
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
		return wscprocollectDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscprocollect> getFrontWscprocollectsByPublicAccount(String paccount) {
		String queryString = "from Wscprocollect mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscprocollectDao.getObjectsByCondition(queryString, p);
	}

}
