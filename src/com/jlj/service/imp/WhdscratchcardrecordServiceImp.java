package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdscratchcardrecordDao;
import com.jlj.model.Whdscratchcardrecord;
import com.jlj.service.IWhdscratchcardrecordService;
@Component("whdscratchcardrecordService")
public class WhdscratchcardrecordServiceImp implements IWhdscratchcardrecordService {
	private IWhdscratchcardrecordDao whdscratchcardrecordDao;
	public IWhdscratchcardrecordDao getWhdscratchcardrecordDao() {
		return whdscratchcardrecordDao;
	}
	@Resource
	public void setWhdscratchcardrecordDao(IWhdscratchcardrecordDao whdscratchcardrecordDao) {
		this.whdscratchcardrecordDao = whdscratchcardrecordDao;
	}

	public void add(Whdscratchcardrecord whdscratchcardrecord) throws Exception {
		whdscratchcardrecordDao.save(whdscratchcardrecord);
	}

	public void delete(Whdscratchcardrecord whdscratchcardrecord) {
		whdscratchcardrecordDao.delete(whdscratchcardrecord);
	}

	public void deleteById(int id) {
		whdscratchcardrecordDao.deleteById(id);
	}
	
	public void update(Whdscratchcardrecord whdscratchcardrecord) {
		whdscratchcardrecordDao.update(whdscratchcardrecord);
	}
	
	public List<Whdscratchcardrecord> getWhdscratchcardrecords() {
		return whdscratchcardrecordDao.getWhdscratchcardrecords();
	}
	
	public Whdscratchcardrecord loadById(int id) {
		return whdscratchcardrecordDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdscratchcardrecord mo where mo.publicaccount=? ";
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
		return whdscratchcardrecordDao.getUniqueResult(queryString,p);
	}

	public List<Whdscratchcardrecord> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdscratchcardrecord mo where mo.publicaccount=? ";
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
		return whdscratchcardrecordDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdscratchcardrecord> getFrontWhdscratchcardrecordsByPublicAccount(String paccount) {
		String queryString = "from Whdscratchcardrecord mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdscratchcardrecordDao.getObjectsByCondition(queryString, p);
	}

}
