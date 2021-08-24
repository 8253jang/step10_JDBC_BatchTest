package ex0308.batch;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ex0304.db.DBUtil;

public class DbBatchExecuteDAO {
  /**
   *  �����ϱ�
   * */
	public static void delete(List<Integer> empnoList) {
		Connection con=null;
		PreparedStatement ps =null;
		String sql="delete from emp where empno=?";
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false); //�Ŀ� commit �Ǵ� rollback ó�� �ʿ��ϴ�.
			
			ps = con.prepareStatement(sql);
			
			for(int empno : empnoList) {
				ps.setInt(1, empno);
				
				ps.addBatch();//�ϰ��۾�ó���� ���� ������ �߰��ϴ� ��.
				ps.clearParameters();
			}
			int ia = Statement.SUCCESS_NO_INFO;
			int result [] = ps.executeBatch();//�ϰ�ó��(DB�� ����)
			System.out.println("ó�� ��� : " + result.length);
			
			for(int i : result) {
				System.out.println(i);//??
			}
			
			con.commit();//����Ϸ�
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
			  con.rollback();
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
	}
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7782,9000,7900,9002);
		delete(list);
	}
	
}//Ŭ������







