package com.neusoft.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.neusoft.dao.UserinfoDao;
import com.neusoft.jdbc.JDBCutil;

public class UserinfoService {
	
	public boolean isLoginOK2(String userName,String pwd){
		boolean isOK=false;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		UserinfoDao dao=new UserinfoDao();
		try {
			String password=dao.findPwdByUsername(userName);
			if(pwd.equals(password)){
				isOK=true;
			}else{
				isOK=false;
			}
		} catch (SQLException e) {
			isOK=false;
			e.printStackTrace();
		}finally{
			db.close();
		}
		return isOK;
	}
	
	public boolean isLoginOK(String userName,String pwd){
		boolean isOK=false;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		UserinfoDao dao=new UserinfoDao();
		try {
			isOK=dao.isLoginOK(userName, pwd);
		} catch (SQLException e) {
			isOK=false;
			e.printStackTrace();
		}finally{
			db.close();
		}
		return isOK;
	}
	public boolean zhuanZhang(String userName_a,String userName_b,int num){
		boolean isOK=false;
		JDBCutil db=new JDBCutil();
		Connection conn=db.getConnection();
		System.out.println("UserinfoService--zhuanZhang--connection="+conn);
		db.beginTransation();
		UserinfoDao dao=new UserinfoDao();
		try {
			int count1=dao.jianNum(userName_a, num);
			int count2=dao.jiaNum(userName_b, num);
			if(count1>0&&count2>0){
				isOK=true;
				System.out.println("转账成功");
				db.commit();
				System.out.println("事务提交");
			}else{
				isOK=false;
				System.out.println("转账失败--1");
				db.rollback();
				System.out.println("事务回滚--1");
			}
		} catch (SQLException e) {
			isOK=false;
			e.printStackTrace();
			System.out.println("转账失败--2");
			db.rollback();
			System.out.println("事务回滚--2");
		}finally{
			db.close();
		}
		return isOK;
	}
}














