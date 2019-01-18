package com.demo.validator;

import com.demo.common.model.Errorcode;
import com.demo.service.ErrorcodeService;
import com.demo.service.UserService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.validate.Validator;

public class RegValidator extends Validator{

	@Override
	protected void validate(Controller c) {
	
		  
		// TODO Auto-generated method stub
		
		setShortCircuit(true);
//		c.getPara("psw");

		Record r= UserService.me.get(c.getPara("account"));
		validateRegex("psw", "[0-9]*", "10086", "只能是数字");
		
		validateRegex("name", ".{2,}", "10010", "姓名字符串");
		boolean b;
		if(r!=null){
			
			
		}
		else{
			
		}
		
		
	
	}

	@Override
	protected void handleError(Controller c) {
		// TODO Auto-generated method stub
		c.renderJson();
	}

}
