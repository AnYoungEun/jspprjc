package com.sistcommu.jspprjc.model;

import java.util.Date;

public class NoticeFile {
	private String code;
	private String src;
	private Date regdate;
	private String description;
	private String noticeCode;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getSrc() {
		return src;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getNoticeCode() {
		return noticeCode;
	}
	
	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}
	
}
