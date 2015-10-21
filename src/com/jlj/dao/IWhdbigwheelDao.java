package com.jlj.dao;

import java.util.List;

import com.jlj.model.Whdbigwheel;

public interface IWhdbigwheelDao {

	//保存一条记录
	public abstract void save(Whdbigwheel whdbigwheel);

	//删除一条记录
	public abstract void delete(Whdbigwheel whdbigwheel);

	//根据ID删除一条记录
	public abstract void deleteById(int id);

	//修改一条记录
	public abstract void update(Whdbigwheel whdbigwheel);

	//根据hql语句、条件、条件值修改某些记录
	public abstract void updateByHql(final String hql,
			final String[] paramNames, final Object[] values);

	//获得所有记录
	public abstract List<Whdbigwheel> getWhdbigwheels();

	//根据hql语句来查询所有记录
	public abstract List<Whdbigwheel> queryList(String queryString);

	//根据hql、条件值查询某些记录
	public abstract List<Whdbigwheel> getObjectsByCondition(String queryString,
			Object[] p);

	//根据hql语句、条件、条件值查询某些记录
	public abstract List<Whdbigwheel> queryList(String queryString,
			String[] paramNames, Object[] values);

	//根据hql、id列表查询某些记录
	public abstract List<Whdbigwheel> getObjectsByIdList(final String hql,
			final List<Integer> idList);

	//根据hql语句、条件值、分页查询某些记录
	public abstract List<Whdbigwheel> pageList(final String queryString,
			final Object[] p, final Integer page, final Integer size);

	//根据hql、条件值获得一个唯一值
	public abstract int getUniqueResult(final String queryString,
			final Object[] p);

	//根据id查询一条记录
	public abstract Whdbigwheel loadById(int id);

	//根据hql语句、条件、值来查询一条记录
	public abstract Whdbigwheel queryByNamedParam(String queryString,
			String[] paramNames, Object[] values);

	//根据hql语句、条件值来查询是否存在该记录
	public abstract boolean checkClientExistsWithName(String queryString,
			Object[] p);

}