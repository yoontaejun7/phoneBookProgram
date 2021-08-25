package kr.or.mrhi.sixclass;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtility {
	public static Connection getConnection() {
		Connection con = null;
		try {
			//주석1
			Properties properties = new Properties();
			String filePath = DataBaseTest.class.getResource("db.properties").getPath();
			filePath = URLDecoder.decode(filePath, "utf-8");
			properties.load(new FileReader(filePath)); 
			//바인딩하기
			String driver = properties.getProperty("DRIVER");
			String url = properties.getProperty("URL");
			String userID = properties.getProperty("userID");
			String userPassword = properties.getProperty("userPassword");
			//드라이버 로드하기
			Class.forName(driver);
			//데이터베이스 연결하기
			con = DriverManager.getConnection(url, userID, userPassword);
			
		} catch (Exception e) {
			System.out.println("Mysql Database connection failed");
			e.printStackTrace();
		}
		return con;
	}
}
