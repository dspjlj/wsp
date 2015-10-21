package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWtpDao;
import com.jlj.model.Wtp;
import com.jlj.service.IWtpService;
@Component("wtpService")
public class WtpServiceImp implements IWtpService {
	private IWtpDao wtpDao;
	public IWtpDao getWtpDao() {
		return wtpDao;
	}
	@Resource
	public void setWtpDao(IWtpDao wtpDao) {
		this.wtpDao = wtpDao;
	}

	public void add(Wtp wtp) throws Exception {
		wtpDao.save(wtp);
	}

	public void delete(Wtp wtp) {
		wtpDao.delete(wtp);
	}

	public void deleteById(int id) {
		wtpDao.deleteById(id);
	}
	
	public void update(Wtp wtp) {
		wtpDao.update(wtp);
	}
	
	public List<Wtp> getWtps() {
		return wtpDao.getWtps();
	}
	
	public Wtp loadById(int id) {
		return wtpDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wtp mo where mo.publicaccount=? ";
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
		return wtpDao.getUniqueResult(queryString,p);
	}

	public List<Wtp> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wtp mo where mo.publicaccount=? ";
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
		return wtpDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wtp> getFrontWtpsByPublicAccount(String paccount) {
		String queryString = "from Wtp mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wtpDao.getObjectsByCondition(queryString, p);
	}

}
