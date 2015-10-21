package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdbigwheelDao;
import com.jlj.model.Whdbigwheel;
import com.jlj.service.IWhdbigwheelService;
@Component("whdbigwheelService")
public class WhdbigwheelServiceImp implements IWhdbigwheelService {
	private IWhdbigwheelDao whdbigwheelDao;
	public IWhdbigwheelDao getWhdbigwheelDao() {
		return whdbigwheelDao;
	}
	@Resource
	public void setWhdbigwheelDao(IWhdbigwheelDao whdbigwheelDao) {
		this.whdbigwheelDao = whdbigwheelDao;
	}

	public void add(Whdbigwheel whdbigwheel) throws Exception {
		whdbigwheelDao.save(whdbigwheel);
	}

	public void delete(Whdbigwheel whdbigwheel) {
		whdbigwheelDao.delete(whdbigwheel);
	}

	public void deleteById(int id) {
		whdbigwheelDao.deleteById(id);
	}
	
	public void update(Whdbigwheel whdbigwheel) {
		whdbigwheelDao.update(whdbigwheel);
	}
	
	public List<Whdbigwheel> getWhdbigwheels() {
		return whdbigwheelDao.getWhdbigwheels();
	}
	
	public Whdbigwheel loadById(int id) {
		return whdbigwheelDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdbigwheel mo where mo.publicaccount=? ";
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
		return whdbigwheelDao.getUniqueResult(queryString,p);
	}

	public List<Whdbigwheel> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdbigwheel mo where mo.publicaccount=? ";
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
		return whdbigwheelDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdbigwheel> getFrontWhdbigwheelsByPublicAccount(String paccount) {
		String queryString = "from Whdbigwheel mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdbigwheelDao.getObjectsByCondition(queryString, p);
	}

}
