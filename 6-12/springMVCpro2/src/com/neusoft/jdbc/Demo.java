package com.neusoft.jdbc;

import java.sql.SQLException;

import com.neusoft.bean.Message;

public class Demo {

	public static void main(String[] args) throws SQLException {

		JDBCutil db=new JDBCutil();
		db.getConnection();
		for(int i=299;i<1000;i++){
			Message m=new Message();
			m.setName("cccda100"+i);
			m.setTitle("±êÌâ"+i);
			m.setContxt("ÄÚÈÝ"+i);
			String sql="insert into message (id,name,title,time,contxt) values (seq_message.nextval,?,?,sysdate,?)";
			Object[] obj={m.getName(),m.getTitle(),m.getContxt()};
			db.executeUpdate(sql, obj);	
		}
		
		db.close();

	}

}
