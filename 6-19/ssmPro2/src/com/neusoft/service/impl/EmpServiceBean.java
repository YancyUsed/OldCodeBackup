package com.neusoft.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.EmpMapper;
import com.neusoft.mybatis.SqlSessionUtil;
import com.neusoft.po.Emp;
import com.neusoft.service.EmpService;
import com.neusoft.vo.EmpDeptVO;

@Service
public class EmpServiceBean implements EmpService {

	@Override
	public List<Emp> findAll() {
		System.out.println("...EmpServiceBean...findAll().....");
		List<Emp> list=null;
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		try {
			list=mapper.findAll();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<EmpDeptVO> findEmpDeptAll() {
		System.out.println("...EmpServiceBean...findEmpDeptAll().....");
		List<EmpDeptVO> list=null;
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		try {
			list=mapper.findEmpDeptAll();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

	@Override
	public List<Emp> findEmpDeptAll2() {
		System.out.println("...EmpServiceBean...findEmpDeptAll2().....");
		List<Emp> list=null;
		SqlSession session=SqlSessionUtil.getSession();
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		try {
			list=mapper.findEmpDeptAll2();
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}

}
