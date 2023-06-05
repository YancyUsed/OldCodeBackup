package com.neusoft.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.bean.Message;
import com.neusoft.dao.MessageDao;
import com.neusoft.jdbc.JDBCutil;
import com.neusoft.service.MessageService;

//@Service(value="MessageService")
@Service
public class MessgeServiceBean implements MessageService {
	
//	@Resource(name="MessageDao")
	@Autowired
	private MessageDao messageDao;

	@Override
	public boolean add(Message m) {
		System.out.println("...MessgeServiceBean....add()...");
		boolean isOK=false;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		db.beginTransation();
		try {
			int count=messageDao.add(m);
			if(count>0){
				isOK=true;
				db.commit();
			}else{
				isOK=false;
				db.rollback();
			}
		} catch (SQLException e) {
			isOK=false;
			db.rollback();
			e.printStackTrace();
		}finally{
			db.close();
		}
		return isOK;
	}

	@Override
	public List<Message> findAll() {
		System.out.println("...MessgeServiceBean....findAll()...");
		List list=null;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		try {
			list=this.messageDao.findAll();
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}finally{
			db.close();
		}
		return list;
	}
	@Override
	public List<Message> findAllByPage(int page) {
		System.out.println("...MessgeServiceBean....findAll()...");
		List list=null;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		try {
			list=this.messageDao.findAllByPage(page);
		} catch (SQLException e) {
			list=null;
			e.printStackTrace();
		}finally{
			db.close();
		}
		return list;
	}

	@Override
	public int findCount() {
		System.out.println("...MessgeServiceBean....findCount()...");
		int count=0;
		JDBCutil db=new JDBCutil();
		db.getConnection();
		try {
			count=messageDao.findCount();
		} catch (SQLException e) {
			count=0;
			e.printStackTrace();
		}finally{
			db.close();
		}
		return count;
	}

}
