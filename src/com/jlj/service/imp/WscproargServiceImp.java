package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscproargDao;
import com.jlj.model.Wscproarg;
import com.jlj.service.IWscproargService;
@Component("wscproargService")
public class WscproargServiceImp implements IWscproargService {
	private IWscproargDao wscproargDao;
	public IWscproargDao getWscproargDao() {
		return wscproargDao;
	}
	@Resource
	public void setWscproargDao(IWscproargDao wscproargDao) {
		this.wscproargDao = wscproargDao;
	}

	public void add(Wscproarg wscproarg) throws Exception {
		wscproargDao.save(wscproarg);
	}

	public void delete(Wscproarg wscproarg) {
		wscproargDao.delete(wscproarg);
	}

	public void deleteById(int id) {
		wscproargDao.deleteById(id);
	}
	
	public void update(Wscproarg wscproarg) {
		wscproargDao.update(wscproarg);
	}
	
	public List<Wscproarg> getWscproargs() {
		return wscproargDao.getWscproargs();
	}
	
	public Wscproarg loadById(int id) {
		return wscproargDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscproarg mo where mo.publicaccount=? ";
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
		return wscproargDao.getUniqueResult(queryString,p);
	}

	public List<Wscproarg> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscproarg mo where mo.publicaccount=? ";
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
		return wscproargDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscproarg> getFrontWscproargsByPublicAccount(String paccount) {
		String queryString = "from Wscproarg mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscproargDao.getObjectsByCondition(queryString, p);
	}

}
