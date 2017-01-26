package cn.hysian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import cn.hysian.bean.ArticleBean;
import cn.hysian.utils.JDBCutil;

public class ArticleDao {
	private Connection conn = null;
	private ArticleBean articlebean = null;
	private PreparedStatement ps = null;
	String sql = null;
	
	public ArticleDao(){
		conn = JDBCutil.getConnection();
	}
	
	/**
	 * 增加或修改文章
	 * @param operation
	 * @param form
	 * @return
	 */
	public int upArticle(String operation, ArticleBean form){
		
//		boolean flag = false;
		int i = 0;
		
		switch(operation){
			case "add": sql = "INSERT article(title,content,upTime,number) VALUES(?,?,?,'"+1+"')";
		break;		
			case "update": sql = "UPDATE article SET title='"+form.getTitle()+"',content='"+
					form.getContent()+"'";
		break;
		}
		
		try{
			ps = conn.prepareStatement(sql);
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getContent());
			ps.setString(3, form.getUpTime());
			i = ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			JDBCutil.free(null, ps, conn); 
		}
		System.out.println(i);
		return i;
	}
	
	/**
	 * 删除或记录阅读数
	 * @param operation
	 * @param id
	 * @return
	 */
	public int exeArticle(String operation, int id){
		int flag = 0;			
		switch(operation){
			case "delete": sql = "DELETE FROM article WHERE id =?";
		break;
			case "count": sql = "UPDATE article SET number=number+1 WHERE id =?";
		break;
		}
		try{
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			flag = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCutil.free(null, ps, conn); 
		}
		System.out.println(flag);
		return flag;
		
		
	}
	
	public List ArticleList(){
		List list = new ArrayList();
		sql = "SELECT * FROM article";
		try{
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				articlebean = new ArticleBean();
				articlebean.setId(rs.getInt(1));
				articlebean.setTitle(rs.getString(2));
				articlebean.setContent(rs.getString(3));
				articlebean.setUpTime(rs.getString(4));
				articlebean.setNumber(rs.getInt(5));
				list.add(articlebean);
		}
		}catch(SQLException e){
			e.getMessage();
			System.out.println("获取失败");
		}
		return list;
	}
	
	public ArticleBean queArticle(int id){
		sql = "SELECT * FROM ARTICLE WHERE id =?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				articlebean = new ArticleBean();
				articlebean.setId(rs.getInt(1));
				articlebean.setTitle(rs.getString(2));
				articlebean.setContent(rs.getString(3));
				articlebean.setUpTime(rs.getString(4));
				articlebean.setNumber(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.exeArticle("count", articlebean.getId());//查询+1
		return articlebean;
	}

}
