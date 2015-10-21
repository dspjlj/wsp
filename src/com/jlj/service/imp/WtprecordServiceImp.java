package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWtprecordDao;
import com.jlj.model.Wtprecord;
import com.jlj.service.IWtprecordService;
@Component("wtprecordService")
public class WtprecordServiceImp implements IWtprecordService {
	private IWtprecordDao wtprecordDao;
	public IWtprecordDao getWtprecordDao() {
		return wtprecordDao;
	}
	@Resource
	public void setWtprecordDao(IWtprecordDao wtprecordDao) {
		this.wtprecordDao = wtprecordDao;
	}

	public void add(Wtprecord wtprecord) throws Exception {
		wtprecordDao.save(wtprecord);
	}

	public void delete(Wtprecord wtprecord) {
		wtprecordDao.delete(wtprecord);
	}

	public void deleteById(int id) {
		wtprecordDao.deleteById(id);
	}
	
	public void update(Wtprecord wtprecord) {
		wtprecordDao.update(wtprecord);
	}
	
	public List<Wtprecord> getWtprecords() {
		return wtprecordDao.getWtprecords();
	}
	
	public Wtprecord loadById(int id) {
		return wtprecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wtprecord mo where mo.publicaccount=? ";
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
		return wtprecordDao.getUniqueResult(queryString,p);
	}

	public List<Wtprecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wtprecord mo where mo.publicaccount=? ";
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
		return wtprecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wtprecord> getFrontWtprecordsByPublicAccount(String paccount) {
		String queryString = "from Wtprecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wtprecordDao.getObjectsByCondition(queryString, p);
	}

}
