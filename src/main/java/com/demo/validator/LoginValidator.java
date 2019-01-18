package com.demo.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator{

	@Override
	protected void validate(Controller a) {
		
//		c.getPara("account");
//		c.getPara("psw");
		System.out.println("传入的账号:"+a.getPara("account"));
		System.out.println("传入的密码:"+a.getPara("psw"));
		validateRegex("account", "[0-9]*", "102", "这输的都是些什么鬼？");
		validateRegex("psw", "[0-9]*", "10086", "你特么会不会设置密码？");
	}

	@Override
	protected void handleError(Controller a) {
		a.renderJson();
	}
	

}
