<%@page import="com.sistcommu.jspprjc.dao.NoticeDao"%>
<%@page import="com.sistcommu.jspprjc.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.sistcommu.jspprjc.model.Notice"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String code = request.getParameter("code");
	
	Notice notice = new Notice();
	
	notice.setCode(code);
	notice.setTitle(title);
	notice.setContent(content);
	
	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.update(notice);
	
	response.sendRedirect("noticeDetail.jsp?c="+code+"");
	
	/* String url = String.format("noticeDetail.jsp?c=%s", notice.getCode()); */
%>

