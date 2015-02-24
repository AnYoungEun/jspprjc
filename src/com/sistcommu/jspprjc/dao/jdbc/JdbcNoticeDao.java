package com.sistcommu.jspprjc.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistcommu.jspprjc.dao.NoticeDao;
import com.sistcommu.jspprjc.model.Notice;

public class JdbcNoticeDao implements NoticeDao{

	@Override
	public Notice getNotice(String code) {
		// TODO Auto-generated method stub
		String sql="select * from notices where code='"+code+"'";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // mssql
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    Statement st = con.createStatement(); // 문장실행
		    ResultSet rs = st.executeQuery(sql); // 결과집합
		    
		    rs.next();
		    
		    //while(rs.next())
		    //	System.out.println(rs.getString("SID"));//db 연결을 위한 쿼리
		    
		   /*  String title = rs.getString("TITLE");
		    Date regdate = rs.getDate("REGDATE");
		    String writer = rs.getString("WRITER");
		    int hit = rs.getInt("HIT");
		    String content = rs.getString("CONTENT"); */
		    
		    //모델마련하기
		    Notice n = new Notice();
		    
		    n.setCode(rs.getString("code"));
		    n.setTitle(rs.getString("title"));
		    n.setRegdate(rs.getDate("regdate"));
		    n.setWriter(rs.getString("writer"));
		    n.setHit(rs.getInt("hit"));
		    n.setContent(rs.getString("content"));
		    
		    /* pageContext.setAttribute("title",rs.getString("TITLE"));
		    pageContext.setAttribute("regdate",rs.getDate("REGDATE"));
		    pageContext.setAttribute("writer",rs.getString("WRITER"));
		    pageContext.setAttribute("hit",rs.getString("HIT"));
		    pageContext.setAttribute("content",rs.getString("CONTENT")); */
		    
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
	
	@Override
	public Notice prevNotice(String curCode) {
		// TODO Auto-generated method stub
		
		String sql="select top 1 * from notices where regdate > (select regdate from notices where code=?) order by regdate";
		
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
	
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, curCode);
			
			ResultSet rs = st.executeQuery();
			
			rs.next();
			
			//모델마련하기
		    Notice n = new Notice();
		    
		    n.setCode(rs.getString("code"));
		    n.setTitle(rs.getString("title"));
		    n.setRegdate(rs.getDate("Regdate"));
		    n.setWriter(rs.getString("Writer"));
		    n.setHit(rs.getInt("Hit"));
			    
		    
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

	@Override
	public Notice nextNotice(String curCode) {
		String sql="select top 1 * from notices where regdate < (select regdate from notices where code='237') order by regdate desc";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // mssql
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    Statement st = con.createStatement(); // 문장실행
		    ResultSet rs = st.executeQuery(sql); // 결과집합
		    
		    rs.next();
		    
		    Notice n = new Notice();
		    
		    n.setCode(rs.getString("code"));
		    n.setTitle(rs.getString("title"));
		    n.setRegdate(rs.getDate("regdate"));
		    n.setWriter(rs.getString("writer"));
		    n.setHit(rs.getInt("hit"));
		    
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


	@Override
	public List<Notice> getNotices(int page, String query, String field) {
		// TODO Auto-generated method stub
		
		int start = 1+(page-1)*20;
		int end = 20+(page-1)*20;
		
		/*String sql = "select * from ("
				+ " select rownum num, N.* from ("
				+ "select * from notices where "+field+" like ? order by regdate desc) N )"
				+ " where num between ? and ?";*/
		
		String sql="select n.* from ("
				+ "select (row_number() over (order by regdate desc)) num, notices.* from notices where "+field+" like ?) n "
				+ "where n.num between ? and ?";
		
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
	    try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, "%"+query+"%");
			st.setInt(2, start);
			st.setInt(3, end);
			
			ResultSet rs = st.executeQuery();
			
			List<Notice> list = new ArrayList<Notice>();
			
			while(rs.next())
			{
				//모델마련하기
			    Notice n = new Notice();
			    
			    n.setCode(rs.getString("code"));
			    n.setTitle(rs.getString("title"));
			    n.setRegdate(rs.getDate("Regdate"));
			    n.setWriter(rs.getString("Writer"));
			    n.setHit(rs.getInt("Hit"));
			    n.setContent(rs.getString("Content"));
			    
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
	public List<Notice> getNotices(int page, String query) {
		// TODO Auto-generated method stub
		return getNotices(page,query,"TITLE");
	}
	
	@Override
	public List<Notice> getNotices(int page) {
		// TODO Auto-generated method stub
		/*return getNotices(page,"","TITLE");*/
		return getNotices(page,"");
	}

	@Override
	public int insert(Notice notice) {
		String sqlcode = "select isnull(max(cast(code as int)),0)+1 code from notices";
		
		String sql = "insert into notices(code,title,writer,content,regdate,hit) values(?,?,?,?,GETDATE(),0)";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
			
			Statement stcode = con.createStatement();
			ResultSet rs = stcode.executeQuery(sqlcode);
			
			rs.next();
			
			String code = rs.getString("CODE");

			rs.close();
			stcode.close();
			
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행 //preparedStatement 값을꽂아줌 꽂을값이 있으면 프리페얼드
		    
		    st.setString(1, code);
		    st.setString(2, notice.getTitle());
		    st.setString(3, notice.getWriter());
		    st.setString(4, notice.getContent());
		    
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

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		String sql = "update notices set TITLE = ?,CONTENT = ? where code =? ";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행, 값을 꽂아야함
		    
		    st.setString(1, notice.getTitle());
		    st.setString(2, notice.getContent());
		    st.setString(3, notice.getCode());
		    
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

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		String sql = "delete notices where code=?";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행
		    
		    st.setString(1, code);
		    
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

	@Override
	public int getSize(String query, String field) {
		// TODO Auto-generated method stub
		String sql="select count(*) CNT from notices where "+field+" like ?";
		/*String url = "jdbc:oracle:thin:@win.newlecture.com:1521:orcl";*/ //oracle
	      String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb"; // mssql
	    
	    try {
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    PreparedStatement st = con.prepareStatement(sql); // 문장실행
		    st.setString(1, "%"+query+"%");
		    
		    ResultSet rs = st.executeQuery(); // 결과집합
		    rs.next();
		    
		    int size=rs.getInt("CNT");
		    
		    rs.close();
		    st.close();
		    con.close();
		    
		    return size;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return 0;
	}

	@Override
	public int getSize(String query) {
		// TODO Auto-generated method stub
		return getSize(query,"TITLE");
	}

	@Override
	public String lastCode() {
		String sql="select isnull(max(cast(code as int)),0) code from notices";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		try {
	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url,"sist","newlec"); //연결
		    Statement st = con.createStatement(); // 문장실행
		    ResultSet rs = st.executeQuery(sql); // 실행되어야함
		    
		    rs.next();
		    String code =  rs.getString("code");
		    
		    rs.close();
		    st.close();
		    con.close();
		    
		    return code;
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
