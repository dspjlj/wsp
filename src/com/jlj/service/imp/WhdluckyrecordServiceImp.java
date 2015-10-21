package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdluckyrecordDao;
import com.jlj.model.Whdluckyrecord;
import com.jlj.service.IWhdluckyrecordService;
@Component("whdluckyrecordService")
public class WhdluckyrecordServiceImp implements IWhdluckyrecordService {
	private IWhdluckyrecordDao whdluckyrecordDao;
	public IWhdluckyrecordDao getWhdluckyrecordDao() {
		return whdluckyrecordDao;
	}
	@Resource
	public void setWhdluckyrecordDao(IWhdluckyrecordDao whdluckyrecordDao) {
		this.whdluckyrecordDao = whdluckyrecordDao;
	}

	public void add(Whdluckyrecord whdluckyrecord) throws Exception {
		whdluckyrecordDao.save(whdluckyrecord);
	}

	public void delete(Whdluckyrecord whdluckyrecord) {
		whdluckyrecordDao.delete(whdluckyrecord);
	}

	public void deleteById(int id) {
		whdluckyrecordDao.deleteById(id);
	}
	
	public void update(Whdluckyrecord whdluckyrecord) {
		whdluckyrecordDao.update(whdluckyrecord);
	}
	
	public List<Whdluckyrecord> getWhdluckyrecords() {
		return whdluckyrecordDao.getWhdluckyrecords();
	}
	
	public Whdluckyrecord loadById(int id) {
		return whdluckyrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdluckyrecord mo where mo.publicaccount=? ";
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
		return whdluckyrecordDao.getUniqueResult(queryString,p);
	}

	public List<Whdluckyrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdluckyrecord mo where mo.publicaccount=? ";
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
		return whdluckyrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdluckyrecord> getFrontWhdluckyrecordsByPublicAccount(String paccount) {
		String queryString = "from Whdluckyrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdluckyrecordDao.getObjectsByCondition(queryString, p);
	}

}
