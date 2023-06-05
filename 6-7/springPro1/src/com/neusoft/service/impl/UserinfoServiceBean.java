package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.bean.Userinfo;
import com.neusoft.dao.UserinfoDao;
import com.neusoft.dao.impl.UserinfoDaoBean;
import com.neusoft.service.UserinfoService;

public class UserinfoServiceBean implements UserinfoService {
	
//	private UserinfoDao userinfoDao=new UserinfoDaoBean();
	private UserinfoDao userinfoDao;
	
	
	public UserinfoDao getUserinfoDao() {
		return userinfoDao;
	}

	public void setUserinfoDao(UserinfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
	}

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
