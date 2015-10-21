package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscprocommentDao;
import com.jlj.model.Wscprocomment;
import com.jlj.service.IWscprocommentService;
@Component("wscprocommentService")
public class WscprocommentServiceImp implements IWscprocommentService {
	private IWscprocommentDao wscprocommentDao;
	public IWscprocommentDao getWscprocommentDao() {
		return wscprocommentDao;
	}
	@Resource
	public void setWscprocommentDao(IWscprocommentDao wscprocommentDao) {
		this.wscprocommentDao = wscprocommentDao;
	}

	public void add(Wscprocomment wscprocomment) throws Exception {
		wscprocommentDao.save(wscprocomment);
	}

	public void delete(Wscprocomment wscprocomment) {
		wscprocommentDao.delete(wscprocomment);
	}

	public void deleteById(int id) {
		wscprocommentDao.deleteById(id);
	}
	
	public void update(Wscprocomment wscprocomment) {
		wscprocommentDao.update(wscprocomment);
	}
	
	public List<Wscprocomment> getWscprocomments() {
		return wscprocommentDao.getWscprocomments();
	}
	
	public Wscprocomment loadById(int id) {
		return wscprocommentDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscprocomment mo where mo.publicaccount=? ";
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
		return wscprocommentDao.getUniqueResult(queryString,p);
	}

	public List<Wscprocomment> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscprocomment mo where mo.publicaccount=? ";
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
		return wscprocommentDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscprocomment> getFrontWscprocommentsByPublicAccount(String paccount) {
		String queryString = "from Wscprocomment mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscprocommentDao.getObjectsByCondition(queryString, p);
	}

}
