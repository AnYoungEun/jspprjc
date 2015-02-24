<%@page import="com.sistcommu.jspprjc.dao.MemberDao"%>
<%@page import="com.sistcommu.jspprjc.dao.jdbc.jdbcMemberDao"%>
<%@page import="com.sistcommu.jspprjc.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	
	MemberDao m = new jdbcMemberDao();
	Member member = m.getMember(uid);
	//MemberDao m = new jdbcMemberDao().getMember(uid);
	
	String msg="";
	
	if(member == null){
		msg = "회원이 존재하지않습니다";}
	else if(!member.getPwd().equals(pwd)){
		msg = "비밀번호가 맞지않습니다.";}
	else{//로그인성공
		session.setAttribute("uid", uid);}
		
	if(!msg.equals("")){	
	request.setAttribute("msg", msg);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	
	dispatcher.forward(request, response);
	}
	
	response.sendRedirect("../index.jsp");
%>
