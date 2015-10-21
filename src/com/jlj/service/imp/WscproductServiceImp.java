package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWscproductDao;
import com.jlj.model.Wscproduct;
import com.jlj.service.IWscproductService;
@Component("wscproductService")
public class WscproductServiceImp implements IWscproductService {
	private IWscproductDao wscproductDao;
	public IWscproductDao getWscproductDao() {
		return wscproductDao;
	}
	@Resource
	public void setWscproductDao(IWscproductDao wscproductDao) {
		this.wscproductDao = wscproductDao;
	}

	public void add(Wscproduct wscproduct) throws Exception {
		wscproductDao.save(wscproduct);
	}

	public void delete(Wscproduct wscproduct) {
		wscproductDao.delete(wscproduct);
	}

	public void deleteById(int id) {
		wscproductDao.deleteById(id);
	}
	
	public void update(Wscproduct wscproduct) {
		wscproductDao.update(wscproduct);
	}
	
	public List<Wscproduct> getWscproducts() {
		return wscproductDao.getWscproducts();
	}
	
	public Wscproduct loadById(int id) {
		return wscproductDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wscproduct mo where mo.publicaccount=? ";
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
		return wscproductDao.getUniqueResult(queryString,p);
	}

	public List<Wscproduct> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wscproduct mo where mo.publicaccount=? ";
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
		return wscproductDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wscproduct> getFrontWscproductsByPublicAccount(String paccount) {
		String queryString = "from Wscproduct mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wscproductDao.getObjectsByCondition(queryString, p);
	}

}
