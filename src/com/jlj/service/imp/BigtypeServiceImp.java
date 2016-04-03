package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IBigtypeDao;
import com.jlj.model.Bigtype;
import com.jlj.service.IBigtypeService;
@Component("bigtypeService")
public class BigtypeServiceImp implements IBigtypeService{
	private IBigtypeDao bigtypeDao;
	public IBigtypeDao getBigtypeDao() {
		return bigtypeDao;
	}
	@Resource
	public void setBigtypeDao(IBigtypeDao bigtypeDao) {
		this.bigtypeDao = bigtypeDao;
	}

	public void add(Bigtype bigtype) throws Exception {
		bigtypeDao.save(bigtype);
	}

	public void delete(Bigtype bigtype) {
		bigtypeDao.delete(bigtype);
	}

	public void deleteById(int id) {
		bigtypeDao.deleteById(id);
	}
	
	public void update(Bigtype bigtype) {
		bigtypeDao.update(bigtype);
	}
	
	public List<Bigtype> getBigtypes() {
		return bigtypeDao.getBigtypes();
	}
	
	public Bigtype loadById(int id) {
		return bigtypeDao.loadById(id);
	}

	public int getPageCount(int con, String convalue, int status, String publicaccount,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, publicaccount);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Bigtype mo where mo.publicaccount=? ";
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
		return bigtypeDao.getUniqueResult(queryString,p);
	}

	public List<Bigtype> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Bigtype mo where mo.publicaccount=? ";
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
		queryString += " order by mo.orderid asc ";
		return bigtypeDao.pageList(queryString,p,page,size);
	}
	
	public List<Bigtype> getBigtypesByPublicAccount(String paccount) {
		String queryString = "from Bigtype mo where mo.publicaccount = ? and mo.islinkonly = 0 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	
	public List<Bigtype> getFrontBigtypesByPublicAccount(String paccount) {
		String queryString = "from Bigtype mo where mo.publicaccount = ? and mo.isshow = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	
	//后台管理大类别==================================================start
	public int getPageCount(int totalCount, int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}
	public int getTotalCount(String paccount) {
		String queryString = "select count(*) from Bigtype mo where mo.publicaccount=? and mo.bigtype.id is null ";
		Object[] p = new Object[]{paccount};
		return bigtypeDao.getUniqueResult(queryString,p);
	}
	public List<Bigtype> queryList(String paccount, int page, int size) {
		String queryString = "from Bigtype mo where mo.publicaccount=? and mo.bigtype.id is null order by mo.orderid asc  ";
		Object[] p = new Object[]{paccount};
		return bigtypeDao.pageList(queryString,p,page,size);
	}
	//后台管理大类别==================================================end
	
	//子类别管理==================================================start
	public int getTotalCount(int pid, String paccount) {
		String queryString = "select count(*) from Bigtype mo where mo.publicaccount=? and mo.bigtype.id=? ";
		Object[] p = new Object[]{paccount,pid};
		return bigtypeDao.getUniqueResult(queryString,p);
	}
	public List<Bigtype> queryList(int pid, String paccount, int page, int size) {
		String queryString = "from Bigtype mo where mo.publicaccount=? and mo.bigtype.id=? order by mo.orderid asc  ";
		Object[] p = new Object[]{paccount,pid};
		return bigtypeDao.pageList(queryString,p,page,size);
	}
	//子类别管理==================================================end
	
	//根据条件查询可用子类别-for添加文章
	public List<Bigtype> getBigtypesBycondition(int ison, int ttype,
			int hastype, String paccount) {
		String queryString = "from Bigtype mo where mo.publicaccount = ? and mo.ison = ? and mo.ttype = ? and mo.isend = ? order by mo.orderid asc ";
		Object[] p= new Object[]{paccount,ison,ttype,hastype};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	//根据条件查询可用子类别-for添加文章2
	public List<Bigtype> getBigtypesBycondition(int ison,
			int hastype, String paccount) {
		String queryString = "from Bigtype mo where mo.publicaccount = ? and mo.ison = ? and (mo.ttype = 0 or mo.ttype = 1) and mo.isend = ? order by mo.orderid asc ";
		Object[] p= new Object[]{paccount,ison,hastype};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	
	//前台查询===================================================start
	public List<Bigtype> queryIndexBigtypesByWgwId(int wgwid) {
		String queryString = "from Bigtype mo where mo.wgw.id = ? and mo.ison = 1 and mo.isshow = 1 and mo.bigtype.id is null order by mo.orderid asc ";
		Object[] p= new Object[]{wgwid};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	public List<Bigtype> querySonBigtypesByParentBigtypeId(int bigtypeid) {
		String queryString = "from Bigtype mo where mo.ison = 1 and mo.bigtype.id =? order by mo.orderid asc ";
		Object[] p= new Object[]{bigtypeid};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	/**
	 * 文章页展示分类
	 * 是否启用ison=1
	 * 是否显示
	 * 是首页类别ttype=0
	 */
	public List<Bigtype> queryFrontBigtypesByCondition(String frontpa) {
		String queryString = "from Bigtype mo where mo.ison = 1 and mo.ttype = 0 and mo.publicaccount =? order by mo.orderid asc ";
		Object[] p= new Object[]{frontpa};
		return bigtypeDao.getObjectsByCondition(queryString, p);
	}
	
	
}
