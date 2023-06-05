package com.neusoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Message;

public interface MessageDao {
	public int add(Message m) throws SQLException;
	public List<Message> findAll() throws SQLException;
}
