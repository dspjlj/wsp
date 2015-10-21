package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWlybookDao;
import com.jlj.model.Wlybook;
import com.jlj.service.IWlybookService;
@Component("wlybookService")
public class WlybookServiceImp implements IWlybookService {
	private IWlybookDao wlybookDao;
	public IWlybookDao getWlybookDao() {
		return wlybookDao;
	}
	@Resource
	public void setWlybookDao(IWlybookDao wlybookDao) {
		this.wlybookDao = wlybookDao;
	}

	public void add(Wlybook wlybook) throws Exception {
		wlybookDao.save(wlybook);
	}

	public void delete(Wlybook wlybook) {
		wlybookDao.delete(wlybook);
	}

	public void deleteById(int id) {
		wlybookDao.deleteById(id);
	}
	
	public void update(Wlybook wlybook) {
		wlybookDao.update(wlybook);
	}
	
	public List<Wlybook> getWlybooks() {
		return wlybookDao.getWlybooks();
	}
	
	public Wlybook loadById(int id) {
		return wlybookDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wlybook mo where mo.publicaccount=? ";
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
		return wlybookDao.getUniqueResult(queryString,p);
	}

	public List<Wlybook> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wlybook mo where mo.publicaccount=? ";
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
		return wlybookDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wlybook> getFrontWlybooksByPublicAccount(String paccount) {
		String queryString = "from Wlybook mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wlybookDao.getObjectsByCondition(queryString, p);
	}

}
