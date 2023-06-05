package com.neusoft.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.neusoft.bean.Message;
import com.neusoft.dao.MessageDao;
import com.neusoft.jdbc.JDBCutil;

@Repository(value="MessageDao")
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

}
