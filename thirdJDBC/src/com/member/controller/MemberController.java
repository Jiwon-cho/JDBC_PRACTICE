package com.member.controller;

import java.util.List;

import com.member.model.dao.MemberDao;
import com.member.model.service.MemberService;
import com.member.model.vo.Member;
import com.member.view.MainView;

public class MemberController {
	private MainView view;
	private MemberService service=new MemberService();

	
	public void MainMenu() {
		view=new MainView();
		view.mainMenu(this);
	}
	
	
	public void searchAll() {
		List<Member> list=service.searchAll();
		view.printMembers(list);
	}
	
	
	public void searchNAme() {
		String name=view.inputData();
		List<Member>list=service.searchName(name);
		view.printMembers(list);
	}

	public void searchId() {
		String id=view.searchId();
		List<Member>list=service.searchName(id);
		view.printMembers(list);
	}
	
	public void insertMember() {
		Member m=view.insertMember();
		int a=service.insertMember(m);
		view.print(a>0?"입력 성공":"입력 실패");
	}
	
	public void updateMember() {
		Member m=view.updateMember();
		int a=service.updateMember(m);
		view.print(a>0?"업데이트 성공":"업데이트 실패");
	}
	
	
	public void deleteMember() {
		String id=view.deleteMember();
		int a=service.deleteMember(id);
		view.print(a>0?"삭제 성공":"삭제 실패");
	}
}
