package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscscrimgDao;
import com.jlj.model.Wscscrimg;
import com.jlj.service.IWscscrimgService;
@Component("wscscrimgService")
public class WscscrimgServiceImp implements IWscscrimgService {
	private IWscscrimgDao wscscrimgDao;
	public IWscscrimgDao getWscscrimgDao() {
		return wscscrimgDao;
	}
	@Resource
	public void setWscscrimgDao(IWscscrimgDao wscscrimgDao) {
		this.wscscrimgDao = wscscrimgDao;
	}

	public void add(Wscscrimg wscscrimg) throws Exception {
		wscscrimgDao.save(wscscrimg);
	}

	public void delete(Wscscrimg wscscrimg) {
		wscscrimgDao.delete(wscscrimg);
	}

	public void deleteById(int id) {
		wscscrimgDao.deleteById(id);
	}
	
	public void update(Wscscrimg wscscrimg) {
		wscscrimgDao.update(wscscrimg);
	}
	
	public List<Wscscrimg> getWscscrimgs() {
		return wscscrimgDao.getWscscrimgs();
	}
	
	public Wscscrimg loadById(int id) {
		return wscscrimgDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscscrimg mo where mo.publicaccount=? ";
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
		return wscscrimgDao.getUniqueResult(queryString,p);
	}

	public List<Wscscrimg> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscscrimg mo where mo.publicaccount=? ";
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
		return wscscrimgDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscscrimg> getFrontWscscrimgsByPublicAccount(String paccount) {
		String queryString = "from Wscscrimg mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscscrimgDao.getObjectsByCondition(queryString, p);
	}

}
