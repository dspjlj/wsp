package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdtkjhDao;
import com.jlj.model.Whdtkjh;
import com.jlj.service.IWhdtkjhService;
@Component("whdtkjhService")
public class WhdtkjhServiceImp implements IWhdtkjhService {
	private IWhdtkjhDao whdtkjhDao;
	public IWhdtkjhDao getWhdtkjhDao() {
		return whdtkjhDao;
	}
	@Resource
	public void setWhdtkjhDao(IWhdtkjhDao whdtkjhDao) {
		this.whdtkjhDao = whdtkjhDao;
	}

	public void add(Whdtkjh whdtkjh) throws Exception {
		whdtkjhDao.save(whdtkjh);
	}

	public void delete(Whdtkjh whdtkjh) {
		whdtkjhDao.delete(whdtkjh);
	}

	public void deleteById(int id) {
		whdtkjhDao.deleteById(id);
	}
	
	public void update(Whdtkjh whdtkjh) {
		whdtkjhDao.update(whdtkjh);
	}
	
	public List<Whdtkjh> getWhdtkjhs() {
		return whdtkjhDao.getWhdtkjhs();
	}
	
	public Whdtkjh loadById(int id) {
		return whdtkjhDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdtkjh mo where mo.publicaccount=? ";
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
		return whdtkjhDao.getUniqueResult(queryString,p);
	}

	public List<Whdtkjh> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdtkjh mo where mo.publicaccount=? ";
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
		return whdtkjhDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdtkjh> getFrontWhdtkjhsByPublicAccount(String paccount) {
		String queryString = "from Whdtkjh mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdtkjhDao.getObjectsByCondition(queryString, p);
	}

}
