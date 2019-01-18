package com.demo.common;




import com.demo.index.BlogControll;
import com.demo.index.UserControll;
import com.jfinal.config.Routes;
//import com.jfinal.config.Routes.Route;

public class UserRoutes extends Routes{

	@Override
	public void config() {
//		路由入口
			add("/user", UserControll.class);
			add("/blog", BlogControll.class);
	}
	

}
