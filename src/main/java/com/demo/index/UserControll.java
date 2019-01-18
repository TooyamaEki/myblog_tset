package com.demo.index;

import java.util.List;

import javax.swing.plaf.synth.Region;

import com.demo.common.model.Blog;
import com.demo.service.BlogService;
import com.demo.service.ErrorcodeService;
import com.demo.service.UserService;
import com.demo.validator.LoginValidator;
import com.demo.validator.RegValidator;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public class UserControll extends Controller{

	
	public static Record getcode(int id){
		return    ErrorcodeService.me.geterrmsg(id);
	}
	
	
	
	@Before({RegValidator.class})
		public void reg(){
			boolean a = UserService.me.add(getPara("account"), 	getPara("psw"),	getPara("name"));
			if(a){
				renderJson(getcode(1));
				
			}else{
				
				renderJson(getcode(10001));
			}
			
			
		}
		
		//登陸
		@Before({LoginValidator.class})
		public void login(){
			Record r= UserService.me.login(getPara("account"), 	getPara("psw"));
			
			if(r == null){
				renderJson("登陆失败请重试");
			}else{
				setSessionAttr("userInfo", r);
				renderJson(getcode(1));
				renderJson(r);
			}
			 
		}
		
		

		public void getlist(){
			 List<Record> lists = UserService.me.getlist(getParaToInt("id"));
			 renderJson(lists);
					
		}
		
		public void updatapsw(){
			
			boolean v = UserService.me.updapsw(getParaToInt("id"),getPara("psw"));
				if(v){
					renderJson("修改成功");
				}else{
					renderJson("修改失败");
				}
		
					
		}
		/**
		 * 
		 */
		public void changuserinfo(){
		boolean c=	UserService.me.changuserinfo(getParaToInt("id"), getPara("account"), getPara("psw"));
		if(c){
			renderJson("修改成功");
		}else{
			renderJson("修改失败");
		}


			
		}
	
		}
