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
   *  삭제하기
   * */
	public static void delete(List<Integer> empnoList) {
		Connection con=null;
		PreparedStatement ps =null;
		String sql="delete from emp where empno=?";
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false); //후에 commit 또는 rollback 처리 필요하다.
			
			ps = con.prepareStatement(sql);
			
			for(int empno : empnoList) {
				ps.setInt(1, empno);
				
				ps.addBatch();//일괄작업처리를 위한 문장을 추가하는 것.
				ps.clearParameters();
			}
			int ia = Statement.SUCCESS_NO_INFO;
			int result [] = ps.executeBatch();//일괄처리(DB에 전송)
			System.out.println("처리 결과 : " + result.length);
			
			for(int i : result) {
				System.out.println(i);//??
			}
			
			con.commit();//저장완료
			
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
	
}//클래스끝







