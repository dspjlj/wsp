package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWhymemberDao;
import com.jlj.model.Whymember;
import com.jlj.service.IWhymemberService;
@Component("whymemberService")
public class WhymemberServiceImp implements IWhymemberService {
	private IWhymemberDao whymemberDao;
	public IWhymemberDao getWhymemberDao() {
		return whymemberDao;
	}
	@Resource
	public void setWhymemberDao(IWhymemberDao whymemberDao) {
		this.whymemberDao = whymemberDao;
	}

	public void add(Whymember whymember) throws Exception {
		whymemberDao.save(whymember);
	}

	public void delete(Whymember whymember) {
		whymemberDao.delete(whymember);
	}

	public void deleteById(int id) {
		whymemberDao.deleteById(id);
	}
	
	public void update(Whymember whymember) {
		whymemberDao.update(whymember);
	}
	
	public List<Whymember> getWhymembers() {
		return whymemberDao.getWhymembers();
	}
	
	public Whymember loadById(int id) {
		return whymemberDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Whymember mo where mo.publicaccount=? ";
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
		return whymemberDao.getUniqueResult(queryString,p);
	}

	public List<Whymember> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Whymember mo where mo.publicaccount=? ";
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
		return whymemberDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Whymember> getFrontWhymembersByPublicAccount(String paccount) {
		String queryString = "from Whymember mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return whymemberDao.getObjectsByCondition(queryString, p);
	}

}
