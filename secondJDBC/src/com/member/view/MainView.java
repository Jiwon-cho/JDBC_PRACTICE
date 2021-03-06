package com.member.view;

import java.util.List;
import java.util.Scanner;

import com.member.controller.MemberController;
import com.member.model.vo.Member;

//view 클래스는 사용자에게 화면을 출력해주는 역할을 하는 클래스
//화면에서 선택,data입력 받고 controller에 서비스를 요청하는 기능

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
				break;
			case 6:
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
		System.out.println("아이디: ");
		m.setMemberId(sc.next());
		System.out.println("패스워드: ");
		m.setMemberPwd(sc.next());
		System.out.println("이름: ");
		m.setMemberName(sc.next());
		System.out.println("성별(M/F): ");
		m.setGender(sc.next());
		System.out.print("나이: ");
		m.setAge(sc.nextInt());
		System.out.println("이메일: ");
		m.setEmail(sc.next());
		System.out.println("전화번호: ");
		m.setPhone(sc.next());
		System.out.println("주소: ");
		m.setAddress(sc.next());
		System.out.println("취미(,): ");
		m.setHobby(sc.next());

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
		System.out.print("나이: ");
		m.setAge(sc.nextInt());
		System.out.println("이메일: ");
		m.setEmail(sc.next());
		System.out.println("전화번호: ");
		m.setPhone(sc.next());
		System.out.println("주소: ");
		m.setAddress(sc.next());

		return m;
	}

	
	
}
