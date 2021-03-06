package com.emp.model.service;

import java.sql.Connection;
import java.util.List;

import com.emp.common.JDBCTemplate;
import com.emp.model.dao.EmpDao;
import com.emp.model.vo.Emp;

public class EmpService {
	private EmpDao dao=new EmpDao();
	
	public List<Emp> searchAll(){
		Connection conn=JDBCTemplate.getConnection();
		List<Emp> list=dao.searchAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public List<Emp> searchName(String name){
		Connection conn=JDBCTemplate.getConnection();
		List<Emp> list=dao.searchName(conn, name);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public List<Emp> searchSal(String sal){
		Connection conn=JDBCTemplate.getConnection();
		List<Emp> list=dao.searchSal(conn, sal);
		JDBCTemplate.close(conn);
		return list;
	}
}
