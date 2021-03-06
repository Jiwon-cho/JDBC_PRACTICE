package com.member.view;

import java.util.List;
import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	private MemberController mc=new MemberController();
	
	
	public void mainMenu(MemberController mc) {
		this.mc=mc;
	while(true) {	
		Scanner sc=new Scanner(System.in);
		System.out.println("===== 회원 관리 프로그램 v.2 =====");
		System.out.println("1. 전체 회원조회");
		System.out.println("2. 이름으로 조회");
		System.out.println("3. 아이디로 조회");
		System.out.println("4. 회원등록");
		System.out.println("5. 회원수정");
		System.out.println("6. 회원삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println("입력: ");
		
		switch(sc.nextInt()) {
		case 0:return;
		case 1:mc.searchAll();break;
		case 2:mc.searchNAme();break;
		case 3:mc.searchId();break;
		case 4:mc.insertMember();break;
		case 5:mc.updateMember();break;
		case 6:mc.deleteMember();break;
		}
	
	}
	
}
	
	
	public void printMembers(List<Member> list) {
		System.out.println("===회원 조회 결과===");
		if (!list.isEmpty()) {
			for (Member m : list) {
				System.out.println(m);
			}
		} else {
			System.out.println("조회된 결과가 없습니다!");
		}

	}
	
	
	public String inputData() {
		System.out.println("=== 조회할 이름 입력 ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		return sc.nextLine();
	}

	public String searchId() {
		System.out.println("=== 조회할 아이디 입력 ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		return sc.nextLine();
	}

	public Member insertMember() {
		System.out.println("===== 회원등록 =====");
		Scanner sc = new Scanner(System.in);
		Member m = new Member();
		System.out.print("아이디: ");
		m.setMemberId(sc.nextLine());
		System.out.print("패스워드: ");
		m.setMemberPwd(sc.nextLine());
		System.out.print("이름: ");
		m.setMemberName(sc.nextLine());
		System.out.print("성별(M/F): ");
		m.setGender(sc.nextLine());
		System.out.print("나이: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("이메일: ");
		m.setEmail(sc.nextLine());
		System.out.print("전화번호: ");
		m.setPhone(sc.nextLine());
		System.out.print("주소: ");
		m.setAddress(sc.nextLine());
		System.out.print("취미(,): ");
		m.setHobby(sc.nextLine());

		return m;

	}

	
	public void print(String msg) {
		System.out.println("======시스템 알림=====");
		System.out.println(msg);
		System.out.println("===================");
	}
	
	public Member updateMember() {
		System.out.println("===== 회원 정보 수정 =====");
		Scanner sc = new Scanner(System.in);
		Member m = new Member();
		System.out.print("수정하고자 하는 회원 이름: ");
		m.setMemberId(sc.nextLine());
		System.out.print("수정할 나이: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("수정할 이메일: ");
		m.setEmail(sc.nextLine());
		System.out.print("수정할 전화번호: ");
		m.setPhone(sc.nextLine());	
		System.out.print("수정할 주소: ");
		m.setAddress(sc.nextLine());

		return m;
	}
	
	
	
	public String deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제하고자 하는 회원 아이디: ");
		return sc.nextLine();
		

		 
	}
	
	
}