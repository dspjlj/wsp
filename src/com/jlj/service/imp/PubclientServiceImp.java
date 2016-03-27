package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IDspuserDao;
import com.jlj.dao.IPubclientDao;
import com.jlj.model.Pubclient;
import com.jlj.service.IPubclientService;
@Component("pubclientService")
public class PubclientServiceImp implements IPubclientService{
	private IPubclientDao pubclientDao;
	private IDspuserDao dspuserDao;
	
	public IDspuserDao getDspuserDao() {
		return dspuserDao;
	}
	@Resource
	public void setDspuserDao(IDspuserDao dspuserDao) {
		this.dspuserDao = dspuserDao;
	}
	public IPubclientDao getPubclientDao() {
		return pubclientDao;
	}
	@Resource
	public void setPubclientDao(IPubclientDao pubclientDao) {
		this.pubclientDao = pubclientDao;
	}

	public void add(Pubclient pubclient) throws Exception {
		
		//新增保存时修改公众号配额-1
		int dspuserid = pubclient.getDspuser().getId();
		String hql = "update Dspuser mo set mo.pubnum=mo.pubnum-1 where mo.id=:dspuserid";
		String[] paramNames = new String[]{"dspuserid"};
		Object[] values = new Object[]{dspuserid};
		dspuserDao.updateByHql(hql, paramNames, values);
		
		pubclientDao.save(pubclient);
	}

	public void delete(Pubclient pubclient) {
		pubclientDao.delete(pubclient);
	}

	public void deleteById(int id) {
		pubclientDao.deleteById(id);
	}
	
	public void update(Pubclient pubclient) {
		pubclientDao.update(pubclient);
	}
	
	public List<Pubclient> getPubclients() {
		return pubclientDao.getPubclients();
	}
	
	public Pubclient loadById(int id) {
		return pubclientDao.loadById(id);
	}

	public Pubclient getById(int id) {
		return pubclientDao.getById(id);
	}
	
	public int getPageCount(int totalCount,
			int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	//查询用户的公众号列表======================start
	public int getTotalCount(int con, String convalue, int selfid) {
		String queryString = "select count(*) from Pubclient mo where mo.dspuser.id=?  ";
		Object[] p = new Object[]{selfid};
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//公众号名称
			if(con==1){
				queryString += "and mo.publicname like ? ";
			}
			p = new Object[]{selfid,'%'+convalue+'%'};
		}
		return pubclientDao.getUniqueResult(queryString,p);
	}

	public List<Pubclient> queryList(int con, String convalue, int selfid, int page, int size) {
		String queryString = "from Pubclient mo where mo.dspuser.id=? ";
		Object[] p = new Object[]{selfid};
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//公众号名称
			if(con==1){
				queryString += "and mo.publicname like ? ";
			}
			p = new Object[]{selfid,'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return pubclientDao.pageList(queryString,p,page,size);
	}
	//查询用户的公众号列表======================end
	
	public Pubclient queryPubclientByFrontpa(String frontpa) {
		String queryString="from Pubclient mo where mo.publicaccount=:publicaccount ";
		String[] paramNames=new String[]{"publicaccount"};
		Object[] values=new Object[]{frontpa};
		return pubclientDao.queryByNamedParam(queryString,paramNames,values);
	}
	
	//查询管理员的公众号列表======================start
	public int getAllTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Pubclient mo where 1=1  ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//公众号名称
			if(con==1){
				queryString += "and mo.publicname like ? ";
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return pubclientDao.getUniqueResult(queryString,p);
	}
	public List<Pubclient> queryAllList(int con, String convalue, int page,
			int size) {
		String queryString = "from Pubclient mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//公众号名称
			if(con==1){
				queryString += "and mo.publicname like ? ";
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return pubclientDao.pageList(queryString,p,page,size);
	}
	//查询管理员的公众号列表======================end
	
	//根据id修改appauth
	public void updateAppAuthById(String appid, String appsecret, int pubid) {
		String hql = "update Pubclient mo set mo.appid=:appid,mo.appsecret=:appsecret where mo.id=:pubid";
		String[] paramNames = new String[]{"appid","appsecret","pubid"};
		Object[] values = new Object[]{appid,appsecret,pubid};
		pubclientDao.updateByHql(hql, paramNames, values);
	}
	

}
