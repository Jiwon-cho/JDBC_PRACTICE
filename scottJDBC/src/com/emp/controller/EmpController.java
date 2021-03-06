package com.emp.controller;

import java.util.List;

import com.emp.model.service.EmpService;
import com.emp.model.vo.Emp;
import com.emp.view.MainView;

public class EmpController {
	private MainView view=new MainView();
	private EmpService service=new EmpService();
	
	public void MainMenu() {
		view.mainMenu();
	}
	
	public void searchAll() {
		List<Emp> list=service.searchAll();
		view.printEmp(list);
	}
	
	
	public void searchName() {
		String name=view.inputData();
		List<Emp> list=service.searchName(name);
		view.printEmp(list);
	}
	
	public void searchSal() {
		String sal=view.searchSal();
		List<Emp> list=service.searchSal(sal);
		view.printEmp(list);
	}

}
