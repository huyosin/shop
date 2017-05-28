package com.mono.core.util;

import java.util.List;

public class QueryHelper {
	private static final String ORDERBY = " order by id";
	private List<QueryCriteria> criteriaList;
	private String orderBy;

	public QueryHelper() {
		this.orderBy = QueryHelper.ORDERBY;
	}

	public QueryHelper(List<QueryCriteria> criteriaList, String orderBy) {
		this.criteriaList = criteriaList;
		this.orderBy = orderBy;
	}

	public List<QueryCriteria> getCriteriaList() {
		return criteriaList;
	}

	public void setCriteriaList(List<QueryCriteria> criteriaList) {
		this.criteriaList = criteriaList;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	
	public String buildQuerySql(){
		if(criteriaList == null || criteriaList.size()==0){
			return "";
		}else{
			StringBuilder sql = new StringBuilder("");
			for(QueryCriteria criteria : criteriaList){
				if("like".equals(criteria.getRestriction())){
					sql.append(" and ").append(criteria.getName()).append(" like %").append(criteria.getValue()).append("%");
				}else{
					sql.append(" and ").append(criteria.getName()).append(criteria.getRestriction()).append(criteria.getValue());
				}
			}
			sql.append(" ").append(orderBy);
			return sql.toString();
		}
	}
}
