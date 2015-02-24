<%@page import="com.sistcommu.jspprjc.dao.NoticeFileDao"%>
<%@page import="com.sistcommu.jspprjc.dao.jdbc.jdbcNoticeFileDao"%>
<%@page import="com.sistcommu.jspprjc.model.NoticeFile"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.sistcommu.jspprjc.dao.NoticeDao"%>
<%@page import="com.sistcommu.jspprjc.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.sistcommu.jspprjc.model.Notice"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%

	ServletContext ctx = request.getServletContext();
	String path = ctx.getRealPath("/customer/upload");
	
	out.println(path+"<br />");
	
	MultipartRequest req = new MultipartRequest(request
			, path
			, 1024*1024*10
			, "UTF-8"
			, new DefaultFileRenamePolicy());

	String title = req.getParameter("title");
	String file = req.getFilesystemName("file");
	String content = req.getParameter("content");
	
	out.print(title+"<br />");
	out.print(file+"<br />");
	out.print(content+"<br />");
	
	Notice notice = new Notice();
	
	notice.setTitle(title);
	notice.setContent(content);
	notice.setWriter("크헝허");
	
	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.insert(notice); 
	
	if(req.getFile("file") != null){
	String noticeCode = noticeDao.lastCode();
	
	NoticeFile noticefile = new NoticeFile();
	noticefile.setDescription("");
	noticefile.setSrc(file);
	noticefile.setNoticeCode(noticeCode);
	
	NoticeFileDao fileDao = new jdbcNoticeFileDao();
	fileDao.insert(noticefile);
	}
	
	response.sendRedirect("notice.jsp");
	
%>

