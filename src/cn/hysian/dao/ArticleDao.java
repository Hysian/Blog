package cn.hysian.dao;

import java.util.List;

import cn.hysian.pojo.Article;

public interface ArticleDao {
	//返回文章列表
	public List<Article> getArticles();
	//单个文章
	public Article getArticle(int id);
	//修改文章
	public int updateArtcle(Article form);
	//增加文章
	public int addArticle(Article form);
	//删除文章
	public int deleteArtcle(int id);
	//访问量
	public int countArtcle(int id);
	
	
}