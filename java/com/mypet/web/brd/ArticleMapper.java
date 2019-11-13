package com.mypet.web.brd;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mypet.web.pxy.PageProxy;
@Repository
public interface ArticleMapper {
	public void insertArticle(Articles param);
//	public String countArticle();
	public List<Articles> selectAllArticle(PageProxy proxy);
	public void deleteArticle(Articles param);
	public void updateArticle(Articles param);
	public Articles getArticle(Articles param);
	public void createArticles(HashMap<String,String> paramMap);
	public void dropArticles(HashMap<String,String> paramMap);
	public int countArticles();

}
