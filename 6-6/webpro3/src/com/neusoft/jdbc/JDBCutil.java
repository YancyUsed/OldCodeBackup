package com.neusoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCutil {
	private static Connection conn=null;
	private PreparedStatement pst;
	//获取Connection连接
	public Connection getConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("加载Oracle驱动成功");
			String url="jdbc:oracle:thin:@10.25.39.252:1521:orcl";
			String userName="cccda";
			String pwd="123456";
			if(conn==null){
				conn=DriverManager.getConnection(url, userName, pwd);
			}
			System.out.println("获取Connection连接成功");

		} catch (ClassNotFoundException e) {
			System.out.println("加载Oracle驱动失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("获取Connection连接失败");
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet executeQuery(String sql)throws SQLException{
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			rs = pst.executeQuery();
			System.out.println("执行查询语句成功");
		} catch (SQLException e) {
			System.out.println("执行查询语句失败");
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet executeQuery(String sql,Object obj[])throws SQLException{
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			rs = pst.executeQuery();
			System.out.println("执行查询语句成功");
		} catch (SQLException e) {
			System.out.println("执行查询语句失败");
			e.printStackTrace();
		}
		return rs;
	}
	

	
	public int executeUpdate(String sql)throws SQLException{
		int count=-1;
		try {
			pst=conn.prepareStatement(sql);
			count=pst.executeUpdate();
			System.out.println("执行更新语句成功");
		} catch (SQLException e) {
			System.out.println("执行更新语句失败");
			e.printStackTrace();
		}
		return count;
	}
	public int executeUpdate(String sql,Object obj[])throws SQLException{
		int count=-1;
		try {
			pst=conn.prepareStatement(sql);
			if (obj != null) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject(i + 1, obj[i]);
				}
			}
			count=pst.executeUpdate();
			System.out.println("执行更新语句成功");
		} catch (SQLException e) {
			System.out.println("执行更新语句失败");
			e.printStackTrace();
		}
		return count;
	}
	public void close(){
		try {
			if(pst!=null){
				pst.close();
				pst=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			System.out.println("关闭连接成功");
		} catch (SQLException e) {
			System.out.println("关闭连接失败");
			pst=null;
			conn=null;
			e.printStackTrace();
		}	
	}
	//开始事务
	public void beginTransation(){
		try {
			conn.setAutoCommit(false);
			System.out.println("开始事务");
		} catch (SQLException e) {
			System.out.println("开始事务失败");
			e.printStackTrace();
		}
	}
	//提交事务
	public void commit(){
		try {
			conn.commit();
			System.out.println("提交事务成功");
		} catch (SQLException e) {
			System.out.println("提交事务失败");
			e.printStackTrace();
		}
	}
	//回滚事务
	public void rollback(){
		try {
			conn.rollback();
			System.out.println("回滚事务成功");
		} catch (SQLException e) {
			System.out.println("回滚事务失败");
			e.printStackTrace();
		}
	}
}
