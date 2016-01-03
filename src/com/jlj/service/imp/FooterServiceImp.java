package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IFooterDao;
import com.jlj.model.Footer;
import com.jlj.service.IFooterService;
@Component("footerService")
public class FooterServiceImp implements IFooterService {
	private IFooterDao footerDao;
	public IFooterDao getFooterDao() {
		return footerDao;
	}
	@Resource
	public void setFooterDao(IFooterDao footerDao) {
		this.footerDao = footerDao;
	}

	public void add(Footer footer) throws Exception {
		footerDao.save(footer);
	}

	public void delete(Footer footer) {
		footerDao.delete(footer);
	}
	
	public void deleteById(int id) {
		footerDao.deleteById(id);
	}
	
	public void update(Footer footer) {
		footerDao.update(footer);
	}
	
	public List<Footer> getFooters() {
		return footerDao.getFooters();
	}
	
	public Footer loadById(int id) {
		return footerDao.loadById(id);
	}

	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Footer mo where mo.publicaccount=? ";
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
		return footerDao.getUniqueResult(queryString,p);
	}

	public List<Footer> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Footer mo where mo.publicaccount=? ";
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
		return footerDao.pageList(queryString,p,page,size);
	}
	public Footer queryByPublicaccount(String publicaccount) {
		// TODO Auto-generated method stub
		String queryString = "from Footer mo where mo.publicaccount=:publicaccount";
		String[] paramNames=new String[]{"publicaccount"};
		Object[] values = new Object[]{publicaccount};
		return footerDao.queryByNamedParam(queryString, paramNames, values);
	}
	//根据公众号查询底部版权设置
	public Footer queryFooterByPublicAccount(String paccount) {
		String queryString = "from Footer mo where mo.publicaccount=:paccount ";
		String[] paramNames = new String[]{"paccount"};
		Object[] values = new Object[]{paccount};
		return footerDao.queryByNamedParam(queryString, paramNames, values);
	}
	
	//前台-根据微官网id-查询底部版权设置
	public Footer queryFooterByWgwId(int wgwid) {
		String queryString = "from Footer mo where mo.wgw.id=:wgwid and mo.ison=1 ";
		String[] paramNames = new String[]{"wgwid"};
		Object[] values = new Object[]{wgwid};
		return footerDao.queryByNamedParam(queryString, paramNames, values);
	}

}
