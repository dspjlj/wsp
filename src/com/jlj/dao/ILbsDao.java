package com.jlj.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.jlj.model.Lbs;

public interface ILbsDao {

	public abstract HibernateTemplate getHibernateTemplate();

	@Resource
	public abstract void setHibernateTemplate(
			HibernateTemplate hibernateTemplate);

	//保存一条记录
	public abstract void save(Lbs lbs);

	//删除一条记录
	public abstract void delete(Lbs lbs);

	//根据ID删除一条记录
	public abstract void deleteById(int id);

	//修改一条记录
	public abstract void update(Lbs lbs);

	//根据hql语句、条件、条件值修改某些记录
	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	//获得所有记录
	public abstract List<Lbs> getLbss();

	//根据hql语句来查询所有记录
	public abstract List<Lbs> queryList(String queryString);

	//根据hql、条件值查询某些记录
	public abstract List<Lbs> getObjectsByCondition(String queryString,
			Object[] p);

	//根据hql语句、条件、条件值查询某些记录
	public abstract List<Lbs> queryList(String queryString,
			String[] paramNames, Object[] values);

	//根据hql、id列表查询某些记录
	public abstract List<Lbs> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	//根据hql语句、条件值、分页查询某些记录
	public abstract List<Lbs> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	//根据hql、条件值获得一个唯一值
	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	//根据id查询一条记录
	public abstract Lbs loadById(int id);

	//根据hql语句、条件、值来查询一条记录
	public abstract Lbs queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	//根据hql语句、条件值来查询是否存在该记录
	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}