package com.neusoft.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.Userinfo;

public class Demo {

	public static void main(String[] args) throws SQLException {
		
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="select * from userinfo";
		ResultSet rs=db.executeQuery(sql);
		while(rs.next()){
			Userinfo u=new Userinfo();
			u.setId(rs.getInt("id"));
			u.setNum(rs.getInt("num"));
			u.setOther(rs.getString("other"));
			u.setPwd(rs.getString("pwd"));
			u.setUserName(rs.getString("userName"));
			
			System.out.println(u.getId()+"\t"+u.getUserName()+"\t"+u.getPwd()+"\t"+u.getNum()+"\t"+u.getOther());
		}
		rs.close();
		db.close();
		System.out.println("over");

	}

}
