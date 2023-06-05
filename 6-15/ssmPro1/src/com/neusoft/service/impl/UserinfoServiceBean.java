package com.neusoft.service.impl;

import java.util.List;

import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.UserinfoMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.po.Userinfo;
import com.neusoft.service.UserinfoService;

@Service
public class UserinfoServiceBean implements UserinfoService {
	
//	@Autowired
//	UserinfoMapper userinfoMapper;
	
	@Override
	public List<Userinfo> findAll() {
		System.out.println("...UserinfoServiceBean......findAll().......");
		List<Userinfo> list;
		SqlSession session=SqlSessionUtil.getSession();
		try {
			UserinfoMapper mapper=session.getMapper(UserinfoMapper.class);
			list = mapper.findAll();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public boolean zhuanZhang(String name_a, String name_b, int num) {
		System.out.println("...UserinfoServiceBean......findAll().......");
		boolean isOK=false;
		SqlSession session=SqlSessionUtil.getSession();
		UserinfoMapper mapper=session.getMapper(UserinfoMapper.class);
		try {
//			int count1=session.update("UserinfoMapper.jianNum","T");
//			int count2=session.update("UserinfoMapper.jiaNum","T");
			Userinfo u1=new Userinfo();
			u1.setUsername(name_a);
			u1.setNum(num);
			
			Userinfo u2=new Userinfo();
			u2.setUsername(name_b);
			u2.setNum(num);
			
			int count1=mapper.jianNum(u1);
			int count2=mapper.jiaNum(u2);
			if(count1>0&&count2>0){
				session.commit();
				System.out.println("转账成功,事务提交");
				isOK=true;
			}else{
				session.rollback();
				System.out.println("转账失败,事务回滚1");
				isOK=false;
			}
		} catch (Exception e) {
			session.rollback();
			System.out.println("转账失败,事务回滚2");
			isOK=false;
			e.printStackTrace();
		}
		return isOK;
	}

}
