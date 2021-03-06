package com.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop=new Properties();
	
	public MemberDao() {
	try {	
		prop.load(new FileReader("resources/sql/member_sql_properties"));
	}catch(IOException e) {
		e.printStackTrace();
	}
	}

	public List<Member> searchAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		//String sql = "SELECT * FROM MEMBER";
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectAll"));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnroll_date(rs.getDate("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;

	}

	public List<Member> searchName(Connection conn, String name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE ?";
		List<Member> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnroll_date(rs.getDate("enroll_date"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public List<Member> searchId(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + id + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender"));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnroll_date(rs.getDate("enroll_date"));
				list.add(m);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public int insertMember(Connection conn, Member m) {

		PreparedStatement pstmt = null;
		//String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";

		int result = 0;
		try {

			pstmt = conn.prepareStatement(prop.getProperty("insertMember"));

			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	public int updateMember(Connection conn, Member m) {
		int a = 0;

		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET AGE= ?,EMAIL=?,PHONE=?,ADDRESS=? WHERE MEMBER_Id= ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m.getAge());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getMemberId());

			a = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} 

		return a;
	}
	
	
	public int deleteMember(Connection conn,String id) {
		PreparedStatement pstmt=null;
		int a=0;
		String sql="DELETE FROM MEMBER WHERE MEMBER_ID LIKE";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			a=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
}
