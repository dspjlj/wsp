package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPagearticleDao;
import com.jlj.model.Pagearticle;
import com.jlj.service.IPagearticleService;
@Component("pagearticleService")
public class PagearticleServiceImp implements IPagearticleService{
	private IPagearticleDao pagearticleDao;
	public IPagearticleDao getPagearticleDao() {
		return pagearticleDao;
	}
	@Resource
	public void setPagearticleDao(IPagearticleDao pagearticleDao) {
		this.pagearticleDao = pagearticleDao;
	}

	public void add(Pagearticle pagearticle) throws Exception {
		pagearticleDao.save(pagearticle);
	}

	public void delete(Pagearticle pagearticle) {
		pagearticleDao.delete(pagearticle);
	}
	public void deleteById(int id) {
		pagearticleDao.deleteById(id);
	}
	
	public void update(Pagearticle pagearticle) {
		pagearticleDao.update(pagearticle);
	}
	
	public List<Pagearticle> getPagearticles() {
		return pagearticleDao.getPagearticles();
	}
	
	public Pagearticle loadById(int id) {
		return pagearticleDao.loadById(id);
	}
	//后台管理===================start
	public int getPageCount(int totalCount, int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Pagearticle mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//文章标题、子类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.bigtype.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return pagearticleDao.getUniqueResult(queryString,p);
	}
	
	public List<Pagearticle> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Pagearticle mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//文章标题、子类别名称
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.bigtype.name like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id desc ";
		return pagearticleDao.pageList(queryString,p,page,size);
	}
	//后台管理===================end
	
	public int getFrontPageCount(int stid, int size) {
		int totalCount=this.getFrontTotalCount(stid);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	public int getFrontTotalCount(int stid) {
		String queryString = "select count(*) from Pagearticle mo where mo.sontype.id=? ";
		Object[] p = new Object[]{stid};
		return pagearticleDao.getUniqueResult(queryString,p);
	}
	public List<Pagearticle> queryFrontList(int stid, int page, int size) {
		String queryString = "from Pagearticle mo where mo.sontype.id=? order by mo.id desc ";
		Object[] p = new Object[]{stid};
		return pagearticleDao.pageList(queryString,p,page,size);
	}
	public List<Pagearticle> queryFrontIndexList(String frontpa, int isshow, int page, int psize) {
		String queryString = "from Pagearticle mo where mo.isshow=? and mo.publicaccount=?  ";
		Object[] p = new Object[]{isshow,frontpa};
		return pagearticleDao.pageList(queryString,p,page,psize);
	}
	
	//前台-根据无子类的分类ID查询所有文章列表
	public List<Pagearticle> queryPagearticlesByEndBigtypeId(int bigtypeid) {
		String queryString = "from Pagearticle mo where mo.bigtype.id =? and mo.ison=1 order by mo.id desc ";
		Object[] p= new Object[]{bigtypeid};
		return pagearticleDao.getObjectsByCondition(queryString, p);
	}
	
	
	

}
