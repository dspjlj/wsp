package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IWgwmenuDao;
import com.jlj.model.Wgwmenu;
import com.jlj.service.IWgwmenuService;
@Component("wgwmenuService")
public class WgwmenuServiceImp implements IWgwmenuService {
	private IWgwmenuDao wgwmenuDao;
	public IWgwmenuDao getWgwmenuDao() {
		return wgwmenuDao;
	}
	@Resource
	public void setWgwmenuDao(IWgwmenuDao wgwmenuDao) {
		this.wgwmenuDao = wgwmenuDao;
	}

	public void add(Wgwmenu wgwmenu) throws Exception {
		wgwmenuDao.save(wgwmenu);
	}

	public void delete(Wgwmenu wgwmenu) {
		wgwmenuDao.delete(wgwmenu);
	}

	public void deleteById(int id) {
		wgwmenuDao.deleteById(id);
	}
	
	public void update(Wgwmenu wgwmenu) {
		wgwmenuDao.update(wgwmenu);
	}
	
	public List<Wgwmenu> getWgwmenus() {
		return wgwmenuDao.getWgwmenus();
	}
	
	public Wgwmenu loadById(int id) {
		return wgwmenuDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Wgwmenu mo where mo.publicaccount=? ";
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
		return wgwmenuDao.getUniqueResult(queryString,p);
	}

	public List<Wgwmenu> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Wgwmenu mo where mo.publicaccount=? ";
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
		return wgwmenuDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Wgwmenu> getFrontWgwmenusByPublicAccount(String paccount) {
		String queryString = "from Wgwmenu mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return wgwmenuDao.getObjectsByCondition(queryString, p);
	}
	
	//根据公众号查找微官网导航菜单
	public Wgwmenu queryWgwmenuByPublicAccount(String paccount) {
		String queryString = "from Wgwmenu mo where mo.publicaccount=:paccount ";
		String[] paramNames = new String[]{"paccount"};
		Object[] values = new Object[]{paccount};
		return wgwmenuDao.queryByNamedParam(queryString, paramNames, values);
	}
	public Wgwmenu queryWgwmenuByWgwId(int wgwid) {
		String queryString = "from Wgwmenu mo where mo.wgw.id=:wgwid ";
		String[] paramNames = new String[]{"wgwid"};
		Object[] values = new Object[]{wgwid};
		return wgwmenuDao.queryByNamedParam(queryString, paramNames, values);
	}

}
