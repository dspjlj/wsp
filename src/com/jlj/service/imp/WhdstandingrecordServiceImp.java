package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdstandingrecordDao;
import com.jlj.model.Whdstandingrecord;
import com.jlj.service.IWhdstandingrecordService;
@Component("whdstandingrecordService")
public class WhdstandingrecordServiceImp implements IWhdstandingrecordService {
	private IWhdstandingrecordDao whdstandingrecordDao;
	public IWhdstandingrecordDao getWhdstandingrecordDao() {
		return whdstandingrecordDao;
	}
	@Resource
	public void setWhdstandingrecordDao(IWhdstandingrecordDao whdstandingrecordDao) {
		this.whdstandingrecordDao = whdstandingrecordDao;
	}

	public void add(Whdstandingrecord whdstandingrecord) throws Exception {
		whdstandingrecordDao.save(whdstandingrecord);
	}

	public void delete(Whdstandingrecord whdstandingrecord) {
		whdstandingrecordDao.delete(whdstandingrecord);
	}

	public void deleteById(int id) {
		whdstandingrecordDao.deleteById(id);
	}
	
	public void update(Whdstandingrecord whdstandingrecord) {
		whdstandingrecordDao.update(whdstandingrecord);
	}
	
	public List<Whdstandingrecord> getWhdstandingrecords() {
		return whdstandingrecordDao.getWhdstandingrecords();
	}
	
	public Whdstandingrecord loadById(int id) {
		return whdstandingrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdstandingrecord mo where mo.publicaccount=? ";
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
		return whdstandingrecordDao.getUniqueResult(queryString,p);
	}

	public List<Whdstandingrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdstandingrecord mo where mo.publicaccount=? ";
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
		return whdstandingrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdstandingrecord> getFrontWhdstandingrecordsByPublicAccount(String paccount) {
		String queryString = "from Whdstandingrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdstandingrecordDao.getObjectsByCondition(queryString, p);
	}

}
