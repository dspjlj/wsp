package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdluckyDao;
import com.jlj.model.Whdlucky;
import com.jlj.service.IWhdluckyService;
@Component("whdluckyService")
public class WhdluckyServiceImp implements IWhdluckyService {
	private IWhdluckyDao whdluckyDao;
	public IWhdluckyDao getWhdluckyDao() {
		return whdluckyDao;
	}
	@Resource
	public void setWhdluckyDao(IWhdluckyDao whdluckyDao) {
		this.whdluckyDao = whdluckyDao;
	}

	public void add(Whdlucky whdlucky) throws Exception {
		whdluckyDao.save(whdlucky);
	}

	public void delete(Whdlucky whdlucky) {
		whdluckyDao.delete(whdlucky);
	}

	public void deleteById(int id) {
		whdluckyDao.deleteById(id);
	}
	
	public void update(Whdlucky whdlucky) {
		whdluckyDao.update(whdlucky);
	}
	
	public List<Whdlucky> getWhdluckys() {
		return whdluckyDao.getWhdluckys();
	}
	
	public Whdlucky loadById(int id) {
		return whdluckyDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdlucky mo where mo.publicaccount=? ";
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
		return whdluckyDao.getUniqueResult(queryString,p);
	}

	public List<Whdlucky> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdlucky mo where mo.publicaccount=? ";
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
		return whdluckyDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdlucky> getFrontWhdluckysByPublicAccount(String paccount) {
		String queryString = "from Whdlucky mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdluckyDao.getObjectsByCondition(queryString, p);
	}

}
