package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdgoldeneggrecordDao;
import com.jlj.model.Whdgoldeneggrecord;
import com.jlj.service.IWhdgoldeneggrecordService;
@Component("whdgoldeneggrecordService")
public class WhdgoldeneggrecordServiceImp implements IWhdgoldeneggrecordService {
	private IWhdgoldeneggrecordDao whdgoldeneggrecordDao;
	public IWhdgoldeneggrecordDao getWhdgoldeneggrecordDao() {
		return whdgoldeneggrecordDao;
	}
	@Resource
	public void setWhdgoldeneggrecordDao(IWhdgoldeneggrecordDao whdgoldeneggrecordDao) {
		this.whdgoldeneggrecordDao = whdgoldeneggrecordDao;
	}

	public void add(Whdgoldeneggrecord whdgoldeneggrecord) throws Exception {
		whdgoldeneggrecordDao.save(whdgoldeneggrecord);
	}

	public void delete(Whdgoldeneggrecord whdgoldeneggrecord) {
		whdgoldeneggrecordDao.delete(whdgoldeneggrecord);
	}

	public void deleteById(int id) {
		whdgoldeneggrecordDao.deleteById(id);
	}
	
	public void update(Whdgoldeneggrecord whdgoldeneggrecord) {
		whdgoldeneggrecordDao.update(whdgoldeneggrecord);
	}
	
	public List<Whdgoldeneggrecord> getWhdgoldeneggrecords() {
		return whdgoldeneggrecordDao.getWhdgoldeneggrecords();
	}
	
	public Whdgoldeneggrecord loadById(int id) {
		return whdgoldeneggrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdgoldeneggrecord mo where mo.publicaccount=? ";
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
		return whdgoldeneggrecordDao.getUniqueResult(queryString,p);
	}

	public List<Whdgoldeneggrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdgoldeneggrecord mo where mo.publicaccount=? ";
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
		return whdgoldeneggrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdgoldeneggrecord> getFrontWhdgoldeneggrecordsByPublicAccount(String paccount) {
		String queryString = "from Whdgoldeneggrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdgoldeneggrecordDao.getObjectsByCondition(queryString, p);
	}

}
