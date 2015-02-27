<%@page import="com.sistcommu.jspprjc.model.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.sistcommu.jspprjc.dao.jdbc.JdbcNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
  String _page = request.getParameter("p");
 int pg = Integer.parseInt(_page); 
 
 List<Notice> list = new JdbcNoticeDao().getNotices(1);
 
 String data = "[";
 
 for(int i=0; i<list.size(); i++)
 {
	 Notice n = list.get(i);
	 
	 data += String.format("{'code':'%s', 'title':'%s', 'content':'%s'}"
			 , n.getCode(), n.getTitle(), n.getContent());
			 
			 if(i<=list.size()-2)
				 data +=",";
 }
	 data += "]";
 
 out.write(data);
 %>