package cn.hysian.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hysian.bean.ArticleBean;
import cn.hysian.utils.JDBCutil;

public class ArticleDao {
	private JDBCutil connection = null;
	private ArticleBean articlebean = null;
	String sql = null;
	
	public ArticleDao(){
		connection = new JDBCutil();
	}
	
	public boolean upArticle(String operation, ArticleBean form){
		boolean flag = false;
		
		switch(operation){
			case "add": sql = "INSERT article(title,content,upTime,number) VALUES('"+form.getTitle()+
					"','"+form.getContent()+"','"+form.getUpTime()+"','"+0+"')";
		break;
			
			case "update": sql = "UPDATE article SET title='"+form.getTitle()+"',content='"+
					form.getContent()+"'";
		break;

		}
		if(connection.exeUpdate(sql)){
			flag = true;
		}
		return flag;
	}
	
	public boolean exeArticle(String operation, int id){
		boolean flag = false;
				
		switch(operation){
			case "delete": sql = "DELETE FROM article WHERE id = '"+id+"'";
		break;
			case "count": sql = "UPDATE article SET number=number+1 WHERE id ='"+id+"'";
		break;
		}
		if(connection.exeUpdate(sql)){
			flag = true;
		}
		return flag;
	}
	
	public List ArticleList(){
		List list = new ArrayList();
		sql = "SELECT * FROM article";
		ResultSet rs = connection.exeQuery(sql);
		try{
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
		sql = "SELECT * FROM ARTICLE WHERE id = '"+id+"'";
		ResultSet rs = connection.exeQuery(sql);
		try {
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
		this.exeArticle("count",articlebean.getId());//查询+1
		return articlebean;
	}
//	public static void main(String args[]){
//		
//		ArticleDao p = new ArticleDao();
//		List list = p.ArticleList();
//		for(int i = 0; i<list.size(); i++){
//			System.out.println(list.get(i));
//		}
//	}
}
