package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdcouponDao;
import com.jlj.model.Whdcoupon;
import com.jlj.service.IWhdcouponService;
@Component("whdcouponService")
public class WhdcouponServiceImp implements IWhdcouponService {
	private IWhdcouponDao whdcouponDao;
	public IWhdcouponDao getWhdcouponDao() {
		return whdcouponDao;
	}
	@Resource
	public void setWhdcouponDao(IWhdcouponDao whdcouponDao) {
		this.whdcouponDao = whdcouponDao;
	}

	public void add(Whdcoupon whdcoupon) throws Exception {
		whdcouponDao.save(whdcoupon);
	}

	public void delete(Whdcoupon whdcoupon) {
		whdcouponDao.delete(whdcoupon);
	}

	public void deleteById(int id) {
		whdcouponDao.deleteById(id);
	}
	
	public void update(Whdcoupon whdcoupon) {
		whdcouponDao.update(whdcoupon);
	}
	
	public List<Whdcoupon> getWhdcoupons() {
		return whdcouponDao.getWhdcoupons();
	}
	
	public Whdcoupon loadById(int id) {
		return whdcouponDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdcoupon mo where mo.publicaccount=? ";
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
		return whdcouponDao.getUniqueResult(queryString,p);
	}

	public List<Whdcoupon> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdcoupon mo where mo.publicaccount=? ";
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
		return whdcouponDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdcoupon> getFrontWhdcouponsByPublicAccount(String paccount) {
		String queryString = "from Whdcoupon mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdcouponDao.getObjectsByCondition(queryString, p);
	}

}
