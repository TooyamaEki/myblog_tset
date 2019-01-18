package com.demo.index;

import java.util.List;

import com.demo.service.BlogService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

public class BlogControll extends Controller {
	
	public void addrizhi(){
		Record userInfo = getSessionAttr("userInfo");
		System.out.println(userInfo);
//添加日志方法 tzy 2019年1月11日20:27:41
	boolean v=	BlogService.me.addrizhi(userInfo.getInt("id"),getPara("title"),getPara("content"));
			if(v){
				renderJson("添加成功");
			}else{
				renderJson("添加失败");
			}
	
	}
	
	
	
//	拼接日志与用户 tzy 2019年1月11日20:27:49
	public void rizhianuser(){
		Record userInfo = getSessionAttr("userInfo");
		List<Record> l=BlogService.me.getUserBlog(userInfo.getInt("id"));
		
		renderJson(l);
		
		
	}
	
	
	
	
	/**
	 * 删除日志
	 */
	public void delectrizhi(int id){
		
	List<Record> l=BlogService.me.delectblog(getParaToInt("id"));
	
	
	renderJson(l);
//	if(l){
//		renderJson("删除成功");
//		
//	}else{
//		renderJson("删除失败");
//	}
		
		
	}
}
