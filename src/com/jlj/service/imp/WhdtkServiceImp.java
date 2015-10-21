package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdtkDao;
import com.jlj.model.Whdtk;
import com.jlj.service.IWhdtkService;
@Component("whdtkService")
public class WhdtkServiceImp implements IWhdtkService {
	private IWhdtkDao whdtkDao;
	public IWhdtkDao getWhdtkDao() {
		return whdtkDao;
	}
	@Resource
	public void setWhdtkDao(IWhdtkDao whdtkDao) {
		this.whdtkDao = whdtkDao;
	}

	public void add(Whdtk whdtk) throws Exception {
		whdtkDao.save(whdtk);
	}

	public void delete(Whdtk whdtk) {
		whdtkDao.delete(whdtk);
	}

	public void deleteById(int id) {
		whdtkDao.deleteById(id);
	}
	
	public void update(Whdtk whdtk) {
		whdtkDao.update(whdtk);
	}
	
	public List<Whdtk> getWhdtks() {
		return whdtkDao.getWhdtks();
	}
	
	public Whdtk loadById(int id) {
		return whdtkDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdtk mo where mo.publicaccount=? ";
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
		return whdtkDao.getUniqueResult(queryString,p);
	}

	public List<Whdtk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdtk mo where mo.publicaccount=? ";
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
		return whdtkDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdtk> getFrontWhdtksByPublicAccount(String paccount) {
		String queryString = "from Whdtk mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdtkDao.getObjectsByCondition(queryString, p);
	}

}
