package com.mono.core.dao.jdbc.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mono.core.dao.jdbc.BaseDao;
import com.mono.core.util.Page;
import com.mono.core.util.QueryHelper;

@Repository("baseDaoJdbc")
@Lazy(true)
public class BaseDaoImpl<T> implements BaseDao<T> {
	private static Logger log = LoggerFactory.getLogger(BaseDaoImpl.class);

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	// 实体类型
	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		log.debug("BaseDaoImpl初始化..........");
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#get(int)
	 */
	@Override
	public T get(int id) {
		String sql = "select * from " + entityClass.getSimpleName() + " where id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		return namedParameterJdbcTemplate.queryForObject(sql, paramMap, new BeanPropertyRowMapper<T>(entityClass));
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#getAll()
	 */
	@Override
	public List<T> getAll() {
		String sql = "select * from " + entityClass.getSimpleName();
		return namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(entityClass));
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#add(T)
	 */
	@Override
	public int add(T t) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(buildInsertSql(), new BeanPropertySqlParameterSource(t), keyHolder);
		int key = keyHolder.getKey().intValue();
		return key;
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#delete(int)
	 */
	@Override
	public int delete(int id) {
		String sql = "delete from " + entityClass.getSimpleName() + " where id=:id";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		return namedParameterJdbcTemplate.update(sql, paramMap);
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#delete(java.util.Map)
	 */
	@Override
	public int delete(Map<String, Object> paramMap) {
		StringBuilder sql = new StringBuilder("delete from ").append(entityClass.getSimpleName()).append(" where");
		for (String key : paramMap.keySet()) {
			sql.append(" ").append(key).append("=:").append(key).append(" and");
		}
		sql.delete(sql.length() - 4, sql.length());
		return namedParameterJdbcTemplate.update(sql.toString(), paramMap);
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#update(T)
	 */
	@Override
	public int update(T t) {
		return namedParameterJdbcTemplate.update(buildUpdateSql(), new BeanPropertySqlParameterSource(t));
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#query(com.mono.util.Page, com.mono.util.QueryHelper)
	 */
	@Override
	public Page<T> query(Page<T> page, QueryHelper queryHelper) {
		String querySql = queryHelper.buildQuerySql();
		String sql = "select * from " + entityClass.getSimpleName() + " where 1=1" + querySql;
		String totalSql = "select count(*) from " + entityClass.getSimpleName() + " where 1=1" + querySql;
		log.debug("totalsql: " + totalSql);
		if (page.getTotalPages() == 0) {
			int totalCount = namedParameterJdbcTemplate.getJdbcOperations().queryForObject(totalSql, Integer.class);
			page.setTotalCount(totalCount);
		}
		sql += " limit " + page.getStartNum() + "," + page.getNumPerPage();
		log.debug("sql: " + sql);
		List<T> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<T>(entityClass));
		page.setElements(list);
		return page;
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#buildInsertSql()
	 */
	@Override
	public String buildInsertSql() {
		return buildInsertSql(true);
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#buildInsertSql(boolean)
	 */
	@Override
	public String buildInsertSql(boolean isNativeId) {
		StringBuilder sql = new StringBuilder("insert into ").append(entityClass.getSimpleName()).append("(");
		StringBuilder params = new StringBuilder(" values(");
		for (Field field : entityClass.getDeclaredFields()) {
			log.debug("Field:" + field);
			if (isNativeId && "id".equals(field.getName())) {
				continue;
			}
			sql.append(field.getName()).append(",");
			params.append(":").append(field.getName()).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		params.deleteCharAt(params.length() - 1);
		sql.append(")").append(params).append(")");
		log.debug("buildInsertSql:" + sql.toString());
		return sql.toString();
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#buildUpdateSql()
	 */
	@Override
	public String buildUpdateSql() {
		return buildUpdateSql(true);
	}

	/* (non-Javadoc)
	 * @see com.mono.dao.impl.BaseDao#buildUpdateSql(boolean)
	 */
	@Override
	public String buildUpdateSql(boolean isNativeId) {
		StringBuilder sql = new StringBuilder("update ").append(entityClass.getSimpleName()).append(" set ");
		for (Field field : entityClass.getDeclaredFields()) {
			log.debug("Field:" + field);
			if (isNativeId && "id".equals(field.getName())) {
				continue;
			}
			sql.append(field.getName()).append("=").append(":").append(field.getName()).append(",");
		}
		sql.deleteCharAt(sql.length() - 1);
		sql.append(" where id = :id");
		log.debug("buildUpdateSql:" + sql.toString());
		return sql.toString();
	}

}
