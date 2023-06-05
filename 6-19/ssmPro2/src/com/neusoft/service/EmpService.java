package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Emp;
import com.neusoft.vo.EmpDeptVO;

public interface EmpService {
	public List<Emp> findAll();
	public List<EmpDeptVO> findEmpDeptAll();
	public List<Emp> findEmpDeptAll2();
}
