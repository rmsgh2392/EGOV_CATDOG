package com.mypet.web.brd;
import java.util.HashMap;
import java.util.List;
import com.mypet.web.pxy.PageProxy;

public interface ArticleMapper {
	public void insertArticle(Articles param);
	public String countArticle();
	public List<Articles> selectAllArticle(PageProxy proxy);
	public void deleteArticle(Articles param);
	public void updateArticle(Articles param);
	public Articles getArticle(Articles param);
	public void createArticles(HashMap<String,String> paramMap);

}
