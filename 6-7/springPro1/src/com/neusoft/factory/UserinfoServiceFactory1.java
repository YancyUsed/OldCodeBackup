package com.neusoft.factory;

import com.neusoft.service.UserinfoService;
import com.neusoft.service.impl.UserinfoServiceBean;

public class UserinfoServiceFactory1 {
	public static UserinfoService createUserinfoService(){
		return new UserinfoServiceBean();
	}
}
