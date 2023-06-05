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
				System.out.println("ת�˳ɹ�");
				db.commit();
				System.out.println("�����ύ");
			}else{
				isOK=false;
				System.out.println("ת��ʧ��--1");
				db.rollback();
				System.out.println("����ع�--1");
			}
		} catch (SQLException e) {
			isOK=false;
			e.printStackTrace();
			System.out.println("ת��ʧ��--2");
			db.rollback();
			System.out.println("����ع�--2");
		}finally{
			db.close();
		}
		return isOK;
	}
}














