package com.member.controller;

import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.vo.Member;
import com.member.view.MainView;

public class MemberController {

//view, dao 클래스를 관리하는 역할
//서비스에 따라 필요한 객체의 기능을 호출하는 역할을 함.
	private MemberDao dao=new MemberDao()  ;
	
	public void mainMenu() {
		new MainView().mainMenu();
	
	}
	
	public void selectAll() {
		//DB student 계정 member 테이블의 모든 데이터를 가져오는 기능
		List<Member>list=dao.selectAll();
		new MainView().printMembers(list);
		
	}

	public void searchName() {
		//이용자에게 검색할 이름 값을 받아와야함.-> 화면에서 입력 -> view
		//이용자가 입력한 값을 가지고 DB의 student계정의 memeber테이블의 
		//member_name 컬럼과 컬럼에 부분 일치하는 값이 있는지 조회하고 결과를 가져와서
		//->DB 접속! -> Dao
		//이용자에게 검색한 데이터를 출력해줌.
		String name=new MainView().inputData();
		List<Member> list=dao.searchName(name);
		new MainView().printMembers(list);
	
	
	}
	
	public void insertMember() {
		Member m=new MainView().insertMember();
		int a=dao.insertMember(m);
		System.out.println(a==1?"입력되었습니다.":"입력실패하였습니다.");
	}
	
	
	public void searchId() {
		String id=new MainView().inputId();
		List<Member> list=dao.searchId(id);
		new MainView().printMembers(list);
	}
	

}
