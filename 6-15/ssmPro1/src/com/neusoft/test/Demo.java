package com.neusoft.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.neusoft.mapper.UserinfoMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.po.Userinfo;

public class Demo {

	public static void main(String[] args) {
		SqlSession session=SqlSessionUtil.getSession();
		
	//	List<Userinfo> list=session.selectList("UserinfoMapper.findAll");
		
		UserinfoMapper mapper = session.getMapper(UserinfoMapper.class);
		List<Userinfo> list=null;
		try {
			list = mapper.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Userinfo u:list){
			System.out.println(u.getId()+"\t"+u.getUsername()+"\t"+u.getPwd()+"\t"+u.getNum());
		}
		

	}

}
