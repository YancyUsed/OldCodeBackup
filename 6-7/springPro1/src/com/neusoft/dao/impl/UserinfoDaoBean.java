package com.neusoft.dao.impl;

import java.util.List;

import com.neusoft.bean.Userinfo;
import com.neusoft.dao.UserinfoDao;

public class UserinfoDaoBean implements UserinfoDao {

	@Override
	public int add(Userinfo u) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Userinfo> findAll() throws Exception {
		System.out.println("....UserinfoDaoBean.....findAll().....");
		return null;
	}

	@Override
	public String findPwdByUsername(String userName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
