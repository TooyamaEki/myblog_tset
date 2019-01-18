package com.demo.service;

import com.demo.common.model.Errorcode;
import com.demo.common.model.Tags;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.template.io.ByteWriter;


public class ErrorcodeService  {
	public  static final ErrorcodeService me = new ErrorcodeService();
	private Errorcode dao = new Errorcode().dao();

	public Record geterrmsg(int code){
		Record r=dao.geterrmsg(code);	
		r.keep("msg","code");
		
		return r;
	}
}
