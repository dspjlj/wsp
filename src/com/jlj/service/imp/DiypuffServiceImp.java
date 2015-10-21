package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IDiypuffDao;
import com.jlj.model.Diypuff;
import com.jlj.service.IDiypuffService;
@Component("diypuffService")
public class DiypuffServiceImp implements IDiypuffService {
	private IDiypuffDao diypuffDao;
	public IDiypuffDao getDiypuffDao() {
		return diypuffDao;
	}
	@Resource
	public void setDiypuffDao(IDiypuffDao diypuffDao) {
		this.diypuffDao = diypuffDao;
	}

	public void add(Diypuff diypuff) throws Exception {
		diypuffDao.save(diypuff);
	}

	public void delete(Diypuff diypuff) {
		diypuffDao.delete(diypuff);
	}

	public void deleteById(int id) {
		diypuffDao.deleteById(id);
	}
	
	public void update(Diypuff diypuff) {
		diypuffDao.update(diypuff);
	}
	
	public List<Diypuff> getDiypuffs() {
		return diypuffDao.getDiypuffs();
	}
	
	public Diypuff loadById(int id) {
		return diypuffDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Diypuff mo where mo.publicaccount=? ";
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
		return diypuffDao.getUniqueResult(queryString,p);
	}

	public List<Diypuff> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Diypuff mo where mo.publicaccount=? ";
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
		return diypuffDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Diypuff> getFrontDiypuffsByPublicAccount(String paccount) {
		String queryString = "from Diypuff mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return diypuffDao.getObjectsByCondition(queryString, p);
	}

}
