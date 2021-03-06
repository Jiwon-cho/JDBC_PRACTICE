package com.scott.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.scott.controller.ScottController;
import com.scott.model.vo.Emp;

public class MainView {
	private Scanner sc=new Scanner(System.in);
	
	public void mainMenu() {
		 
		System.out.println("=====사원 관리 프로그램====");
		System.out.println("1. 항목별 검색하기");
		System.out.println("0. 프로그램 종료");
		System.out.println("입력: ");
		switch(sc.nextInt()) {
		case 1: new ScottController().searchColVal();break;
		case 0: return;
		}
		
		
		
		
		
	}
	
	
	public Map<String,String> inputColVal(){
		System.out.println("====== 항목, 검색어 입력 ======");
		System.out.println("검색할 항목: ");
		String col=sc.nextLine();
		System.out.println("검색할 내용: ");
		String keyword=sc.nextLine();
		Map<String, String> param=new HashMap();
		param.put("col", col);
		param.put("val", keyword);
		
		return param;
	}
	
	public void printMsg(List<Emp> list) {
		if(!list.isEmpty()) {
			for(Emp e:list) {
				System.out.println(e);
			}
		}else {
			System.out.println("데이터가 없습니다.");
		}
	}
	

}
