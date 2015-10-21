package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdgoldeneggDao;
import com.jlj.model.Whdgoldenegg;
import com.jlj.service.IWhdgoldeneggService;
@Component("whdgoldeneggService")
public class WhdgoldeneggServiceImp implements IWhdgoldeneggService {
	private IWhdgoldeneggDao whdgoldeneggDao;
	public IWhdgoldeneggDao getWhdgoldeneggDao() {
		return whdgoldeneggDao;
	}
	@Resource
	public void setWhdgoldeneggDao(IWhdgoldeneggDao whdgoldeneggDao) {
		this.whdgoldeneggDao = whdgoldeneggDao;
	}

	public void add(Whdgoldenegg whdgoldenegg) throws Exception {
		whdgoldeneggDao.save(whdgoldenegg);
	}

	public void delete(Whdgoldenegg whdgoldenegg) {
		whdgoldeneggDao.delete(whdgoldenegg);
	}

	public void deleteById(int id) {
		whdgoldeneggDao.deleteById(id);
	}
	
	public void update(Whdgoldenegg whdgoldenegg) {
		whdgoldeneggDao.update(whdgoldenegg);
	}
	
	public List<Whdgoldenegg> getWhdgoldeneggs() {
		return whdgoldeneggDao.getWhdgoldeneggs();
	}
	
	public Whdgoldenegg loadById(int id) {
		return whdgoldeneggDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdgoldenegg mo where mo.publicaccount=? ";
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
		return whdgoldeneggDao.getUniqueResult(queryString,p);
	}

	public List<Whdgoldenegg> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdgoldenegg mo where mo.publicaccount=? ";
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
		return whdgoldeneggDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdgoldenegg> getFrontWhdgoldeneggsByPublicAccount(String paccount) {
		String queryString = "from Whdgoldenegg mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdgoldeneggDao.getObjectsByCondition(queryString, p);
	}

}
