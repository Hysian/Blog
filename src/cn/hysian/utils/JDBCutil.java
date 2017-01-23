package cn.hysian.utils;
import java.sql.*;

public class JDBCutil {
	private final String URL = "jdbc:mysql://localhost/myblog";
	private final String USER = "root";
	private final String PASS = "oc7120";
	private Connection conn = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败");
		}
	}
	
	public boolean createConnection(){
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("数据库连接失败");
		}
		return true;
	}
	
	public boolean exeUpdate(String sql){
		try {
		if(conn == null){
			createConnection();
		}
		
			Statement stmt = conn.createStatement();
			int Count = stmt.executeUpdate(sql);
			System.out.println("执行了操作"+Count+"次");
			return true;
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}
	
	public ResultSet exeQuery(String sql){
		ResultSet rs;
		if(conn == null){
			createConnection();
		}
		try{
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		}catch(SQLException e){
			e.getMessage();
			System.out.println("执行查询失败");
			return null;
		}
	}
	
}
