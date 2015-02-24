package com.sistcommu.jspprjc.dao;

import java.util.List;

import com.sistcommu.jspprjc.model.Notice;

public interface NoticeDao {
	public Notice getNotice(String code);
	public Notice prevNotice(String curCode);
	public Notice nextNotice(String curCode);
	public List<Notice> getNotices(int page,String query,String field);
	public List<Notice> getNotices(int page,String query);
	public List<Notice> getNotices(int page);
	public int insert(Notice notice);
	public int update(Notice notice);
	public int getSize(String query, String field);
	public int getSize(String query);
	public int delete(String code);
	public String lastCode();
	
}
