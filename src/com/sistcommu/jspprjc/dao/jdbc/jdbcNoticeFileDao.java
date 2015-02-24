package com.sistcommu.jspprjc.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistcommu.jspprjc.dao.NoticeFileDao;
import com.sistcommu.jspprjc.model.Notice;
import com.sistcommu.jspprjc.model.NoticeFile;

public class jdbcNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getNoticeFiles(String NoticeCode) {
		
		/*String sql = "select * from ("
				+ " select rownum num, N.* from ("
				+ "select * from notices where "+field+" like ? order by regdate desc) N )"
				+ " where num between ? and ?";*/
		
		String sql = "select * from NoticeFiles where NoticeCode = ?";
		
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, NoticeCode);
			/*st.setString(1, "%"+query+"%");
			st.setInt(2, start);
			st.setInt(3, end);*/
			
			ResultSet rs = st.executeQuery();
			
			List<NoticeFile> list = new ArrayList<NoticeFile>();
			
			while(rs.next())
			{
				//모델마련하기
			    NoticeFile n = new NoticeFile();
			    
			    n.setCode(rs.getString("code"));
			    n.setSrc(rs.getString("src"));
			    n.setRegdate(rs.getDate("Regdate"));
			    n.setDescription(rs.getString("description"));
			    n.setNoticeCode(rs.getString("noticecode"));
			    
			    list.add(n);
			}
		    
		    rs.close();
		    st.close();
		    con.close();
		    
		    return list;
			
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public int insert(NoticeFile file) {
		
		String sqlcode = "select isnull(max(cast(code as int)),0)+1 code from notices";
		
		String sql = "insert into NoticeFiles(code,src,Regdate,Description,NoticeCode) values(?,?,GETDATE(),?,?)";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
			
			Statement stcode = con.createStatement();
			ResultSet rs = stcode.executeQuery(sqlcode);
			
			rs.next();
			
			String code = rs.getString("code");

			rs.close();
			stcode.close();
			
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행 //preparedStatement 값을꽂아줌 꽂을값이 있으면 프리페얼드
		    
		    st.setString(1, code);
		    st.setString(2, file.getSrc());
		    st.setString(3, file.getDescription());
		    st.setString(4, file.getNoticeCode());
		    
		    int result = st.executeUpdate();
		    
		    st.close();
		    con.close();
		    
		    return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return 0;
	}

}
