package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhkDao;
import com.jlj.model.Whk;
import com.jlj.service.IWhkService;
@Component("whkService")
public class WhkServiceImp implements IWhkService {
	private IWhkDao whkDao;
	public IWhkDao getWhkDao() {
		return whkDao;
	}
	@Resource
	public void setWhkDao(IWhkDao whkDao) {
		this.whkDao = whkDao;
	}

	public void add(Whk whk) throws Exception {
		whkDao.save(whk);
	}

	public void delete(Whk whk) {
		whkDao.delete(whk);
	}

	public void deleteById(int id) {
		whkDao.deleteById(id);
	}
	
	public void update(Whk whk) {
		whkDao.update(whk);
	}
	
	public List<Whk> getWhks() {
		return whkDao.getWhks();
	}
	
	public Whk loadById(int id) {
		return whkDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whk mo where mo.publicaccount=? ";
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
		return whkDao.getUniqueResult(queryString,p);
	}

	public List<Whk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whk mo where mo.publicaccount=? ";
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
		return whkDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whk> getFrontWhksByPublicAccount(String paccount) {
		String queryString = "from Whk mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whkDao.getObjectsByCondition(queryString, p);
	}

}
