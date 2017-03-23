package cn.hysian.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private final String URL = "jdbc:mysql://localhost/myblog";
	private final String USER = "root";
	private final String PASS = "oc7120";
	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("驱动加载失败");
		}
	}
	
	protected Connection getConnection(){
		try {
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		}
		return con;
	}
	
	protected boolean closeConnection(){
		try {
			if (null != con) {
				con.close();
			}else if (null != ps) {
				ps.close();
			}else if (null != rs) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
