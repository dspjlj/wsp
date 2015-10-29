package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.ILbsDao;
import com.jlj.model.Lbs;
import com.jlj.service.ILbsService;
@Component("lbsService")
public class LbsServiceImp implements ILbsService {
	private ILbsDao lbsDao;
	public ILbsDao getLbsDao() {
		return lbsDao;
	}
	@Resource
	public void setLbsDao(ILbsDao lbsDao) {
		this.lbsDao = lbsDao;
	}

	public void add(Lbs lbs) throws Exception {
		lbsDao.save(lbs);
	}

	public void delete(Lbs lbs) {
		lbsDao.delete(lbs);
	}

	public void deleteById(int id) {
		lbsDao.deleteById(id);
	}
	
	public void update(Lbs lbs) {
		lbsDao.update(lbs);
	}
	
	public List<Lbs> getLbss() {
		return lbsDao.getLbss();
	}
	
	public Lbs loadById(int id) {
		return lbsDao.loadById(id);
	}
	//查询列表=============start
	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, String publicaccount) {
		String queryString = "select count(*) from Lbs mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//商家名称
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return lbsDao.getUniqueResult(queryString,p);
	}

	public List<Lbs> queryList(int con, String convalue, 
			String publicaccount, int page, int size) {
		String queryString = "from Lbs mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//商家名称
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id desc ";
		return lbsDao.pageList(queryString,p,page,size);
	}
	//查询列表=============end
	
	public List<Lbs> getFrontLbssByPublicAccount(String paccount) {
		String queryString = "from Lbs mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return lbsDao.getObjectsByCondition(queryString, p);
	}

}
