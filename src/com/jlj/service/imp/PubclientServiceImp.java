package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPubclientDao;
import com.jlj.model.Pubclient;
import com.jlj.service.IPubclientService;
@Component("pubclientService")
public class PubclientServiceImp implements IPubclientService{
	private IPubclientDao pubclientDao;
	public IPubclientDao getPubclientDao() {
		return pubclientDao;
	}
	@Resource
	public void setPubclientDao(IPubclientDao pubclientDao) {
		this.pubclientDao = pubclientDao;
	}

	public void add(Pubclient pubclient) throws Exception {
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
	
	public void updatePwd(String newpwd, Integer id) {
		String hql="update Pubclient mo set mo.password = :newpwd where mo.id=:id";
		String[] paramNames=new String[]{"newpwd","id"};
		Object[] values=new Object[]{newpwd,id};
		pubclientDao.updateByHql(hql,paramNames,values);
	}
	
	public List<Pubclient> getPubclients() {
		return pubclientDao.getPubclients();
	}
	
	public boolean exists(String username) throws Exception {
		String queryString="from Pubclient mo where mo.username=?";
		Object[] p=new Object[]{username};
		return pubclientDao.checkClientExistsWithName(queryString,p);
	}

	public Pubclient loadById(int id) {
		return pubclientDao.loadById(id);
	}

	public Pubclient userlogin(String username, String password) {
		String queryString="from Pubclient mo where mo.username=:username and mo.password=:password";
		String[] paramNames=new String[]{"username","password"};
		Object[] values=new Object[]{username,password};
		return pubclientDao.queryByNamedParam(queryString,paramNames,values);
	}
	
	public int getPageCount(int con, String convalue, int status, int pid,
			int size) {
		int totalCount=this.getTotalCount(con, convalue, status, pid);
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, int pid) {
		String queryString = "select count(*) from Pubclient mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//姓名、手机号码、公众号名称
			if(con==1){
				queryString += "and mo.realname like ? "; 
			}else if(con==2){
				queryString += "and mo.phone like ? ";
			}else if(con==3){
				queryString += "and mo.publicname like ? ";
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return pubclientDao.getUniqueResult(queryString,p);
	}

	public List<Pubclient> queryList(int con, String convalue, int status,
			int pid, int page, int size) {
		String queryString = "from Pubclient mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//姓名、手机号码、公众号名称
			if(con==1){
				queryString += "and mo.realname like ? "; 
			}else if(con==2){
				queryString += "and mo.phone like ? ";
			}else if(con==3){
				queryString += "and mo.publicname like ? ";
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return pubclientDao.pageList(queryString,p,page,size);
	}

	public List<Pubclient> queryList(int depid)
	{
		String queryString = "from Pubclient mo where mo.dep.id=:depid";
		String[] paramNames=new String[]{"depid"};
		Object[] values=new Object[]{depid};
		return pubclientDao.queryList(queryString,paramNames,values);
	}

	public List<Pubclient> queryList(int con, String convalue, int depid)
	{
		String queryString = "from Pubclient mo where mo.dep.id = ? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//姓名、部门、职位
			if(con==1){
				queryString += "and mo.name like ? "; 
			}else if(con==2){
				queryString += "and mo.job like ? ";
			}
			p = new Object[]{depid ,'%'+convalue+'%'};
		}
		else
		{
			p = new Object[]{depid};
		}
		return pubclientDao.getObjectsByCondition(queryString,p);
	}
	
	public Pubclient queryPubclientByFrontpa(String frontpa) {
		String queryString="from Pubclient mo where mo.publicaccount=:publicaccount ";
		String[] paramNames=new String[]{"publicaccount"};
		Object[] values=new Object[]{frontpa};
		return pubclientDao.queryByNamedParam(queryString,paramNames,values);
	}
	
	public void updateBaseInfoById(String phone, String qq, String email, int id) {
		String hql="update Pubclient mo set mo.phone = :phone,mo.qq = :qq,mo.email = :email where mo.id=:id";
		String[] paramNames=new String[]{"phone","qq","email","id"};
		Object[] values=new Object[]{phone,qq,email,id};
		pubclientDao.updateByHql(hql,paramNames,values);
		
	}
	
	

}
