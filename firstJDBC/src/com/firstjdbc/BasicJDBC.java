package com.firstjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBC {
	
	public static void main(String[] args) {
		//DB에 접속하는 객체변수는 먼저 선언을 함 -> 반환 해줘야 하기 때문에
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		
		
		
		//database 접속하기
		//1. Class.forName() 메소드를 이용해서 driver 을 등록한다. -> 클래스 등록
		//oracle 드라이버 : oracle.jdbc.driver.OracleDriver
	try {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 등록 성공");
		//2. Database 연결을 위한 Connection 객체를 생성
		//DriverManager 객체의 getConnection() 매소드를 이용해서 Connection 객체 생성
		//getConnection() 매소드는 3개의 매개변수가 있음. 문자열 매개변수
		//1: DBurl주소 -> jdbc:oracle:thin:@db서버ip주소:포트:db의 sid
		//				ex)"jdbc:oracle:thin:@localhost:1521:xe"
		//2: 사용자 계정 -> DB에 생성된 계정명을 문자열로 작성 ->EX) "student"
		//계정은 대소문자 상관 없음
		//3: 계정비밀번호-> DB계정에 접속할 비밀번호를 문자열로 작성 ->ex) "student"
		 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","STUDENT","STUDENT");
		System.out.println("DB접속 성공");
		
		//3. SQL 문을 실행할 객체를 생성 -> Statement객체
		//Statement 객체는 Connection 객체를 이용해서 생성함.
		//Connection객체의 createSTatement() 매소드를 이용
		stmt=conn.createStatement();//Connection 에서 예외처리해서 얘는 또해줄 필요 없음.
		//4. 실행할 쿼리문 생성 ->문자열로 생성
		//String sql="SELECT * FROM 테이블명";
		String sql="SELECT * FROM MEMBER";
		
		//5.작성한 쿼리문을 실행 ->Statement 객체의 executeQuery()||executeUpdate() 매소드 이용
		//executeQuery(실행할 쿼리문) -> 반환이 ResultSet -> 뭐리문이 select 일때 사용
		//executeUpdate(실행할 쿼리문)-> 반환이 int -> 쿼리문 insert,update,delete일때 사용
	rs=stmt.executeQuery(sql);
		
		//6. DB에서 가져온 데이터 확인하기 -> data java에 보관하기 <-vo
		//SELECT 문으로 실행한 결과는 RESULTSET객체 타입으로 가져오게됨.(테이블 형식)
		//ResultSet 객체를 이용해서 데이터를 1개 row씩 가져와서 처리!
		//ResultSet객체의 next()메소드를 이용해서 row를 지정함.
		// -> 지정할 row가 없으면 false/ 있으면 true 반환하는 메소드임.
		//다수의 값(row가 여러개) 일때 while문을 사용해서 접근하고
		//한개의 값(row가 한개) 일때는 if문을 사용해서 접근 -> 예상되는 결과 ex)pk를 조건으로 조회한 것
		//지정된 row의 값 접근하기
		//ResultSet객체의 get 메소드를 이용 -> type별로 있음
		//get매소드는 오라클 타입과 자바타입을 맞춰 줌
		//getString(컬럼명||인덱스번호)->varchar2,char,nvarchar2,nchar
		//getInt(컬럼명||인덱스번호)/getDouble(컬럼명||인덱스번호)->number
		// getDate(컬럼명||인덱스번호)->date /java.sql.Date// java.util.Date 도 상속 받고 잇어서 가능은 함 근데 정확하게는 아님
		
//		rs.next();//select문의 첫번째 행 지정
//		String memberId=rs.getString("member_id");//대문자든 소문자든 그냥 알아서 처리함
//		String memberPwd=rs.getString("member_pwd");
//		String memberName=rs.getString("member_name");
//		String gender=rs.getString("gender");
//		int age=rs.getInt("age");
//		Date enrollDate=rs.getDate("enroll_date");
//		
//		System.out.println(memberId+" "+memberPwd+" "+memberName+" "+gender+" "+age+" "+enrollDate);
//		
//		rs.next();//select문의 첫번째 행 지정
//		 memberId=rs.getString("member_id");//대문자든 소문자든 그냥 알아서 처리함
//		 memberPwd=rs.getString("member_pwd");
//		 memberName=rs.getString("member_name");
//		 gender=rs.getString("gender");
//		 age=rs.getInt("age");
//		enrollDate=rs.getDate("enroll_date");
//		
//		System.out.println(memberId+" "+memberPwd+" "+memberName+" "+gender+" "+age+" "+enrollDate);
//		
		
	while(rs.next()) {
		
		String memberId=rs.getString("member_id");//대문자든 소문자든 그냥 알아서 처리함
		String memberPwd=rs.getString("member_pwd");
		String memberName=rs.getString("member_name");
		String gender=rs.getString("gender");
		int age=rs.getInt("age");
		Date enrollDate=rs.getDate("enroll_date");
		
		System.out.println(memberId+" "+memberPwd+" "+memberName+" "+gender+" "+age+" "+enrollDate);
		
	}
	
	//insert 문 실행하기
	//insert into 테이블명 values(값,값....);
	//vlues에 들어가는 값은 developer(oracle sql developer)에서 썻던것과 동일하게 작성을 해야함.
	//값의 리터럴 형식을 맞춰줘야함. 
	//varchar2,char 문자열 -> '값'
	//number -> 10
	//date -> sysdate||'21/03/19'
	sql="INSERT INTO MEMBER VALUES('WHSKDY','WHSKDY','유지훈','M',29,"
			+"'JI@JI.COM','01012345678','서울시 상봉','코딩,상봉',SYSDATE)";
	int result=stmt.executeUpdate(sql);
	System.out.println(result>0?"입력성공":"입력실패");
	
	//7.생성된 객체를 반환(ResultSet,Statement,Connection)
	//생성의 역순으로 반환을 한다.
	
	
	
	
		
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
	try {
		if(rs!=null&&!rs.isClosed())rs.close();
		if(stmt!=null&&!stmt.isClosed())stmt.close();
		if(conn!=null&&!conn.isClosed())conn.close();}
	catch(SQLException e) {
		e.printStackTrace();
	}
	}
	}
}
