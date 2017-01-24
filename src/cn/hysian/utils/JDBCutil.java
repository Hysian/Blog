package cn.hysian.utils;
import java.sql.*;

public class JDBCutil {
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection(){
		String URL = "jdbc:mysql://localhost/myblog";
		String USER = "root";
		String PASS = "oc7120";
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void free(ResultSet rs, Statement sta , Connection con){
		try {  
            if(null != rs)  
            {  
                rs.close();  
                rs = null ;  
            }  
              
            if(null != sta)  
            {  
                sta.close();  
                sta = null ;  
            }  
              
            if(null != con)  
            {  
                con.close();  
                con = null ;  
            }  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}

}
