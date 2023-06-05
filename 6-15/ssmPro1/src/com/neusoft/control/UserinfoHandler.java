package com.neusoft.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neusoft.po.Userinfo;
import com.neusoft.service.UserinfoService;

@Controller
public class UserinfoHandler {
	@Autowired
	private UserinfoService userinfoService;
	
	@RequestMapping(value="/test/UserinfoHandler_findAll")
	public String findAll(HttpServletRequest requst){
		System.out.println("....UserinfoHandler....findAll()........");
		List<Userinfo> list=userinfoService.findAll();
		requst.setAttribute("list", list);
		return "forward:/show.jsp";
	}
	
	@RequestMapping(value="/test/UserinfoHandler_zhuanZhang")
	public String zhuanZhang(HttpServletRequest request,String userNameA,String userNameB,int num){
		System.out.println("....UserinfoHandler....findAll()........");

		boolean isOK=userinfoService.zhuanZhang(userNameA, userNameB, num);
		String msg="";
		if(isOK){
			msg="zzOK";
		}else{
			msg="zz²»OK";
		}
		request.setAttribute("msg", msg);
		return "forward:/test/UserinfoHandler_findAll";
	}
	
}
