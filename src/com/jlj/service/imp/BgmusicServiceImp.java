package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IBgmusicDao;
import com.jlj.model.Bgmusic;
import com.jlj.service.IBgmusicService;
@Component("bgmusicService")
public class BgmusicServiceImp implements IBgmusicService {
	private IBgmusicDao bgmusicDao;
	public IBgmusicDao getBgmusicDao() {
		return bgmusicDao;
	}
	@Resource
	public void setBgmusicDao(IBgmusicDao bgmusicDao) {
		this.bgmusicDao = bgmusicDao;
	}

	public void add(Bgmusic bgmusic) throws Exception {
		bgmusicDao.save(bgmusic);
	}

	public void delete(Bgmusic bgmusic) {
		bgmusicDao.delete(bgmusic);
	}

	public void deleteById(int id) {
		bgmusicDao.deleteById(id);
	}
	
	public void update(Bgmusic bgmusic) {
		bgmusicDao.update(bgmusic);
	}
	
	public List<Bgmusic> getBgmusics() {
		return bgmusicDao.getBgmusics();
	}
	
	public Bgmusic loadById(int id) {
		return bgmusicDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Bgmusic mo where mo.publicaccount=? ";
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
		return bgmusicDao.getUniqueResult(queryString,p);
	}

	public List<Bgmusic> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Bgmusic mo where mo.publicaccount=? ";
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
		return bgmusicDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Bgmusic> getFrontBgmusicsByPublicAccount(String paccount) {
		String queryString = "from Bgmusic mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return bgmusicDao.getObjectsByCondition(queryString, p);
	}
	
	//根据公众号查询背景音乐
	public Bgmusic queryBgmusicByPublicAccount(String paccount) {
		String queryString = "from Bgmusic mo where mo.publicaccount=:paccount ";
		String[] paramNames = new String[]{"paccount"};
		Object[] values = new Object[]{paccount};
		return bgmusicDao.queryByNamedParam(queryString, paramNames, values);
	}
	//前台-根据wgwid查询背景音乐
	public Bgmusic queryBgmusicByWgwId(int wgwid) {
		String queryString = "from Bgmusic mo where mo.wgw.id=:wgwid and mo.ison=1 ";
		String[] paramNames = new String[]{"wgwid"};
		Object[] values = new Object[]{wgwid};
		return bgmusicDao.queryByNamedParam(queryString, paramNames, values);
	}

}
