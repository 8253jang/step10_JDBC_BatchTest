package ex0304.db;

/**
 * DB���� ��� �ʵ�
 * */
public interface DbProperties {
   public static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
   
   //�ҿ���(1 0 1)
   String URL="jdbc:oracle:thin:@dolangdo.cs7vjtdd4qu3.ap-northeast-2.rds.amazonaws.com:1521:DATABASE";
   String USER_NAME="admin";
   String USER_PASS="password";
   
   
   //������ ( 1  0 1 )
  /* String URL="jdbc:oracle:thin:@database-1.cng0cmipx8xl.us-east-2.rds.amazonaws.com:1521:DATABASE";
   String USER_NAME="eunjin";
   String USER_PASS="baebaebae";*/
   
   
   
}



