package com.member.model.service;

import java.sql.Connection;
import java.util.List;


import static com.member.common.JDBCTemplate.close;
import static com.member.common.JDBCTemplate.getConnection;
import static com.member.common.JDBCTemplate.commit;
import static com.member.common.JDBCTemplate.rollback;
import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;

//DB접속을 위한 Connection 객체를 관리하는 역할
//Connection객체를 생성하는 기능(메소드)  공용으로 관리하겠음.->JDBCTemplate 객체에서 메소드로 가져옴
//Connection 가져와서 Dao에 전달하여 전달된 DB로 접속해서 SQL 문을 실행하게 하는 역할
public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	public List<Member> searchAll(){
		//1.Connection 객체 생성
		Connection conn=getConnection();
		//Connection conn=JDBCTemplate.getConnection();
		List<Member> list=dao.searchAll(conn);
	
		//만약에 dao실행한 sql 구문이 insert,update,delete문이면
		//트랜젝션 처릭까지 진행.
		//Connection 객체를 반환해줌.
		//JDBCTemplate.close(conn);
		//import해서 static으로 선언 하면 안써도 됨
		//static 메소드는 import 할 때 선언해 두면 안써도 됨
		return list;
	}
	
	public List<Member> searchName(String name){
		Connection conn=getConnection();
		List<Member> list=dao.searchName(conn,name);
		
		return list;
	}
	
	

	public List<Member> searchId(String id){
		Connection conn=getConnection();
		List<Member> list=dao.searchName(conn,id);
		
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int a=dao.insertMember(conn,m);
		//insert, update, delet문은 트렌젝션 처리해야함.
		if(a>0) commit(conn);
		else rollback(conn);;

		return a;
	}
	
	
	public int updateMember(Member m) {
		Connection conn=getConnection();
		int a=dao.updateMember(conn,m);
		if(a>0) commit(conn);
		else rollback(conn);;
		close(conn);
		return a;
	}
	
	
	public int deleteMember(String id) {
		Connection conn=getConnection();
		int a=dao.deleteMember(conn,id);
		if(a>0) commit(conn);
		else rollback(conn);;
		
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
