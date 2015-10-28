package com.jlj.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.jlj.dao.IPublickeyDao;
import com.jlj.model.Publickey;
import com.jlj.service.IPublickeyService;
@Component("publickeyService")
public class PublickeyServiceImp implements IPublickeyService{
	private IPublickeyDao publickeyDao;
	public IPublickeyDao getPublickeyDao() {
		return publickeyDao;
	}
	@Resource
	public void setPublickeyDao(IPublickeyDao publickeyDao) {
		this.publickeyDao = publickeyDao;
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPublickeyService#add(com.jlj.model.Publickey)
	 */
	public void add(Publickey publickey) throws Exception {
		publickeyDao.save(publickey);
	}

	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPublickeyService#delete(com.jlj.model.Publickey)
	 */
	public void delete(Publickey publickey) {
		publickeyDao.delete(publickey);
	}
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPublickeyService#deleteById(int)
	 */
	public void deleteById(int id) {
		publickeyDao.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPublickeyService#update(com.jlj.model.Publickey)
	 */
	public void update(Publickey publickey) {
		publickeyDao.update(publickey);
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPublickeyService#getPublickeys()
	 */
	public List<Publickey> getPublickeys() {
		return publickeyDao.getPublickeys();
	}
	
	/* (non-Javadoc)
	 * @see com.jlj.service.imp.IPublickeyService#loadById(int)
	 */
	public Publickey loadById(int id) {
		return publickeyDao.loadById(id);
	}

	//查询公众号关键字分类列表==============================start
	public int getPageCount(int totalCount,int size) {
		return totalCount%size==0?totalCount/size:(totalCount/size+1);
	}

	public int getTotalCount(int con, String convalue,  String publicaccount) {
		String queryString = "select count(*) from Publickey mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//类别名称
			if(con==1){
				queryString += "and mo.title like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		return publickeyDao.getUniqueResult(queryString,p);
	}

	public List<Publickey> queryList(int con, String convalue, String publicaccount, int page, int size) {
		String queryString = "from Publickey mo where mo.publicaccount=? ";
		Object[] p = null;
		if(con!=0&&convalue!=null&&!convalue.equals("")){
			//类别名称
			if(con==1){
				queryString += "and mo.title like ? "; 
			}
			p = new Object[]{publicaccount,'%'+convalue+'%'};
		}else{
			p = new Object[]{publicaccount};
		}
		queryString += " order by mo.id desc ";
		return publickeyDao.pageList(queryString,p,page,size);
	}
	//查询公众号关键字分类列表==============================end
	
	public List<Publickey> queryListByPublicAccount(String publicaccount) {
		String queryString = "from Publickey mo where mo.publicaccount = ?";
		Object[] p = new Object[]{publicaccount};
		return publickeyDao.getObjectsByCondition(queryString, p);
	}
	
	

}
