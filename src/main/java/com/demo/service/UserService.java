package com.demo.service;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.demo.common.model.User;
import com.demo.unit.getTime;
import com.jfinal.plugin.activerecord.Record;



public class UserService {
	public static final UserService me = new UserService();
	
	private  User dao=new User().dao();
//	private User dao = new User().dao();
	
	public static Record getcode(int id){
		return    ErrorcodeService.me.geterrmsg(id);
	}
	
//	注冊
	
	public boolean add(String account, String psw, String name) {
		// TODO Auto-generated method stub
	
		 User m=new User();
		 m.set("account", account);
		 m.set("psw", psw);
		 m.set("name", name);
		 m.set("create_time", getTime.nowtime());
	
		 if( m.save()){
			 return true;
		 }
				return false;
		 
	
	}
	
//	登陸
	
	public Record login(String account,String psw){
		
		Record r=get(account);
//		List<Record> listCopy = new ArrayList<Record>();
		
		r.setColumns(getcode(1));
		if(r!=null&&psw.equals(r.get("psw"))){
		
			List<Record> blogList  = BlogService.me.getUserBlog(r.getInt("id"));
			r.set("rizhilist", blogList);
			
			return r;
		}
		return null;
		
	}
	
	
//	。。。。。。。。。。。。。。。。。
	public List<Record> getlist(int id){
	 List<Record> getlist = dao.getlist(id);

		return getlist;
		
	}
	
	public boolean updapsw(int id,String psw){
		boolean v = dao.updataspw(id, psw);
		
		return v;
		
		
	}
	
	public Record getUser(int id){
		Record r = dao.getUser(id);
		return r;
		
	}

	
	
	
	
	public Record get(String account){
		Record r = dao.get(account);
		return r;
		
	}

	public boolean changuserinfo(int id,String account,String psw){
	boolean t=dao.changuserinfo(id, account, psw);
	return t;
//		User m = new User();
//	
//		m.set("account", account);
//		m.set("psw", psw);
//		 if( m.save()){
//			 return true;
//		 }
//				return false;
//		 
//		
	}
	
	
}
