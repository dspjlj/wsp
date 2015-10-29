package com.jlj.dao.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.jlj.dao.IKeyresDao;
import com.jlj.model.Keyres;
@Component("keyresDao")
public class KeyresDaoImp implements IKeyresDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void save(Keyres keyres) {
		this.hibernateTemplate.save(keyres);
	}
	
	public void delete(Keyres keyres) {
		this.hibernateTemplate.delete(keyres);
	}

	public void deleteById(int id) {
		this.hibernateTemplate.delete(this.loadById(id));
	}
	
	public void update(Keyres keyres) {
		this.hibernateTemplate.update(keyres);
	}
	
	public void updateByHql(final String hql,final String[] paramNames,final Object[] values) {
		this.hibernateTemplate.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				for (int i = 0; i < paramNames.length; i++) {
					query.setParameter(paramNames[i], values[i]);
				}
				query.executeUpdate();
				return null;
			}
			
		});
	}
	
	public List<Keyres> getKeyress() {
		return this.hibernateTemplate.loadAll(Keyres.class);
	}
	
	public List<Keyres> queryList(String queryString) {
		return this.hibernateTemplate.find(queryString);
	}
	
	public List<Keyres> getObjectsByCondition(String queryString, Object[] p) {
		return this.hibernateTemplate.find(queryString,p);
	}
	
	public List<Keyres> queryList(String queryString, String[] paramNames,
			Object[] values)
	{
		List list =  this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list;
	}
	
	public List<Keyres> getObjectsByIdList(final String hql,final List<Integer> idList) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(hql);
				query.setParameterList("idList", idList);
				return query.list();
			}
			
		});
	}
	
	public List<Keyres> pageList(final String queryString,final Object[] p,final Integer page,
			final Integer size) {
		return this.hibernateTemplate.executeFind(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query=session.createQuery(queryString);
				if(p!=null&&p.length>0){
					for (int i = 0; i < p.length; i++) {
						query.setParameter(i, p[i]);
					}
				}
				if(page!=null&&page>0&&size!=null&&size>0){
					query.setFirstResult((page-1)*size).setMaxResults(size);
				}
				return query.list();
			}
			
		});
	}
	
	
	public int getUniqueResult(final String queryString,final Object[] p) {
		Session session=this.hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query= session.createQuery(queryString);
		if(p!=null&&p.length>0){
			for (int i = 0; i < p.length; i++) {
				query.setParameter(i, p[i]);
			}
		}
		Object obj=query.uniqueResult();
		return ((Long)obj).intValue();
			
	}
	
	public Keyres loadById(int id) {
		return (Keyres) this.hibernateTemplate.load(Keyres.class, id);
	}
	
	public Keyres queryByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		List list=this.hibernateTemplate.findByNamedParam(queryString, paramNames, values);
		return list.size()>0?(Keyres)list.get(0):null;
	}
	
	public boolean checkClientExistsWithName(String queryString, Object[] p) {
		List list =  this.hibernateTemplate.find(queryString,p);
		return list.size()>0 ? true : false;
	}

	public void deleteBatchByHql(final String queryString,final String ids) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query=session.createQuery(queryString);
				String[] ids2=ids.split(",");
				List<Integer> idsint=new ArrayList<Integer>();
				for (int i = 0; i < ids2.length; i++) {
					idsint.add(Integer.parseInt(ids2[i]));
				}
				if(idsint.size()==0){
					return null;
				}
				query.setParameterList("ids", idsint);
				query.executeUpdate();
				return null;
			}
			
		});
	}
}
