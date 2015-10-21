package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscDao;
import com.jlj.model.Wsc;
import com.jlj.service.IWscService;
@Component("wscService")
public class WscServiceImp implements IWscService {
	private IWscDao wscDao;
	public IWscDao getWscDao() {
		return wscDao;
	}
	@Resource
	public void setWscDao(IWscDao wscDao) {
		this.wscDao = wscDao;
	}

	public void add(Wsc wsc) throws Exception {
		wscDao.save(wsc);
	}

	public void delete(Wsc wsc) {
		wscDao.delete(wsc);
	}

	public void deleteById(int id) {
		wscDao.deleteById(id);
	}
	
	public void update(Wsc wsc) {
		wscDao.update(wsc);
	}
	
	public List<Wsc> getWscs() {
		return wscDao.getWscs();
	}
	
	public Wsc loadById(int id) {
		return wscDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wsc mo where mo.publicaccount=? ";
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
		return wscDao.getUniqueResult(queryString,p);
	}

	public List<Wsc> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wsc mo where mo.publicaccount=? ";
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
		return wscDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wsc> getFrontWscsByPublicAccount(String paccount) {
		String queryString = "from Wsc mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscDao.getObjectsByCondition(queryString, p);
	}

}
