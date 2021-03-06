package com.member.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

public class MainView {
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {

		while (true) {
			System.out.println("===회원관리 프로그램 v.1===");
			System.out.println("1. 전체회원조회하기");
			System.out.println("2. 이름으로 조회하기");
			System.out.println("3. 아이디로 조회하기");
			System.out.println("4. 회원등록하기");
			System.out.println("5. 회원정보 수정하기");
			System.out.println("6. 회원삭제하기");
			System.out.println("7.컬럼으로 검색하기");
			System.out.println("0. 프로그램 종료하기");
			System.out.print("입력: ");
			int cho = sc.nextInt();
			switch (cho) {
			case 1:
				new MemberController().selectAll();
				break;
			case 2:
				new MemberController().searchName();
				break;
			case 3:
				new MemberController().searchId();
				break;
			case 4:
				new MemberController().insertMember();
				break;
			case 5:
				new MemberController().update();
				break;
			case 6:
				new MemberController().delete();
				break;
			case 7:
				new MemberController().searchColName();
				break;
			case 0:
				return;
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

	public String inputId() {
		System.out.println("=== 조회할 아이디 입력 ===");
		Scanner sc = new Scanner(System.in);
		System.out.println("입력: ");
		return sc.nextLine();
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
	
	public Map<String,String> inputColVal() {
		//column이름 검색할 내용 두개 받아서
		Map<String,String> param=new HashMap();
		Scanner sc=new Scanner(System.in);
		System.out.println("====컬럼별로 검색하기====");
		System.out.print("컬럼명: ");
		param.put("col", sc.nextLine());
		//String 두개 반환!
		System.out.print("검색어: ");
		param.put("val", sc.nextLine());
		
		return param;
		
	}
	
	public String deleteMember() {
		System.out.println("===== 회원 정보 삭제 =====");
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제하고자 하는 회원 아이디: ");
		return sc.nextLine();
		

		 
	}
	
	

}
