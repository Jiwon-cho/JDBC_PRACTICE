package com.kh.model.service;

import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;
import java.sql.Connection;
import java.util.List;

import com.kh.model.dao.EmpDao;
import com.kh.model.vo.Employee;

public class EmpService {
	private EmpDao dao=new EmpDao();
	
	
	public List<Employee> searchAll(){
		Connection conn=getConnection();
		List<Employee> list=dao.searchAll(conn);
		return list;
	}
	
	public int insertEmp(Employee e) {
		Connection conn=getConnection();
		int result=dao.insertEmp(conn,e);
		if(result>0) {
			commit(conn);
		}else  {
			rollback(conn);
		}
		return result;
	}
	
	
	

}
