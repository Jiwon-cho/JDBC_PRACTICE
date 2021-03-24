package com.scott.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.scott.model.vo.Emp;

public class ScottDao {
	private Properties prop=new Properties(); 
	
	public ScottDao(){
	try {
		prop.load(new FileReader("resources/sql/scott_sql_properties"));
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

	public List<Emp> searchColVal(Connection conn,Map<String,String> param){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Emp> list=new ArrayList();
		String sql=prop.getProperty("selectcol");
		sql=sql.replace("#",param.get("col"));
		try {
			pstmt=conn.prepareStatement(sql);
		
			pstmt.setString(1, "%"+param.get("val")+"%");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Emp e=new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getInt("sal"));
				e.setComm(rs.getInt("comm"));
				e.setDeptno(rs.getInt("deptno"));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}









}
