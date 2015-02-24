package com.sistcommu.jspprjc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index")
public class Index extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); // �̰� ���ϸ� ��Ĺ������� ���ڵ���
		response.setContentType("text/html; charset=UTF-8"); // �̰ž��ϸ� ������ ��Ĵ�� ���ڵ���

		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		String _sumapp = "0";
		String _sumsess = "0";
		String _minsess = "0";
		String _sumcoo = "";

		if (application.getAttribute("sum") != null) {
			_sumapp = application.getAttribute("sum").toString();
		}
		
		if (session.getAttribute("sum") != null) {
			_sumsess = session.getAttribute("sum").toString();
		}
		
		if (session.getAttribute("minus") != null){
			_minsess = session.getAttribute("min").toString();
		}
		
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("sum".equals(cookie.getName())){
					_sumcoo = cookie.getValue();
				}
			}
		}

		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"EUC-KR\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<p><a href=\"add\">����ϱ�</a></p>");
		out.write("<p>������ ��� ��:" + _sumapp + "</p>");
		out.write("<p>������ ��� ��:" + _sumsess + "</p>");
		out.write("<p>������ ��� ��:" + _minsess + "</p>");
		out.write("<p>������ ��� ��:" + _sumcoo + "</p>");
		out.write("</body>");
		out.write("</html>");
	}
}
