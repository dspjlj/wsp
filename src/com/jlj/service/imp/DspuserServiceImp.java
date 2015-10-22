package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IDspuserDao;
import com.jlj.model.Dspuser;
import com.jlj.service.IDspuserService;
@Component("dspuserService")
public class DspuserServiceImp implements IDspuserService {
	private IDspuserDao dspuserDao;
	public IDspuserDao getDspuserDao() {
		return dspuserDao;
	}
	@Resource
	public void setDspuserDao(IDspuserDao dspuserDao) {
		this.dspuserDao = dspuserDao;
	}

	public void add(Dspuser dspuser) throws Exception {
		dspuserDao.save(dspuser);
	}

	public void delete(Dspuser dspuser) {
		dspuserDao.delete(dspuser);
	}

	public void deleteById(int id) {
		dspuserDao.deleteById(id);
	}
	
	public void update(Dspuser dspuser) {
		dspuserDao.update(dspuser);
	}
	
	public List<Dspuser> getDspusers() {
		return dspuserDao.getDspusers();
	}
	
	public Dspuser loadById(int id) {
		return dspuserDao.loadById(id);
	}

	//此三个方法-查询列表================================start
	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int pid) {
		String queryString = "select count(*) from Dspuser mo where mo.upuser=? ";
		Object[] p = new Object[]{pid};
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//条件1
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{pid,'%'+convalue+'%'};
		}
		return dspuserDao.getUniqueResult(queryString,p);
	}

	public List<Dspuser> queryList(int con, String convalue, int pid,
		int page, int size) {
		String queryString = "from Dspuser mo where mo.upuser=? ";
		Object[] p = new Object[]{pid};
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//条件1
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{pid,'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return dspuserDao.pageList(queryString,p,page,size);
	}
	//此三个方法-查询列表================================end
	
	
	//登录-检查该用户是否存在
	public Dspuser userlogin(String username, String password) {
		String queryString="from Dspuser mo where mo.username=:username and mo.password=:password";
		String[] paramNames=new String[]{"username","password"};
		Object[] values=new Object[]{username,password};
		return dspuserDao.queryByNamedParam(queryString,paramNames,values);
	}

	//修改个人信息
	public void updateBaseInfoById(String phone, String qq, String email, int id) {
		String hql="update Dspuser mo set mo.phone = :phone,mo.qq = :qq,mo.email = :email where mo.id=:id";
		String[] paramNames=new String[]{"phone","qq","email","id"};
		Object[] values=new Object[]{phone,qq,email,id};
		dspuserDao.updateByHql(hql,paramNames,values);
		
	}
	
	//修改个人密码
	public void updatePwd(String newpwd, int id) {
		String hql="update Dspuser mo set mo.password = :newpwd where mo.id=:id";
		String[] paramNames=new String[]{"newpwd","id"};
		Object[] values=new Object[]{newpwd,id};
		dspuserDao.updateByHql(hql,paramNames,values);
	}
	//查询管理员的用户列表======================start
	public int getAllTotalCount(int con, String convalue) {
		String queryString = "select count(*) from Dspuser mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//条件1
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		return dspuserDao.getUniqueResult(queryString,p);
	}
	public List<Dspuser> queryAllList(int con, String convalue, int page,
			int size) {
		String queryString = "from Dspuser mo where 1=1 ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//条件1
			if(con==1){
				queryString += " and mo.name like ? "; 
			}
			p = new Object[]{'%'+convalue+'%'};
		}
		queryString += " order by mo.id desc ";
		return dspuserDao.pageList(queryString,p,page,size);
	}
	//查询管理员的用户列表======================end
	
	//修改冻结状态
	public void updateFreezeStatusById(int status, int id) {
		String hql="update Dspuser mo set mo.ison = :status where mo.id=:id";
		String[] paramNames=new String[]{"status","id"};
		Object[] values=new Object[]{status,id};
		dspuserDao.updateByHql(hql,paramNames,values);
		
	}
}
