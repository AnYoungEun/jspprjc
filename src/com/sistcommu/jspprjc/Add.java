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

@WebServlet("/add")
public class Add extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); // 이거 안하면 톰캣설정대로 인코딩됨
		response.setContentType("text/html; charset=UTF-8"); // 이거안하면 브라우저 방식대로 인코딩됨

		int x = 0;
		int y = 0;

		if (request.getMethod().equals("POST")) {
			String _x = request.getParameter("x");
			String _y = request.getParameter("y");
			
			if(_x != null && !_x.equals("")) 
				x = Integer.parseInt(_x);
			if(_y != null && !_y.equals(""))
				y = Integer.parseInt(_y);
		}

		int sum = x + y;
		int min = x - y;
		
		String _save = request.getParameter("save");
		
		if(_save != null){
			String _sum = request.getParameter("sum");
			String _min = request.getParameter("min");
			
//			_save = new String(_save.getBytes("ISO-8859-1"),"UTF-8"); // 요청을 한후에 한국어 설정을 바꿀때
			
			if(_save.equals("앱")){
				ServletContext application = request.getServletContext();
				application.setAttribute("sum", _sum);
				System.out.println("saved in app");
				System.out.println("_save:"+_save);
			}
			
			else if(_save.equals("session")){
				HttpSession session = request.getSession();
				session.setAttribute("sum", _sum);
				System.out.println("saved in session"); // 저장소가 서버에 있다
			}
			else if(_save.equals("session")){
				HttpSession session = request.getSession();
				session.setAttribute("min", _min);
				System.out.println("saved in session"); // 저장소가 서버에 있다
			}
			else if(_save.equals("cookie"))
			{
				Cookie cookie = new Cookie("sum",_sum);
				cookie.setMaxAge(24*60*60); // 24시간 60분 60초
				response.addCookie(cookie);
				System.out.println("saved in cookie"); // 저장소가 클라이언트에 있다
			}
		}
		
		/*if(request.getParameter("save") != null)
		{
			ServletContext application = request.getServletContext(); // servletcontext는 서블릿들의 공유 데이터
			String _sum = request.getParameter("sum");
			application.setAttribute("sum", _sum); // _sum에 sum의 값을 set한다// 꺼낼때는 get
		}*/
		
		PrintWriter out = response.getWriter();

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"EUC-KR\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"add\" method=\"post\">");
		out.write("		<ul>");
		out.write("			<li><label for=\"x\">X:</label><input name=\"x\" /> </li>");
		out.write("			<li><label for=\"y\">Y:</label><input name=\"y\" /> </li>");
		out.write("			<li><label for=\"y\">sum:</label><input name=\"sum\" value=\"" + sum	+ "\" /> </li>");
		out.write("		</ul>");
		out.write("		<p> <input type = \"submit\" name=\"sum\" value = \"덧셈\" /> </p>");
		out.write("		<p> <input type = \"submit\" name=\"save\" value = \"앱\" /> </p>");
		out.write("		<p> <input type = \"submit\" name=\"save\" value = \"session\" /> </p>");
		out.write("		<p> <input type = \"submit\" name=\"save\" value = \"session\" /> </p>");
		out.write("		<p> <input type = \"submit\" name=\"save\" value = \"cookie\" /> </p>");
		out.write("		<p> <a href=\"index\">HOME</a> </p>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
		
	}

	/*@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}*/
}