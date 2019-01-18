package com.demo.common.model;



import java.util.List;

import com.demo.common.model.base.BaseBlog;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * 
 * Blog model.
 * 数据库字段名建议使用驼峰命名规则，便于与 java 代码保持一致，如字段名： userId
 */
@SuppressWarnings("serial")
public class Blog extends BaseBlog<Blog> {
	
	public List<Record> getblog(int uid){
		String sql = "SELECT * FROM blog WHERE u_id = ?";
		return Db.find(sql, uid);
	}
	
	
	public boolean delectblog(int id){
		
		String sql = "UPDATE blog SET state=0 WHERE id=?";

		
		return Db.update(sql,id)>0;
		
	}
	
	
	/**
	 * 获取所有不为0的日志
	 */
public List<Record> rizhlist(){
		
		String sql = "SELECT * FROM blog WHERE state = 1";
		
		return Db.find(sql);
	
		
	}
	
	
	
}
