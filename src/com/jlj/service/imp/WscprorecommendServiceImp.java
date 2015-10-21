package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscprorecommendDao;
import com.jlj.model.Wscprorecommend;
import com.jlj.service.IWscprorecommendService;
@Component("wscprorecommendService")
public class WscprorecommendServiceImp implements IWscprorecommendService {
	private IWscprorecommendDao wscprorecommendDao;
	public IWscprorecommendDao getWscprorecommendDao() {
		return wscprorecommendDao;
	}
	@Resource
	public void setWscprorecommendDao(IWscprorecommendDao wscprorecommendDao) {
		this.wscprorecommendDao = wscprorecommendDao;
	}

	public void add(Wscprorecommend wscprorecommend) throws Exception {
		wscprorecommendDao.save(wscprorecommend);
	}

	public void delete(Wscprorecommend wscprorecommend) {
		wscprorecommendDao.delete(wscprorecommend);
	}

	public void deleteById(int id) {
		wscprorecommendDao.deleteById(id);
	}
	
	public void update(Wscprorecommend wscprorecommend) {
		wscprorecommendDao.update(wscprorecommend);
	}
	
	public List<Wscprorecommend> getWscprorecommends() {
		return wscprorecommendDao.getWscprorecommends();
	}
	
	public Wscprorecommend loadById(int id) {
		return wscprorecommendDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscprorecommend mo where mo.publicaccount=? ";
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
		return wscprorecommendDao.getUniqueResult(queryString,p);
	}

	public List<Wscprorecommend> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscprorecommend mo where mo.publicaccount=? ";
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
		return wscprorecommendDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscprorecommend> getFrontWscprorecommendsByPublicAccount(String paccount) {
		String queryString = "from Wscprorecommend mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscprorecommendDao.getObjectsByCondition(queryString, p);
	}

}
