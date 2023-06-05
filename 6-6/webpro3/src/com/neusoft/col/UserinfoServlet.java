package com.neusoft.col;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neusoft.bean.Userinfo;
import com.neusoft.service.UserinfoService;

/**
 * Servlet implementation class UserinfoServlet
 */
@WebServlet("/servlet/UserinfoServlet")
public class UserinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".....UserinfoServlet......doGet()..............");
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}else if("login2".equals(method)){
			login2(request,response);
		}else if("zhuanZhang".equals(method)){
			zhuanZhang(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//ÖÐÎÄ
		doGet(request, response);
	}
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".....UserinfoServlet......login()..............");
		Userinfo u=new Userinfo();
		u.setUserName(request.getParameter("userName"));
		u.setPwd(request.getParameter("pwd"));
		System.out.println("userName="+u.getUserName());
		System.out.println("pwd="+u.getPwd());
		UserinfoService service=new UserinfoService();
		boolean isOK=service.isLoginOK(u.getUserName(), u.getPwd());
		if(isOK){
			System.out.println("µÇÂ¼³É¹¦");
			request.setAttribute("msg", "µÇÂ¼³É¹¦");
			request.getRequestDispatcher("../msg.jsp").forward(request, response);
		}else{
			System.out.println("µÇÂ¼Ê§°Ü");
			request.setAttribute("msg", "µÇÂ¼Ê§°Ü");
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}

	}
	protected void login2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(".....UserinfoServlet......login2()..............");
		Userinfo u=new Userinfo();
		u.setUserName(request.getParameter("userName"));
		u.setPwd(request.getParameter("pwd"));
		System.out.println("userName="+u.getUserName());
		System.out.println("pwd="+u.getPwd());
		UserinfoService service=new UserinfoService();
		boolean isOK=service.isLoginOK2(u.getUserName(), u.getPwd());
		if(isOK){
			System.out.println("µÇÂ¼³É¹¦");
			request.setAttribute("msg", "µÇÂ¼³É¹¦");
			request.getRequestDispatcher("../msg.jsp").forward(request, response);
		}else{
			System.out.println("µÇÂ¼Ê§°Ü");
			request.setAttribute("msg", "µÇÂ¼Ê§°Ü");
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}
	}
	protected void zhuanZhang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("......UserinfoServlet.....zhuanZhang......");
		String userName_a=request.getParameter("userName_a");
		String userName_b=request.getParameter("userName_b");
		int num=Integer.parseInt(request.getParameter("num")) ;
		System.out.println("userName_a="+userName_a);
		System.out.println("userName_b="+userName_b);
		System.out.println("num="+num);
		UserinfoService service=new UserinfoService();
		boolean isOK=service.zhuanZhang(userName_a, userName_b, num);
		if(isOK){
			System.out.println("×ªÕË³É¹¦");
			request.setAttribute("msg", "×ªÕË³É¹¦");
		}else{
			System.out.println("×ªÕËÊ§°Ü");
			request.setAttribute("msg", "×ªÕËÊ§°Ü");
		}
		request.getRequestDispatcher("../msg.jsp").forward(request, response);
	}
}
