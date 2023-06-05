package com.neusoft.conl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neusoft.factory.UserinfoServiceFactory1;
import com.neusoft.factory.UserinfoServiceFactory2;
import com.neusoft.service.UserinfoService;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("..MyServlet2..doGet()...");
		//静态工厂
	//	UserinfoService service=UserinfoServiceFactory1.createUserinfoService();
		//普通工厂
//		UserinfoServiceFactory2 factory=new UserinfoServiceFactory2();
//		UserinfoService service=factory.createUserinfoService();
//		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
//		UserinfoService service=(UserinfoService)act.getBean("UserinfoService2");
		
		ApplicationContext act=new ClassPathXmlApplicationContext("beans.xml");
		UserinfoService service=(UserinfoService)act.getBean("UserinfoService3");
		
		service.findAll();
		request.setAttribute("msg", "UserinfoServiceFactory2创建的UserinfoService");
		request.getRequestDispatcher("msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
