<%@page import="com.sistcommu.jspprjc.dao.NoticeDao"%>
<%@page import="com.sistcommu.jspprjc.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.sistcommu.jspprjc.model.Notice"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%
	String code = request.getParameter("c");
	
	NoticeDao noticeDao = new JdbcNoticeDao();
	noticeDao.delete(code);
	
	response.sendRedirect("notice.jsp?c="+code+"");
	
	/* String url = String.format("noticeDetail.jsp?c=%s", notice.getCode()); */
%>

