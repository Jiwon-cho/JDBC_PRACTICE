package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.EmpController;
import com.kh.model.vo.Employee;

public class MainView {
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		EmpController ec = new EmpController();
		while (true) {
			
			System.out.println("===== 회원 관리 프로그램 v.2 =====");
			System.out.println("1. 전체 사원조회");
			System.out.println("2. 사원 조회 SubMenu");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리 submenu");
			System.out.println("7. 직책 관리 submenu");
			System.out.println("0. 프로그램 종료");
			System.out.println("입력: ");

			switch (sc.nextInt()) {
			case 0:
				return;
			case 1:
				ec.searchAll();
				break;
			case 2:
				search();break;
			case 3:
				ec.insertEmp();break;

			}

		}

	}
	
	
	public void printMsg(List<Employee> list) {
		if(!list.isEmpty()) {
			for(Employee e: list) {
				System.out.println(e);
			}
		}else {
			System.out.println("데이터가 없습니다.");
		}
	}
	
	public void search() {
		EmpController ec=new EmpController();
	while(true) {	
		System.out.println("===== 사원 조회 메뉴====");
		System.out.println("1. 부서");
		System.out.println("2. 직책");
		System.out.println("3. 이름");
		System.out.println("4. 급여(이상/이하)");
		System.out.println("입력: ");
		switch(sc.nextInt()) {
		case 1: 
		
		}
	}
	}
	
	
	public Employee insertEmp() {
		System.out.println("==== 사원 등록 ====");
		Employee e=new Employee();
		System.out.print("아이디: ");
		e.setEmpId(sc.nextLine());
		System.out.print("이름: ");
		e.setEmpName(sc.nextLine());
		System.out.print("사원 번호: ");
		e.setEmpNo(sc.nextLine());
		System.out.print("이메일 : ");
		e.setEmail(sc.nextLine());
		System.out.print("핸드폰 번호: ");
		e.setPhone(sc.nextLine());
		System.out.print("부서 번호: ");
		e.setDeptCode(sc.nextLine());
		System.out.print("직책 번호: ");
		e.setJobCode(sc.nextLine());
		System.out.print("급여 수준: ");
		e.setSalLevel(sc.nextLine());
		System.out.print("급여: ");
		e.setSalary(sc.nextInt());
		sc.nextLine();
		System.out.println("보너스: ");
		e.setBonus(sc.nextDouble());
		sc.nextLine();
		System.out.println("매니저 번호: ");
		e.setManagerId(sc.nextLine());
		return e;
	}
	
	public 

}
