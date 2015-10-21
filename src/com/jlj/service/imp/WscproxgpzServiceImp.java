package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscproxgpzDao;
import com.jlj.model.Wscproxgpz;
import com.jlj.service.IWscproxgpzService;
@Component("wscproxgpzService")
public class WscproxgpzServiceImp implements IWscproxgpzService {
	private IWscproxgpzDao wscproxgpzDao;
	public IWscproxgpzDao getWscproxgpzDao() {
		return wscproxgpzDao;
	}
	@Resource
	public void setWscproxgpzDao(IWscproxgpzDao wscproxgpzDao) {
		this.wscproxgpzDao = wscproxgpzDao;
	}

	public void add(Wscproxgpz wscproxgpz) throws Exception {
		wscproxgpzDao.save(wscproxgpz);
	}

	public void delete(Wscproxgpz wscproxgpz) {
		wscproxgpzDao.delete(wscproxgpz);
	}

	public void deleteById(int id) {
		wscproxgpzDao.deleteById(id);
	}
	
	public void update(Wscproxgpz wscproxgpz) {
		wscproxgpzDao.update(wscproxgpz);
	}
	
	public List<Wscproxgpz> getWscproxgpzs() {
		return wscproxgpzDao.getWscproxgpzs();
	}
	
	public Wscproxgpz loadById(int id) {
		return wscproxgpzDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscproxgpz mo where mo.publicaccount=? ";
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
		return wscproxgpzDao.getUniqueResult(queryString,p);
	}

	public List<Wscproxgpz> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscproxgpz mo where mo.publicaccount=? ";
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
		return wscproxgpzDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscproxgpz> getFrontWscproxgpzsByPublicAccount(String paccount) {
		String queryString = "from Wscproxgpz mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscproxgpzDao.getObjectsByCondition(queryString, p);
	}

}
