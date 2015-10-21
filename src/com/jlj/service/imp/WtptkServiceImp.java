package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWtptkDao;
import com.jlj.model.Wtptk;
import com.jlj.service.IWtptkService;
@Component("wtptkService")
public class WtptkServiceImp implements IWtptkService {
	private IWtptkDao wtptkDao;
	public IWtptkDao getWtptkDao() {
		return wtptkDao;
	}
	@Resource
	public void setWtptkDao(IWtptkDao wtptkDao) {
		this.wtptkDao = wtptkDao;
	}

	public void add(Wtptk wtptk) throws Exception {
		wtptkDao.save(wtptk);
	}

	public void delete(Wtptk wtptk) {
		wtptkDao.delete(wtptk);
	}

	public void deleteById(int id) {
		wtptkDao.deleteById(id);
	}
	
	public void update(Wtptk wtptk) {
		wtptkDao.update(wtptk);
	}
	
	public List<Wtptk> getWtptks() {
		return wtptkDao.getWtptks();
	}
	
	public Wtptk loadById(int id) {
		return wtptkDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wtptk mo where mo.publicaccount=? ";
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
		return wtptkDao.getUniqueResult(queryString,p);
	}

	public List<Wtptk> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wtptk mo where mo.publicaccount=? ";
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
		return wtptkDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wtptk> getFrontWtptksByPublicAccount(String paccount) {
		String queryString = "from Wtptk mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wtptkDao.getObjectsByCondition(queryString, p);
	}

}
