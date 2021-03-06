package com.mysecondJDBC;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		Connection cn=null;
		Statement st=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","KH","KH");
			
			st=cn.createStatement();
			String sql="SELECT * FROM DEPARTMENT";
			rs=st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
			}
			sql="INSERT INTO DEPARTMENT VALUES('A5','코딩부','L6')";
			int result=st.executeUpdate(sql);
			System.out.println(result>0?"입력성공":"실패");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null&&!rs.isClosed())rs.close();
				if(st!=null&&!st.isClosed())st.close();
				if(cn!=null&&!cn.isClosed())cn.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
