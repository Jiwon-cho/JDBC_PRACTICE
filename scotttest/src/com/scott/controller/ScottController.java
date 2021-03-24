package com.scott.controller;

import java.util.List;
import java.util.Map;

import com.scott.model.service.ScottService;
import com.scott.model.vo.Emp;
import com.scott.view.MainView;

public class ScottController {
	private MainView view=new MainView();
	private ScottService service=new ScottService();
	
	
	
	public void mainMenu() {
		
		view.mainMenu();
	}
	
	public void searchColVal() {
		Map<String,String> param=view.inputColVal();
		List<Emp> list=service.searchColVal(param);
		view.printMsg(list);
	
	}
}
