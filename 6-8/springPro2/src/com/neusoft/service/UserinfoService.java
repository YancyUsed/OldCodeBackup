package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.Userinfo;

public interface UserinfoService {
	public boolean add(Userinfo u);
	public List<Userinfo> findAll();
	public boolean isLoginOK(String userName,String pwd);
}
