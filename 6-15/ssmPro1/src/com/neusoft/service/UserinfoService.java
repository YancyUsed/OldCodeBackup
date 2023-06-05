package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Userinfo;

public interface UserinfoService {
	public List<Userinfo> findAll();
	public boolean zhuanZhang(String name_a,String name_b,int num);
}
