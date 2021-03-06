package com.emp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.common.JDBCTemplate;
import com.emp.model.vo.Emp;

public class EmpDao {

	public List<Emp> searchAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList();
		String sql = "SELECT * FROM EMP";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;

	}
	
	public List<Emp> searchName(Connection conn,String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList();
		String sql = "SELECT * FROM EMP WHERE ENAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+name+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;

	}
	
	public List<Emp> searchSal(Connection conn,String sal) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> list = new ArrayList();
		int s=Integer.parseInt(sal.substring(0,sal.indexOf("???")));
		
		String sql = "SELECT * FROM EMP WHERE SAL #?";
		if(sal.contains("??????")) {
			sql=sql.replace("#", ">=");
		}else if(sal.contains("??????")) {
			sql=sql.replace("#", "<=");
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, s);
		
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Emp e = new Emp();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;

	}
	
	
	
	

}
