package com.demo.service;



import java.util.List;

import javax.lang.model.element.VariableElement;

import com.demo.common.model.Blog;
import com.demo.unit.getTime;
import com.jfinal.plugin.activerecord.Record;


public class BlogService {
	public static final BlogService me = new BlogService();
	
	private  Blog dao=new  Blog().dao();

	/**
	 * 添加 日志 tzy 2019-1-11 20:30:58
	 * 
	 * @author i760a
	 *添加日志
	 */
	public boolean addrizhi(int u_id,String title,String content){
		
		Blog m = new Blog();
		
		
		m.set("tags", TagsService.me.listTags());
		m.set("u_id", u_id);
//		Record r=UserService.me.getUser(id);
//		m.set("username", r);
		
		m.set("title", title);
		m.set("content", content);
		m.set("create_time", getTime.nowtime());
		if(m.save()){
			return true;
		}
		return false;
	
	}
	
/**
 * 获取日志和phone tzy 2019年1月11日20:30:06
 * @param uid
 * @return
 */
	
	public List<Record> getUserBlog(int uid){
		
		List<Record> blogList = dao.getblog(uid);
		
		
//		for(Record blog :blogList){
//			Record q= UserService.me.getUser(blog.get("uid"));
//			blog.set("phone", q.get("account"));
//			blog.keep("uid","phone","title");
//		}
		
//		for(Record blog:blogList){
//			Record q=UserService.me.getUser(blog.get("uid"));
//			blog.set("phone", q.get("account"));
//		
//			blog.keep("uid","phone","title");
//			
//		}
		
		return blogList;
		
	}
	
	
	
	/**
	 * 删除日志sql操作
	 */
	
//	public boolean delectblog(int id){
//		
//     
//		return dao.delectblog(id);
//		
//			
//	}

	/**
	 * 删除日志框架操作
	 */
	
	public List<Record> delectblog(int id){
		
	     
		Blog m = new Blog();
	
		m.set("id", id);
		m.set("state", 0);
		if(m.update()){
		List<Record> rlist= rizhlist();
		return rlist;	
		}
		return null;
		
	}
	
	/**
	 * 
	 */
	
	public List<Record> rizhlist(){
		
		List<Record> r= dao.rizhlist();
		return r;
	}
	
	

	
}
