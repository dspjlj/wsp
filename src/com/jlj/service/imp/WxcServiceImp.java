package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWxcDao;
import com.jlj.model.Wxc;
import com.jlj.service.IWxcService;
@Component("wxcService")
public class WxcServiceImp implements IWxcService {
	private IWxcDao wxcDao;
	public IWxcDao getWxcDao() {
		return wxcDao;
	}
	@Resource
	public void setWxcDao(IWxcDao wxcDao) {
		this.wxcDao = wxcDao;
	}

	public void add(Wxc wxc) throws Exception {
		wxcDao.save(wxc);
	}

	public void delete(Wxc wxc) {
		wxcDao.delete(wxc);
	}

	public void deleteById(int id) {
		wxcDao.deleteById(id);
	}
	
	public void update(Wxc wxc) {
		wxcDao.update(wxc);
	}
	
	public List<Wxc> getWxcs() {
		return wxcDao.getWxcs();
	}
	
	public Wxc loadById(int id) {
		return wxcDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wxc mo where mo.publicaccount=? ";
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
		return wxcDao.getUniqueResult(queryString,p);
	}

	public List<Wxc> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wxc mo where mo.publicaccount=? ";
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
		return wxcDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wxc> getFrontWxcsByPublicAccount(String paccount) {
		String queryString = "from Wxc mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wxcDao.getObjectsByCondition(queryString, p);
	}

}
