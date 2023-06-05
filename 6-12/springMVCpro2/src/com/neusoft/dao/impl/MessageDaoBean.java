package com.neusoft.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neusoft.bean.Message;
import com.neusoft.dao.MessageDao;
import com.neusoft.jdbc.JDBCutil;
import com.neusoft.tools.Pages;

//@Repository(value="MessageDao")
@Repository
public class MessageDaoBean implements MessageDao {

	@Override
	public int add(Message m) throws SQLException {
		System.out.println("...MessageDaoBean...add()......");
		int count=0;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		//insert into message (id,name,title,time,contxt) values (seq_message.nextval,'cccda','标题',sysdate,'大家好!')
		String sql="insert into message (id,name,title,time,contxt) values (seq_message.nextval,?,?,sysdate,?)";
		Object[] obj={m.getName(),m.getTitle(),m.getContxt()};
		count=db.executeUpdate(sql, obj);
		return count;
	}

	@Override
	public List<Message> findAll() throws SQLException {
		System.out.println("...MessgeServiceBean....findAll()...");
		List<Message> list=new ArrayList<Message>();
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="select id,name,title, to_char(time,'yyyy-MM-dd hh:mi:ss') time,contxt from message order by id desc";
		ResultSet rs=db.executeQuery(sql);
		while(rs.next()){
			Message m=new Message();
			m.setId(rs.getInt("id"));
			m.setContxt(rs.getString("contxt"));
			m.setName(rs.getString("name"));
			m.setTime(rs.getString("time"));
			m.setTitle(rs.getString("title"));
			list.add(m);
		}
		rs.close();
		return list;
	}
	//p              (p-1)*n+1到 p*n
	@Override
	public List<Message> findAllByPage(int page) throws SQLException {
		System.out.println("...MessgeServiceBean....findAllByPage(int page)...");
		int x=(page-1)*Pages.N+1;
		int y=page*Pages.N;
		
		List<Message> list=new ArrayList<Message>();
		JDBCutil db=new JDBCutil();
		db.getConnection();

//select * from(select rownum  mynum , a.*  from(select  id,name,title, to_char(time,'yyyy-MM-dd hh:mi:ss') time,contxt from message order by id desc)  a)where mynum>=5 and mynum<=10
		String sql="select * from(select rownum  mynum , a.*  from(select  id,name,title, to_char(time,'yyyy-MM-dd hh:mi:ss') time,contxt from message order by id desc)  a)where mynum>=? and mynum<=?";
		Object[] obj={x,y};
		ResultSet rs=db.executeQuery(sql,obj);
		while(rs.next()){
			Message m=new Message();
			m.setId(rs.getInt("id"));
			m.setContxt(rs.getString("contxt"));
			m.setName(rs.getString("name"));
			m.setTime(rs.getString("time"));
			m.setTitle(rs.getString("title"));
			list.add(m);
		}
		rs.close();
		return list;
	}

	@Override
	public int findCount() throws SQLException {
		System.out.println("...MessgeServiceBean....findCount...");
		int count=0;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		String sql="select count(id) from message";
		System.out.println(sql);
		ResultSet rs=db.executeQuery(sql);
		if(rs.next()){
			count=rs.getInt(1);
		}
		rs.close();
		return count;
	}

}
