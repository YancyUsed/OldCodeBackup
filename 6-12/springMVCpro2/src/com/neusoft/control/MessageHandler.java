package com.neusoft.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.bean.Message;
import com.neusoft.service.MessageService;
import com.neusoft.tools.Pages;
import com.neusoft.tools.Tools;

@Controller
public class MessageHandler {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value="/test/MessageHandler_add")
	public String add(Message m,HttpServletRequest request){
		System.out.println("...MessageHandler....add().....");
		m.setContxt(Tools.Stringfilter(m.getContxt()));
		boolean isOK=messageService.add(m);
		if(isOK){
			request.setAttribute("msg", "ÃÌº”¡Ù—‘≥…π¶!");
			return "forward:/test/MessageHandler_findAllByPage";
		}else{
			request.setAttribute("msg", "ÃÌº”¡Ù—‘ ß∞‹!");
			return "forward:/msg.jsp";
		}
	}
	@RequestMapping(value="/test/MessageHandler_findAll")
	public String findAll(HttpServletRequest request){
		System.out.println("...MessageHandler....findAll().....");
		List<Message> list=messageService.findAll();
		request.setAttribute("list", list);
		return "forward:/showMessage.jsp";
	}
	@RequestMapping(value="/test/MessageHandler_findAllByPage")
	public String findAllByPage(HttpServletRequest request){
		System.out.println("...MessageHandler....findAll().....");
		int page=1;
		if(request.getParameter("page")==null||request.getParameter("page")==null){
			page=1;
		}else{
			page=Integer.parseInt(request.getParameter("page")) ;
		}
		int count=messageService.findCount();
		Pages p=new Pages(page, count);
		List<Message> list=messageService.findAllByPage(p.getPage());
		request.setAttribute("list", list);
		request.setAttribute("p", p);
		return "forward:/showMessage.jsp";
	}
	
}







