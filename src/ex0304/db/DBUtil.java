package ex0304.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB 연동을 위한 로드, 연결, 닫기 기능 제공
 * */
public class DBUtil {
	/**
	 * 로드
	 * */
	static {
		try {
		  Class.forName(DbProperties.DRIVER_NAME);//이때 오라클 드라이버를 찾는다.
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 연결
	 * */
	public static Connection getConnection() throws SQLException{
		//return DriverManager.getConnection("jdbc:oracle:thin:@211.250.90.99:1521:xe", "scott", "TIGER");
		//return DriverManager.getConnection("jdbc:oracle:thin:@211.250.90.99:1521:xe", "baeeunjin", "1234");
		//return DriverManager.getConnection("jdbc:oracle:thin:@211.250.90.99:1521:xe", "kimsoyoung", "1234");
		
		return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_NAME, DbProperties.USER_PASS);
	}
	
	/**
	 * 닫기(DML인경우)
	 * */
	public static void dbClose(Connection con, Statement st) {//Statement or PreparedStatement
		try {
		  if(st!=null) st.close();
		  if(con!=null) con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기 (SELECT인경우)
	 * */
     public static void dbClose(Connection con, Statement st , ResultSet rs) {
    	 try {
          if(rs !=null)rs.close();
   		  
          dbClose(con, st);
          
   		}catch (SQLException e) {
   			e.printStackTrace();
   		}
	}
     
     public static void main(String[] args) {
		System.out.println(1);
	}
	

}











