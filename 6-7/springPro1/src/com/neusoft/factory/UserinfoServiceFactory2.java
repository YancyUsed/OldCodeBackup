package com.neusoft.factory;

import com.neusoft.service.UserinfoService;
import com.neusoft.service.impl.UserinfoServiceBean;

public class UserinfoServiceFactory2 {
	public UserinfoService createUserinfoService(){
		return new UserinfoServiceBean();
	}
}
