package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhdscratchcardDao;
import com.jlj.model.Whdscratchcard;
import com.jlj.service.IWhdscratchcardService;
@Component("whdscratchcardService")
public class WhdscratchcardServiceImp implements IWhdscratchcardService {
	private IWhdscratchcardDao whdscratchcardDao;
	public IWhdscratchcardDao getWhdscratchcardDao() {
		return whdscratchcardDao;
	}
	@Resource
	public void setWhdscratchcardDao(IWhdscratchcardDao whdscratchcardDao) {
		this.whdscratchcardDao = whdscratchcardDao;
	}

	public void add(Whdscratchcard whdscratchcard) throws Exception {
		whdscratchcardDao.save(whdscratchcard);
	}

	public void delete(Whdscratchcard whdscratchcard) {
		whdscratchcardDao.delete(whdscratchcard);
	}

	public void deleteById(int id) {
		whdscratchcardDao.deleteById(id);
	}
	
	public void update(Whdscratchcard whdscratchcard) {
		whdscratchcardDao.update(whdscratchcard);
	}
	
	public List<Whdscratchcard> getWhdscratchcards() {
		return whdscratchcardDao.getWhdscratchcards();
	}
	
	public Whdscratchcard loadById(int id) {
		return whdscratchcardDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whdscratchcard mo where mo.publicaccount=? ";
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
		return whdscratchcardDao.getUniqueResult(queryString,p);
	}

	public List<Whdscratchcard> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whdscratchcard mo where mo.publicaccount=? ";
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
		return whdscratchcardDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whdscratchcard> getFrontWhdscratchcardsByPublicAccount(String paccount) {
		String queryString = "from Whdscratchcard mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whdscratchcardDao.getObjectsByCondition(queryString, p);
	}

}
