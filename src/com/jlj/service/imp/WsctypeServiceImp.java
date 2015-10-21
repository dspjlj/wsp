package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWsctypeDao;
import com.jlj.model.Wsctype;
import com.jlj.service.IWsctypeService;
@Component("wsctypeService")
public class WsctypeServiceImp implements IWsctypeService {
	private IWsctypeDao wsctypeDao;
	public IWsctypeDao getWsctypeDao() {
		return wsctypeDao;
	}
	@Resource
	public void setWsctypeDao(IWsctypeDao wsctypeDao) {
		this.wsctypeDao = wsctypeDao;
	}

	public void add(Wsctype wsctype) throws Exception {
		wsctypeDao.save(wsctype);
	}

	public void delete(Wsctype wsctype) {
		wsctypeDao.delete(wsctype);
	}

	public void deleteById(int id) {
		wsctypeDao.deleteById(id);
	}
	
	public void update(Wsctype wsctype) {
		wsctypeDao.update(wsctype);
	}
	
	public List<Wsctype> getWsctypes() {
		return wsctypeDao.getWsctypes();
	}
	
	public Wsctype loadById(int id) {
		return wsctypeDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wsctype mo where mo.publicaccount=? ";
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
		return wsctypeDao.getUniqueResult(queryString,p);
	}

	public List<Wsctype> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wsctype mo where mo.publicaccount=? ";
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
		return wsctypeDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wsctype> getFrontWsctypesByPublicAccount(String paccount) {
		String queryString = "from Wsctype mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wsctypeDao.getObjectsByCondition(queryString, p);
	}

}
