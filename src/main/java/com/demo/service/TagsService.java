package com.demo.service;

import java.util.List;

import com.demo.common.model.Tags;
import com.jfinal.plugin.activerecord.Record;

public class TagsService {
		public static final TagsService me= new TagsService(); 
		private Tags dao = new Tags().dao();
		
		
		
		public List<Record> listTags(){
			
			return dao.listTags();
			
			
			
		}
		
}
