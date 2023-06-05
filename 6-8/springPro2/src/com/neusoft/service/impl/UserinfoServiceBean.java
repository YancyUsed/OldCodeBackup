package com.neusoft.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.neusoft.bean.Userinfo;
import com.neusoft.dao.UserinfoDao;
import com.neusoft.dao.impl.UserinfoDaoBean;
import com.neusoft.service.UserinfoService;

@Service (value="UserinfoService")
public class UserinfoServiceBean implements UserinfoService {
	
//	private UserinfoDao userinfoDao=new UserinfoDaoBean();
	@Resource(name="UserinfoDao")
	private UserinfoDao userinfoDao;


	public UserinfoServiceBean(){
		System.out.println("...UserinfoServiceBean....ππ‘Ï......");
	}

	public void my_init(){
		System.out.println("..UserinfoServiceBean..my_init()..");
	}
	public void my_close(){
		System.out.println("..UserinfoServiceBean..my_close()..");
	}
	
	@Override
	public boolean add(Userinfo u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Userinfo> findAll() {
		System.out.println("...UserinfoServiceBean......findAll()...");
	//	UserinfoDao dao=new UserinfoDaoBean();
		try {
			userinfoDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean isLoginOK(String userName, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

}
