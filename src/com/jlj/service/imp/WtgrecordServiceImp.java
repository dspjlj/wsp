package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWtgrecordDao;
import com.jlj.model.Wtgrecord;
import com.jlj.service.IWtgrecordService;
@Component("wtgrecordService")
public class WtgrecordServiceImp implements IWtgrecordService {
	private IWtgrecordDao wtgrecordDao;
	public IWtgrecordDao getWtgrecordDao() {
		return wtgrecordDao;
	}
	@Resource
	public void setWtgrecordDao(IWtgrecordDao wtgrecordDao) {
		this.wtgrecordDao = wtgrecordDao;
	}

	public void add(Wtgrecord wtgrecord) throws Exception {
		wtgrecordDao.save(wtgrecord);
	}

	public void delete(Wtgrecord wtgrecord) {
		wtgrecordDao.delete(wtgrecord);
	}

	public void deleteById(int id) {
		wtgrecordDao.deleteById(id);
	}
	
	public void update(Wtgrecord wtgrecord) {
		wtgrecordDao.update(wtgrecord);
	}
	
	public List<Wtgrecord> getWtgrecords() {
		return wtgrecordDao.getWtgrecords();
	}
	
	public Wtgrecord loadById(int id) {
		return wtgrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wtgrecord mo where mo.publicaccount=? ";
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
		return wtgrecordDao.getUniqueResult(queryString,p);
	}

	public List<Wtgrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wtgrecord mo where mo.publicaccount=? ";
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
		return wtgrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wtgrecord> getFrontWtgrecordsByPublicAccount(String paccount) {
		String queryString = "from Wtgrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wtgrecordDao.getObjectsByCondition(queryString, p);
	}

}
