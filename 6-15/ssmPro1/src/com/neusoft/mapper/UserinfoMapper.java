package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Userinfo;

public interface UserinfoMapper {
	public List<Userinfo> findAll() throws Exception;
//	public int  jiaNum(String username,int num)throws Exception;
//	public int  jianNum(String username,int num)throws Exception;
	public int  jiaNum(Userinfo u)throws Exception;
	public int  jianNum(Userinfo u)throws Exception;
}
