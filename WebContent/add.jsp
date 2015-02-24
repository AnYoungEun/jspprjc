<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%
	//protected void service(HttpServletRequest request,
		//	HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8"); // 이거 안하면 톰캣설정대로 인코딩됨
		//response.setContentType("text/html; charset=UTF-8"); // 이거안하면 브라우저 방식대로 인코딩됨

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
				//ServletContext application = request.getServletContext();
				application.setAttribute("sum", _sum);
				System.out.println("saved in app");
				System.out.println("_save:"+_save);
			}
			
			else if(_save.equals("session")){
				//HttpSession session = request.getSession();
				session.setAttribute("sum", _sum);
				System.out.println("saved in session"); // 저장소가 서버에 있다
			}
			else if(_save.equals("session")){
				//HttpSession session = request.getSession();
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
		
		//PrintWriter out = response.getWriter();
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
	<body>
	
	
		<form action="add.jsp" method="post">
			<ul>
				<li><label for="x">X:</label><input name="x" /> </li>
				<li><label for="y">Y:</label><input name="y" /> </li>
				<li><label for="y">sum:</label><input name="sum" value="<%=sum%> " /> </li>
			</ul>
			<p> <input type = "submit" name="sum" value = "덧셈" /> </p>
			<p> <input type = "submit" name="save" value = "앱" /> </p>
			<p> <input type = "submit" name="save" value = "session" /> </p>
			<p> <input type = "submit" name="save" value = "session" /> </p>
			<p> <input type = "submit" name="save" value = "cookie" /> </p>
			<p> <a href="index">HOME</a> </p>
		</form>
	</body>
</html>