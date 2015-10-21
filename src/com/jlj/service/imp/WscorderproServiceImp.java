package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscorderproDao;
import com.jlj.model.Wscorderpro;
import com.jlj.service.IWscorderproService;
@Component("wscorderproService")
public class WscorderproServiceImp implements IWscorderproService {
	private IWscorderproDao wscorderproDao;
	public IWscorderproDao getWscorderproDao() {
		return wscorderproDao;
	}
	@Resource
	public void setWscorderproDao(IWscorderproDao wscorderproDao) {
		this.wscorderproDao = wscorderproDao;
	}

	public void add(Wscorderpro wscorderpro) throws Exception {
		wscorderproDao.save(wscorderpro);
	}

	public void delete(Wscorderpro wscorderpro) {
		wscorderproDao.delete(wscorderpro);
	}

	public void deleteById(int id) {
		wscorderproDao.deleteById(id);
	}
	
	public void update(Wscorderpro wscorderpro) {
		wscorderproDao.update(wscorderpro);
	}
	
	public List<Wscorderpro> getWscorderpros() {
		return wscorderproDao.getWscorderpros();
	}
	
	public Wscorderpro loadById(int id) {
		return wscorderproDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscorderpro mo where mo.publicaccount=? ";
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
		return wscorderproDao.getUniqueResult(queryString,p);
	}

	public List<Wscorderpro> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscorderpro mo where mo.publicaccount=? ";
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
		return wscorderproDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscorderpro> getFrontWscorderprosByPublicAccount(String paccount) {
		String queryString = "from Wscorderpro mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscorderproDao.getObjectsByCondition(queryString, p);
	}

}
