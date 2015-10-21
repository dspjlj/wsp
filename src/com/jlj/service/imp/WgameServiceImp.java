package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWgameDao;
import com.jlj.model.Wgame;
import com.jlj.service.IWgameService;
@Component("wgameService")
public class WgameServiceImp implements IWgameService {
	private IWgameDao wgameDao;
	public IWgameDao getWgameDao() {
		return wgameDao;
	}
	@Resource
	public void setWgameDao(IWgameDao wgameDao) {
		this.wgameDao = wgameDao;
	}

	public void add(Wgame wgame) throws Exception {
		wgameDao.save(wgame);
	}

	public void delete(Wgame wgame) {
		wgameDao.delete(wgame);
	}

	public void deleteById(int id) {
		wgameDao.deleteById(id);
	}
	
	public void update(Wgame wgame) {
		wgameDao.update(wgame);
	}
	
	public List<Wgame> getWgames() {
		return wgameDao.getWgames();
	}
	
	public Wgame loadById(int id) {
		return wgameDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wgame mo where mo.publicaccount=? ";
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
		return wgameDao.getUniqueResult(queryString,p);
	}

	public List<Wgame> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wgame mo where mo.publicaccount=? ";
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
		return wgameDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wgame> getFrontWgamesByPublicAccount(String paccount) {
		String queryString = "from Wgame mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wgameDao.getObjectsByCondition(queryString, p);
	}

}
