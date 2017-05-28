package com.mono.core.dao.hibernate.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.mono.core.dao.hibernate.BaseDao;
import com.mono.core.util.hibernate.Page;

@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T extends java.io.Serializable, PK extends java.io.Serializable> implements BaseDao<T, PK> {
	private static final Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

	private final String HQL_LIST_ALL;
	private final String HQL_COUNT_ALL;
	private final String HQL_LIST_ALL_BYID;

	@Resource
	private SessionFactory sessionFactory;
	// 实体类型
	private Class<T> entityClass;

	private String pkName = null;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		log.debug("hibiernateBaseDaoImpl初始化..........");

		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];

		Field[] fields = this.entityClass.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(Id.class)) {
				this.pkName = f.getName();
			}
		}

		Assert.notNull(pkName);

		HQL_LIST_ALL = "from " + entityClass.getSimpleName() + " order by " + pkName;
		HQL_COUNT_ALL = "select count(*) from " + entityClass.getSimpleName();
		HQL_LIST_ALL_BYID =
				"from " + entityClass.getSimpleName() + " where " + pkName + " = :" + pkName + " order by " + pkName;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public T add(T t) {
		this.getSession().save(t);
		return t;
	}

	@Override
	public T delete(PK id) {
		T entity = get(id);
		this.getSession().delete(entity);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) {
		return (T) this.getSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return this.getSession().createQuery(HQL_LIST_ALL).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(String hql, Map<String, Object> params) {
		Query query = this.getSession().createQuery(hql);

		if(params != null){
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllById(PK id) {
		return this.getSession().createQuery(HQL_LIST_ALL_BYID).setParameter(pkName, id).list();
	}

	@Override
	public Page<T> getAllPerPage(int pageNo, int pageSize) {
		List<T> list = this.queryPerPage(HQL_LIST_ALL, pageNo, pageSize, null);
		long totalElements = this.queryCount(HQL_COUNT_ALL, null);
		return new Page<T>(pageNo, totalElements, list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryPerPage(String hql, int pageNo, int pageSize, Map<String, Object> params) {
		if (pageSize == 0) {
			pageSize = Page.DEFAULT_PAGE_SIZE;
		}
		Query query = this.getSession().createQuery(hql);
		if(params != null){
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		query.setFirstResult(Page.getPageStart(pageNo, pageSize));
		query.setMaxResults(pageSize);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> query(Map<String, Object> params) {
		Criteria criteria = this.getSession().createCriteria(entityClass.getSimpleName());

		if(params != null){
			for (String key : params.keySet()) {
				criteria.add(Restrictions.eq(key, params.get(key)));
			}
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T queryUnique(Map<String, Object> params) {
		Criteria criteria = this.getSession().createCriteria(entityClass.getSimpleName());

		if(params != null){
			for (String key : params.keySet()) {
				criteria.add(Restrictions.eq(key, params.get(key)));
			}
		}
		return (T) criteria.uniqueResult();
	}

	@Override
	public long queryCount(String hql, Map<String, Object> params) {
		Query query = this.getSession().createQuery(hql);

		if(params != null){
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		return ((Number) query.setMaxResults(1).uniqueResult()).longValue();
	}

	@Override
	public T update(T t) {
		this.getSession().update(t);
		return t;
	}

}
