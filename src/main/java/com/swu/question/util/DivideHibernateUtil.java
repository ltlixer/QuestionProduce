package com.swu.question.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
public class DivideHibernateUtil {
	private int pageSize =10;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 提供一个统一的查询方法(带分页) hql 形式 from 类 where 条件=? ..
	 * @param hql
	 * @param parameters
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List executeQueryByPage(Session session,String hql, String[] parameters,
			 int pageNow) {
		List list = null;
		try {
			Query query = session.createQuery(hql);
			// 先判断是否有参数要绑定
			if (parameters != null && parameters.length > 0) {
				for (int i = 0; i < parameters.length; i++) {
					query.setString(i, parameters[i]);
				}
			}
			query.setFirstResult((pageNow - 1) * pageSize).setMaxResults(
					pageSize);

			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		} 
		return list;
	}
	
	/**
	 * 提供一个统一的查询方法(带分页) hql 形式 "FROM A WHERE A.ID IN (:list) and ?"; 
	 * 
	 * @param hql
	 * @param parameters
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List executeQueryInByPage(Session session,String hql, List parameters,
			 int pageNow,String findStr) {
		List list = null;

		try {
			Query query = session.createQuery(hql);
			// 先判断是否有参数要绑定
			if (parameters != null && parameters.size() > 0) {
				query.setParameterList("list", parameters); 
			}
			if(findStr!=null&&!findStr.trim().equals("")){
				query.setString("str", "%"+findStr+"%");
			}
			query.setFirstResult((pageNow - 1) * pageSize).setMaxResults(
					pageSize);

			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		} 
		return list;
	}
	/**
	 * 提供一个统一的查询方法(带分页) hql 形式 "FROM A WHERE A.ID IN (:list)"; 
	 * 
	 * @param hql
	 * @param parameters
	 * @param pageSize
	 * @param pageNow
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List executeQueryInByPage(Session session,String hql, List parameters,
			 int pageNow) {
		List list = null;

		try {
			Query query = session.createQuery(hql);
			// 先判断是否有参数要绑定
			if (parameters != null && parameters.size() > 0) {
				query.setParameterList("list", parameters); 
			}
			query.setFirstResult((pageNow - 1) * pageSize).setMaxResults(
					pageSize);

			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			// TODO: handle exception
		} 
		return list;
	}
	/**
	 * 获得总页数
	 * @param sumCount  总记录条数
	 * @param pageSize  每一页的记录条数
	 * @return
	 */
	public int getPageCount(int sumCount) {
			int size = sumCount / pageSize;
			int mod = sumCount % pageSize;
			if (mod != 0) {
				size++;
			}
			return sumCount == 0 ? 0 : size;
		}
}
