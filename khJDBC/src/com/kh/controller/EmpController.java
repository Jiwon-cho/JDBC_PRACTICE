package com.kh.controller;

import java.util.List;

import com.kh.model.service.EmpService;
import com.kh.model.vo.Employee;
import com.kh.view.MainView;

public class EmpController {
	private MainView view=new MainView();
	private EmpService service=new EmpService();
	
	public void mainMenu() {
		view.mainMenu();
	}
	
	public void searchAll() {
		List<Employee> list=service.searchAll();
		view.printMsg(list);
	}
	
	public void insertEmp() {
		Employee e=view.insertEmp();
		int result=service.insertEmp(e);
		
	}
	
	
	
	
}
