package com.neusoft.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.jdbc.JDBCutil;

public class UserinfoDao {
	public boolean isLoginOK(String userName,String pwd ) throws SQLException{
		boolean isOK=false;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		//select count(*) from userinfo where username='cccda' and pwd='123456'
	//	String sql="select count(*) from userinfo where username='"+userName+"' and pwd='"+pwd+"'";
		String sql="select count(*) from userinfo where username=? and pwd=?";
		Object[] obj={userName,pwd};
		System.out.println(sql);
	//	ResultSet rs=db.executeQuery(sql);
		ResultSet rs=db.executeQuery(sql,obj);
		if(rs.next()){
			int count=rs.getInt(1);
			if(count>0){
				isOK=true;
			}else{
				isOK=false;
			}
		}
		rs.close();
		return isOK;
	}
	
	public String findPwdByUsername(String userName) throws SQLException{
		String pwd=null;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="select pwd from userinfo where username=?";
		Object[] obj={userName};
		ResultSet rs=db.executeQuery(sql, obj);
		if(rs.next()){
			pwd=rs.getString(1);
		}
		rs.close();
		return pwd;
	}
	public int jiaNum(String userName,int num) throws SQLException{
		int count=0;
		JDBCutil db=new JDBCutil();
		Connection conn=db.getConnection();
		System.out.println("UserinfoDao--jiaNum--connection="+conn);
		//update userinfo set num=num+1000 where username='cccda'
		String sql="update userinfo set num=num+? where username=?";
		Object[] obj={num,userName};
		count=db.executeUpdate(sql, obj);
		return count;
	}
	public int jianNum(String userName,int num) throws SQLException{
		int count=0;
		JDBCutil db=new JDBCutil();
		Connection conn=db.getConnection();
		System.out.println("UserinfoDao--jianNum--connection="+conn);
		//update userinfo set num=num+1000 where username='cccda'
		String sql="update userinfo set num=num-? where username=?";
		Object[] obj={num,userName};
		count=db.executeUpdate(sql, obj);
		return count;
	}
}













