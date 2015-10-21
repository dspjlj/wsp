package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWlyblackDao;
import com.jlj.model.Wlyblack;
import com.jlj.service.IWlyblackService;
@Component("wlyblackService")
public class WlyblackServiceImp implements IWlyblackService {
	private IWlyblackDao wlyblackDao;
	public IWlyblackDao getWlyblackDao() {
		return wlyblackDao;
	}
	@Resource
	public void setWlyblackDao(IWlyblackDao wlyblackDao) {
		this.wlyblackDao = wlyblackDao;
	}

	public void add(Wlyblack wlyblack) throws Exception {
		wlyblackDao.save(wlyblack);
	}

	public void delete(Wlyblack wlyblack) {
		wlyblackDao.delete(wlyblack);
	}

	public void deleteById(int id) {
		wlyblackDao.deleteById(id);
	}
	
	public void update(Wlyblack wlyblack) {
		wlyblackDao.update(wlyblack);
	}
	
	public List<Wlyblack> getWlyblacks() {
		return wlyblackDao.getWlyblacks();
	}
	
	public Wlyblack loadById(int id) {
		return wlyblackDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wlyblack mo where mo.publicaccount=? ";
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
		return wlyblackDao.getUniqueResult(queryString,p);
	}

	public List<Wlyblack> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wlyblack mo where mo.publicaccount=? ";
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
		return wlyblackDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wlyblack> getFrontWlyblacksByPublicAccount(String paccount) {
		String queryString = "from Wlyblack mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wlyblackDao.getObjectsByCondition(queryString, p);
	}

}
