package com.scott.model.service;

import static com.scott.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.scott.model.dao.ScottDao;
import com.scott.model.vo.Emp;



public class ScottService {
	private ScottDao dao=new ScottDao();
	
	public List<Emp> searchColVal(Map<String,String> param) {
		Connection conn=getConnection();
		 List<Emp> list=dao.searchColVal(conn,param);
		return list;
	}

}
