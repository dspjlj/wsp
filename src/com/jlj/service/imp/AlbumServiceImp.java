package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IAlbumDao;
import com.jlj.model.Album;
import com.jlj.service.IAlbumService;
@Component("albumService")
public class AlbumServiceImp implements IAlbumService {
	private IAlbumDao albumDao;
	public IAlbumDao getAlbumDao() {
		return albumDao;
	}
	@Resource
	public void setAlbumDao(IAlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	public void add(Album album) throws Exception {
		albumDao.save(album);
	}

	public void delete(Album album) {
		albumDao.delete(album);
	}

	public void deleteById(int id) {
		albumDao.deleteById(id);
	}
	
	public void update(Album album) {
		albumDao.update(album);
	}
	
	public List<Album> getAlbums() {
		return albumDao.getAlbums();
	}
	
	public Album loadById(int id) {
		return albumDao.loadById(id);
	}

	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue, int status, String publicaccount) {
		String queryString = "select count(*) from Album mo where mo.publicaccount=? ";
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
		return albumDao.getUniqueResult(queryString,p);
	}

	public List<Album> queryList(int con, String convalue, int status,
			String publicaccount, int page, int size) {
		String queryString = "from Album mo where mo.publicaccount=? ";
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
		return albumDao.pageList(queryString,p,page,size);
	}
	
	
	public List<Album> getFrontAlbumsByPublicAccount(String paccount) {
		String queryString = "from Album mo where mo.publicaccount = ? and mo.ison = 1 order by mo.orderid asc ";
		Object[] p= new Object[]{paccount};
		return albumDao.getObjectsByCondition(queryString, p);
	}

}
