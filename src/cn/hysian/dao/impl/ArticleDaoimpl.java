package cn.hysian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hysian.dao.ArticleDao;
import cn.hysian.dao.BaseDao;
import cn.hysian.pojo.Article;

public class ArticleDaoimpl extends BaseDao implements ArticleDao{

	@Override
	public List<Article> getArticles() {
		getConnection();
		String sql = "SELECT * FROM article";
		List<Article> list = new ArrayList();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Article article = new Article();
				article = new Article();
				article.setId(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setContent(rs.getString(3));
				article.setUpTime(rs.getString(4));
				article.setNumber(rs.getInt(5));
				list.add(article);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally{
			closeConnection();
		}
		return list;
	}

	@Override
	public Article getArticle(int id) {
		getConnection();
		String sql = "SELECT * FROM article WHERE id =?";
		Article article = new Article();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			article = new Article();
			article.setId(rs.getInt(1));
			article.setTitle(rs.getString(2));
			article.setContent(rs.getString(3));
			article.setUpTime(rs.getString(4));
			article.setNumber(rs.getInt(5));
		} catch (SQLException e) {
			System.out.println(e);
		} finally{
			closeConnection();
		}
		return article;
	}

	@Override
	public int addArticle(Article form) {
		getConnection();
		String sql = "INSERT article(title,content,upTime,number) VALUES(?,?,?,'"+1+"')";
		int num = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getContent());
			ps.setString(3, form.getUpTime());
			num = ps.executeUpdate();
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			closeConnection();
		}
		return num;
	}

	private int doArticle(String sql, int id){
		getConnection();
		int num = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			num = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		return num;
	}
	
	@Override
	public int deleteArtcle(int id) {
		String sql = "DELETE FROM article WHERE id =?";
		return doArticle(sql, id);
	}

	@Override
	public int countArtcle(int id) {
		String sql = "UPDATE article SET number=number+1 WHERE id =?";
		return doArticle(sql, id);
	}

	@Override
	public int updateArtcle(Article form) {
		getConnection();
		String sql = "UPDATE article SET title =?,content =?,upTime =?,number =? WHERE id =?";
		int num = 0;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, form.getTitle());
			ps.setString(2, form.getContent());
			ps.setString(3, form.getUpTime());
			ps.setInt(4, form.getNumber());
			ps.setInt(5, form.getId());
			num = ps.executeUpdate();
		}catch(SQLException e){
			System.out.println(e);
		}finally{
			closeConnection();
		}
		return num;
	}

}
