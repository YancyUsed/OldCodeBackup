package com.neusoft.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyHandler {

	@RequestMapping(value="/MyHandler_findAll")
	public String findAll(HttpServletRequest request,HttpServletResponse response){
		System.out.println("...MyHandler......findAll()..........");
	//	request.getRequestDispatcher("").forward(request, response);
	//	response.sendRedirect("");
		
		return "forward:main.jsp";
	//	return "redirect:main.jsp";
	}
	@RequestMapping(value="/MyHandler_add")
	public String add(){
		System.out.println("...MyHandler......add()..........");
		return "redirect:main.jsp";
	}
	
}
