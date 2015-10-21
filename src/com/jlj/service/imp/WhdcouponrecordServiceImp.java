package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdcouponrecordDao;
import com.jlj.model.Whdcouponrecord;
import com.jlj.service.IWhdcouponrecordService;
@Component("whdcouponrecordService")
public class WhdcouponrecordServiceImp implements IWhdcouponrecordService {
	private IWhdcouponrecordDao whdcouponrecordDao;
	public IWhdcouponrecordDao getWhdcouponrecordDao() {
		return whdcouponrecordDao;
	}
	@Resource
	public void setWhdcouponrecordDao(IWhdcouponrecordDao whdcouponrecordDao) {
		this.whdcouponrecordDao = whdcouponrecordDao;
	}

	public void add(Whdcouponrecord whdcouponrecord) throws Exception {
		whdcouponrecordDao.save(whdcouponrecord);
	}

	public void delete(Whdcouponrecord whdcouponrecord) {
		whdcouponrecordDao.delete(whdcouponrecord);
	}

	public void deleteById(int id) {
		whdcouponrecordDao.deleteById(id);
	}
	
	public void update(Whdcouponrecord whdcouponrecord) {
		whdcouponrecordDao.update(whdcouponrecord);
	}
	
	public List<Whdcouponrecord> getWhdcouponrecords() {
		return whdcouponrecordDao.getWhdcouponrecords();
	}
	
	public Whdcouponrecord loadById(int id) {
		return whdcouponrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdcouponrecord mo where mo.publicaccount=? ";
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
		return whdcouponrecordDao.getUniqueResult(queryString,p);
	}

	public List<Whdcouponrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdcouponrecord mo where mo.publicaccount=? ";
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
		return whdcouponrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdcouponrecord> getFrontWhdcouponrecordsByPublicAccount(String paccount) {
		String queryString = "from Whdcouponrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdcouponrecordDao.getObjectsByCondition(queryString, p);
	}

}
