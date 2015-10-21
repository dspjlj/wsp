package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWgwDao;
import com.jlj.model.Wgw;
import com.jlj.service.IWgwService;
@Component("wgwService")
public class WgwServiceImp implements IWgwService {
	private IWgwDao wgwDao;
	public IWgwDao getWgwDao() {
		return wgwDao;
	}
	@Resource
	public void setWgwDao(IWgwDao wgwDao) {
		this.wgwDao = wgwDao;
	}

	public void add(Wgw wgw) throws Exception {
		wgwDao.save(wgw);
	}

	public void delete(Wgw wgw) {
		wgwDao.delete(wgw);
	}

	public void deleteById(int id) {
		wgwDao.deleteById(id);
	}
	
	public void update(Wgw wgw) {
		wgwDao.update(wgw);
	}
	
	public List<Wgw> getWgws() {
		return wgwDao.getWgws();
	}
	
	public Wgw loadById(int id) {
		return wgwDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wgw mo where mo.publicaccount=? ";
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
		return wgwDao.getUniqueResult(queryString,p);
	}

	public List<Wgw> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wgw mo where mo.publicaccount=? ";
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
		return wgwDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wgw> getFrontWgwsByPublicAccount(String paccount) {
		String queryString = "from Wgw mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wgwDao.getObjectsByCondition(queryString, p);
	}

}
