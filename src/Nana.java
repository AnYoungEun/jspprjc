import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nana")
public class Nana extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// reflection
		//OutputStream os = response.getOutputStream(); // euc-kr방식으로 얻음
		//PrintWriter out = new PrintWriter(os, true);
		
		response.setCharacterEncoding("UTF-8"); // 이거 안하면 톰캣설정대로 인코딩됨
		response.setContentType("text/html; charset=UTF-8"); // 이거안하면 브라우저 방식대로 인코딩됨
		
		//http://www.sistcommu.com/hello?cnt=1
		String _cnt = request.getParameter("cnt");
		int cnt = 100;
		
		if(_cnt != null)
		{
			cnt = Integer.parseInt(_cnt);
		}
		
		PrintWriter out = response.getWriter(); // 서유럽 코드방식으로 얻음
		for (int i = 0; i < cnt; i++) {
			out.println("안녕 Servlet!!" + (i+1)+"<br />");
		}
	}
}
