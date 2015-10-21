package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWdyrecordDao;
import com.jlj.model.Wdyrecord;
import com.jlj.service.IWdyrecordService;
@Component("wdyrecordService")
public class WdyrecordServiceImp implements IWdyrecordService {
	private IWdyrecordDao wdyrecordDao;
	public IWdyrecordDao getWdyrecordDao() {
		return wdyrecordDao;
	}
	@Resource
	public void setWdyrecordDao(IWdyrecordDao wdyrecordDao) {
		this.wdyrecordDao = wdyrecordDao;
	}

	public void add(Wdyrecord wdyrecord) throws Exception {
		wdyrecordDao.save(wdyrecord);
	}

	public void delete(Wdyrecord wdyrecord) {
		wdyrecordDao.delete(wdyrecord);
	}

	public void deleteById(int id) {
		wdyrecordDao.deleteById(id);
	}
	
	public void update(Wdyrecord wdyrecord) {
		wdyrecordDao.update(wdyrecord);
	}
	
	public List<Wdyrecord> getWdyrecords() {
		return wdyrecordDao.getWdyrecords();
	}
	
	public Wdyrecord loadById(int id) {
		return wdyrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wdyrecord mo where mo.publicaccount=? ";
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
		return wdyrecordDao.getUniqueResult(queryString,p);
	}

	public List<Wdyrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wdyrecord mo where mo.publicaccount=? ";
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
		return wdyrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wdyrecord> getFrontWdyrecordsByPublicAccount(String paccount) {
		String queryString = "from Wdyrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wdyrecordDao.getObjectsByCondition(queryString, p);
	}

}
