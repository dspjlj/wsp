package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdbigwheelrecordDao;
import com.jlj.model.Whdbigwheelrecord;
import com.jlj.service.IWhdbigwheelrecordService;
@Component("whdbigwheelrecordService")
public class WhdbigwheelrecordServiceImp implements IWhdbigwheelrecordService {
	private IWhdbigwheelrecordDao whdbigwheelrecordDao;
	public IWhdbigwheelrecordDao getWhdbigwheelrecordDao() {
		return whdbigwheelrecordDao;
	}
	@Resource
	public void setWhdbigwheelrecordDao(IWhdbigwheelrecordDao whdbigwheelrecordDao) {
		this.whdbigwheelrecordDao = whdbigwheelrecordDao;
	}

	public void add(Whdbigwheelrecord whdbigwheelrecord) throws Exception {
		whdbigwheelrecordDao.save(whdbigwheelrecord);
	}

	public void delete(Whdbigwheelrecord whdbigwheelrecord) {
		whdbigwheelrecordDao.delete(whdbigwheelrecord);
	}

	public void deleteById(int id) {
		whdbigwheelrecordDao.deleteById(id);
	}
	
	public void update(Whdbigwheelrecord whdbigwheelrecord) {
		whdbigwheelrecordDao.update(whdbigwheelrecord);
	}
	
	public List<Whdbigwheelrecord> getWhdbigwheelrecords() {
		return whdbigwheelrecordDao.getWhdbigwheelrecords();
	}
	
	public Whdbigwheelrecord loadById(int id) {
		return whdbigwheelrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdbigwheelrecord mo where mo.publicaccount=? ";
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
		return whdbigwheelrecordDao.getUniqueResult(queryString,p);
	}

	public List<Whdbigwheelrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdbigwheelrecord mo where mo.publicaccount=? ";
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
		return whdbigwheelrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdbigwheelrecord> getFrontWhdbigwheelrecordsByPublicAccount(String paccount) {
		String queryString = "from Whdbigwheelrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdbigwheelrecordDao.getObjectsByCondition(queryString, p);
	}

}
