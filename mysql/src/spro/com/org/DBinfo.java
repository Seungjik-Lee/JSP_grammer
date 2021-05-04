package spro.com.org;

public interface DBinfo {
	String oracle_class = "oracle.jdbc.driver.OracleDriver";
	String oracle_url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	String mysql_class = "com.mysql.cj.jdbc.Driver";
	String mysql_url = "jdbc:mysql://127.0.0.1:3306/spro?useUnicode=true&characterEncoding=UTF-8";
	String mysql_id = "root";
	String mysql_pw = "1234";
}
