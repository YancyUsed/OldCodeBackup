package com.neusoft.dao;

import java.util.List;

import com.neusoft.bean.Userinfo;

public interface UserinfoDao {
	public int add(Userinfo u) throws Exception;
	public List<Userinfo> findAll()throws Exception;
	public String findPwdByUsername(String userName)throws Exception;
}
