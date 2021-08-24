package ex0304.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB ������ ���� �ε�, ����, �ݱ� ��� ����
 * */
public class DBUtil {
	/**
	 * �ε�
	 * */
	static {
		try {
		  Class.forName(DbProperties.DRIVER_NAME);//�̶� ����Ŭ ����̹��� ã�´�.
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ����
	 * */
	public static Connection getConnection() throws SQLException{
		//return DriverManager.getConnection("jdbc:oracle:thin:@211.250.90.99:1521:xe", "scott", "TIGER");
		//return DriverManager.getConnection("jdbc:oracle:thin:@211.250.90.99:1521:xe", "baeeunjin", "1234");
		//return DriverManager.getConnection("jdbc:oracle:thin:@211.250.90.99:1521:xe", "kimsoyoung", "1234");
		
		return DriverManager.getConnection(DbProperties.URL, DbProperties.USER_NAME, DbProperties.USER_PASS);
	}
	
	/**
	 * �ݱ�(DML�ΰ��)
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
	 * �ݱ� (SELECT�ΰ��)
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











