package com.neusoft.conl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.service.UserinfoService;
import com.neusoft.service.impl.UserinfoServiceBean;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".....MyServlet.....doGet().....");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("...1.....");
		UserinfoService service=(UserinfoService)ctx.getBean("UserinfoService");
		UserinfoService service2=(UserinfoService)ctx.getBean("UserinfoService");
		
		System.out.println("service="+service);
		System.out.println("service2="+service2);
		
		System.out.println("...2.....");
	//	UserinfoService service=new UserinfoServiceBean();
		service.findAll();
		System.out.println("over");
		request.getRequestDispatcher("msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".....MyServlet.....doPost().....");
		doGet(request, response);
	}

}
