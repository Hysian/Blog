package cn.hysian.dao;

import java.util.List;

import cn.hysian.pojo.Article;

public interface ArticleDao {
	
	public List<Article> getArticles();
	
	public Article getArticle(int id);
	
	public int updateArtcle(Article form);
	
	public int addArticle(Article form);
	
	public int deleteArtcle(int id);
	
	public int countArtcle(int id);
	
	
}