package com.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.member.model.vo.Member;

public class MemberDao {
	
	public List<Member> selectAll() {
		// DB접속해서 데이터 가져오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");
			
			String sql = "SELECT * FROM MEMBER";
			pstmt = conn.prepareStatement(sql);
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
//			m.setMemberId(rs.getString(1));...
				// index 로하면 긁는 순서 바꾸면 원하는 대로 안들어가기 때문에 이름으로 쓰는게 명확
				list.add(m);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Member> searchName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");
			
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%'|| ? || '%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn=null;
		//Statement stmt=null;
		//prepareStatement 인터페이스 설계를 함.
		//데이터가 들어가는 곳에 리터럴을 신경쓰지 말고, 넣자 -> 메소드 통해서 넣자.
		//데이터가 들어가는 곳에 ?(위치홀더) ? 를 매소드를 이용해서 처리
		//? 에 대한 구분은 인덱스로 구분 하자. 1일 부터 시작하는...
		PreparedStatement pstmt=null;
		
		int result=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");
			conn.setAutoCommit(false);
			//stmt = conn.createStatement();
			//PreparedStatement의 생성은 conn 객체의 매소드를 이용해서 한다.
			//conn.preaparedStatement("sql구문"); 생성할때 sql 구문을 넣어줘야함.
			
			String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
			//VALUES 안에 것들 INDEX 순으로 셈//
			//INSERT INTO MEMBER VLUES(?,?,?,?,?,?,to_date(?) <- date 는 이런 식으로 함 보통,?,?,SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			//? 를 세팅 -> sql 문에 ? 표식이 있을때만 세팅,? 쓸 필요 없으면 그냥 실행할 수 있다.
			//set 매소드 문자열 ->  pstmt.setString(인덱스,값)
			//숫자 -> pstmt.setInt(인덱스,값)||pstmt.setDouble(인덱스,값)
			//날짜 -> pstmt.setDate(인덱스,값)
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			//			String sql="INSERT INTO MEMBER VALUES('"+m.getMemberId()+"',"
//			+"'"+m.getMemberPwd()+"',"+"'"+m.getMemberName()+"',"
//			+"'"+m.getGender()+"',"+m.getAge()+",'"+m.getEmail()+"','"+m.getPhone()
//			+"','"+m.getAddress()+"','"+m.getHobby()+"',SYSDATE)";
//			result=stmt.executeUpdate(sql);
			
			result=pstmt.executeUpdate();//sql 이 이미 안에 들어가있어서
			
			
			
			if(result>0) conn.commit();
			else conn.rollback();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
//				if (stmt != null && !stmt.isClosed())
//					stmt.close();
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		return result;
	}
	
	public List<Member> searchId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> list = new ArrayList();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");
			
			String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID='%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<Member> searchColName(Map<String,String> param) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Member> list=new ArrayList();
		
		String sql="SELECT * FROM MEMBER WHERE "+param.get("col")+" LIKE ?";
		sql="SELECT * FROM MEMBER WHERE # LIKE ?";
		sql=sql.replace("#",param.get("col"));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					"STUDENT","STUDENT");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+param.get("val")+"%");
			rs=pstmt.executeQuery();
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null && !rs.isClosed())
					rs.close();
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	public int update(Member m) {
		int a=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE MEMBER SET AGE= ?,EMAIL=?,PHONE=?,ADDRESS=? WHERE MEMBER_Id= ?";
	try {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");
		conn.setAutoCommit(false);
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,m.getAge());
		pstmt.setString(2,m.getEmail());
		pstmt.setString(3,m.getPhone());
		pstmt.setString(4,m.getAddress());
		pstmt.setString(5,m.getMemberId());
		
		a=pstmt.executeUpdate();
		
		if(a>0)conn.commit();
		else conn.rollback();
	
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if (pstmt != null && !pstmt.isClosed())
				pstmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return a;	
	}

	public int delete(String id) {
		int a=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="DELETE FROM MEMBER WHERE MEMBER_Id= ?";
	try {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STUDENT", "STUDENT");
		conn.setAutoCommit(false);
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,id);
		
		
		a=pstmt.executeUpdate();
		
		if(a>0)conn.commit();
		else conn.rollback();
	
	
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			if (pstmt != null && !pstmt.isClosed())
				pstmt.close();
			if (conn != null && !conn.isClosed())
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return a;	
	}
		
	
	

}
