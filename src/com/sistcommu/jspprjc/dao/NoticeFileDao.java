package com.sistcommu.jspprjc.dao;

import java.util.List;

import com.sistcommu.jspprjc.model.NoticeFile;

public interface NoticeFileDao {
	public List<NoticeFile> getNoticeFiles(String NoticeCode);
	public int insert(NoticeFile file);
}
