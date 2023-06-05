package com.neusoft.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.bean.Message;
import com.neusoft.service.MessageService;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/servlet/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..MessageServlet...doGet()......");
		String method=request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}else if("findAll".equals(method)){
			findAll(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..MessageServlet...add()......");
		Message m=new Message();
		m.setName(request.getParameter("name"));
		m.setTitle(request.getParameter("title"));
		m.setContxt(request.getParameter("conTxt"));
		System.out.println(m.getName()+"\t"+m.getTitle()+"\t"+m.getContxt());
		
		ApplicationContext act=new ClassPathXmlApplicationContext("spring.xml");
		MessageService service=(MessageService)act.getBean("MessageService");
		boolean isOK=service.add(m);
		if(isOK){
			request.setAttribute("msg", "ÃÌº”¡Ù—‘≥…π¶");
			this.findAll(request, response);
		}else{
			request.setAttribute("msg", "ÃÌº”¡Ù—‘ ß∞‹");
			request.getRequestDispatcher("../msg.jsp").forward(request, response);
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..MessageServlet...findAll()......");
		ApplicationContext act=new ClassPathXmlApplicationContext("spring.xml");
		MessageService service=(MessageService)act.getBean("MessageService");
		List<Message> list=service.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("../showMessage.jsp").forward(request, response);
	}
}
