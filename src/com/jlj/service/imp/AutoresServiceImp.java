package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IAutoresDao;
import com.jlj.model.Autores;
import com.jlj.service.IAutoresService;
@Component("autoresService")
public class AutoresServiceImp implements IAutoresService {
	private IAutoresDao autoresDao;
	public IAutoresDao getAutoresDao() {
		return autoresDao;
	}
	@Resource
	public void setAutoresDao(IAutoresDao autoresDao) {
		this.autoresDao = autoresDao;
	}

	public void add(Autores autores) throws Exception {
		autoresDao.save(autores);
	}

	public void delete(Autores autores) {
		autoresDao.delete(autores);
	}

	public void deleteById(int id) {
		autoresDao.deleteById(id);
	}
	
	public void update(Autores autores) {
		autoresDao.update(autores);
	}
	
	public List<Autores> getAutoress() {
		return autoresDao.getAutoress();
	}
	
	public Autores loadById(int id) {
		return autoresDao.loadById(id);
	}

	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Autores mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return autoresDao.getUniqueResult(queryString,p);
	}

	public List<Autores> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Autores mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//大类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id desc ";
		return autoresDao.pageList(queryString,p,page,size);
	}

	public List<Autores> queryListByPublicAccount(String publicaccount) {
		String queryString = "from Autores mo where mo.publicaccount = ?";
		Object[] p = new Object[]{publicaccount};
		return autoresDao.getObjectsByCondition(queryString, p);
	}
	
	

}
