package ex0304.db;

/**
 * DB관련 상수 필드
 * */
public interface DbProperties {
   public static final String DRIVER_NAME ="oracle.jdbc.driver.OracleDriver";
   
   //소영님(1 0 1)
   String URL="jdbc:oracle:thin:@dolangdo.cs7vjtdd4qu3.ap-northeast-2.rds.amazonaws.com:1521:DATABASE";
   String USER_NAME="admin";
   String USER_PASS="password";
   
   
   //은진님 ( 1  0 1 )
  /* String URL="jdbc:oracle:thin:@database-1.cng0cmipx8xl.us-east-2.rds.amazonaws.com:1521:DATABASE";
   String USER_NAME="eunjin";
   String USER_PASS="baebaebae";*/
   
   
   
}



