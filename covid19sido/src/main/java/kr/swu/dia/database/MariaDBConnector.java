package kr.swu.dia.database;


import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDBConnector {
	private static Connection connection;
	public static Connection getConnection() {    
		try{
			
			
			String db_url="jdbc:mysql://sc1.swu.ac.kr:13306/dlrbqls3024_ts";
			String user="dlrbqls3024";
			String password="dlrbqls302485";
			
			Class.forName("org.mariadb.jdbc.Driver");
			connection = DriverManager.getConnection(db_url, user, password);

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("==========================================");
			// 에러가 발생할경우 Log파일에 쓴다.
		}
		return connection;
	}
}

