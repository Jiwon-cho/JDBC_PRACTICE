package com.kh.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.model.vo.Employee;

public class EmpDao {
	private Properties prop=new Properties();
	
	public EmpDao() {
	try {	
		prop.load(new FileReader("resources/sql/kh_sql"));
	}catch(IOException e) {
		e.printStackTrace();
	}

}
	public List<Employee> searchAll(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(prop.getProperty("selectall"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setEmpId(rs.getString("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getDouble("bonus"));
				e.setManagerId(rs.getString("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
				list.add(e);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertEmp(Connection conn, Employee ep) {
		PreparedStatement pstmt=null;
		int result=0;
		String sql=prop.getProperty("insertEmp");
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ep.getEmpId());
			pstmt.setString(2,ep.getEmpName());
			pstmt.setString(3, ep.getEmpNo());
			pstmt.setString(4, ep.getEmail());
			pstmt.setString(5, ep.getPhone());
			pstmt.setString(6, ep.getDeptCode());
			pstmt.setString(7, ep.getJobCode());
			pstmt.setString(8, ep.getSalLevel());
			pstmt.setInt(9, ep.getSalary());
			pstmt.setDouble(10, ep.getBonus());
			pstmt.setString(11, ep.getManagerId());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
}