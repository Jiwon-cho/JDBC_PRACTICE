package com.emp.view;

import java.util.List;
import java.util.Scanner;

import com.emp.controller.EmpController;
import com.emp.model.vo.Emp;

public class MainView {
	Scanner sc=new Scanner(System.in);
	
	
	public void mainMenu() {
		EmpController ec=new EmpController();
		
	while(true) {
		System.out.println("====EMP 관리 프로그램====");
		System.out.println("1. 전체 조회");
		System.out.println("2. 이름 조회");
		System.out.println("3. 월급 조회(이상/이하)");
		System.out.println("4. 사원 등록");
		System.out.println("5. 사원 수정");
		System.out.println("6. 사원 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택: ");
		switch(sc.nextInt()) {
		case 0: return;
		case 1:ec.searchAll();break;
		case 2:ec.searchName();break;
		case 3:ec.searchSal();break;
		
		}
		
		
	}
	}
	
	
	
	public void printEmp(List<Emp> list) {
	System.out.println("========조회 결과===========");
	if(!list.isEmpty()) {	
		for(Emp e:list) {
			System.out.println(e);
		}
	}else {
		System.out.println("데이터가 없습니다.");
	}
	
	}
	
	public String inputData() {
		System.out.print("검색 할 사원의 이름을 입력하시오: ");
		return sc.nextLine();
	}
	
	public String searchSal() {
		System.out.println("검색할 월급: ");
		return sc.nextLine();
	}
	
	
	

}
