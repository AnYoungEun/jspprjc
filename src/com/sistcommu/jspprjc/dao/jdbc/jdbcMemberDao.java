package com.sistcommu.jspprjc.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistcommu.jspprjc.dao.MemberDao;
import com.sistcommu.jspprjc.dao.NoticeDao;
import com.sistcommu.jspprjc.model.Member;
import com.sistcommu.jspprjc.model.Notice;

public class jdbcMemberDao implements MemberDao{

	@Override
	public Member getMember(String uid) {
		String sql="select * from members where Mid=?";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // mssql
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행
		    
		    st.setString(1, uid);
		    
		    ResultSet rs = st.executeQuery();
			rs.next();
		    
		    //모델마련하기
		    Member n = new Member();
		    
		    n.setUid(rs.getString("mid"));
		    n.setPwd(rs.getString("pwd"));
		    n.setName(rs.getString("name"));
		    
			rs.close();
			st.close();
			con.close();
			
			return n;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
