package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWdytkDao;
import com.jlj.model.Wdytk;
import com.jlj.service.IWdytkService;
@Component("wdytkService")
public class WdytkServiceImp implements IWdytkService {
	private IWdytkDao wdytkDao;
	public IWdytkDao getWdytkDao() {
		return wdytkDao;
	}
	@Resource
	public void setWdytkDao(IWdytkDao wdytkDao) {
		this.wdytkDao = wdytkDao;
	}

	public void add(Wdytk wdytk) throws Exception {
		wdytkDao.save(wdytk);
	}

	public void delete(Wdytk wdytk) {
		wdytkDao.delete(wdytk);
	}

	public void deleteById(int id) {
		wdytkDao.deleteById(id);
	}
	
	public void update(Wdytk wdytk) {
		wdytkDao.update(wdytk);
	}
	
	public List<Wdytk> getWdytks() {
		return wdytkDao.getWdytks();
	}
	
	public Wdytk loadById(int id) {
		return wdytkDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wdytk mo where mo.publicaccount=? ";
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
		return wdytkDao.getUniqueResult(queryString,p);
	}

	public List<Wdytk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wdytk mo where mo.publicaccount=? ";
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
		return wdytkDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wdytk> getFrontWdytksByPublicAccount(String paccount) {
		String queryString = "from Wdytk mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wdytkDao.getObjectsByCondition(queryString, p);
	}

}
