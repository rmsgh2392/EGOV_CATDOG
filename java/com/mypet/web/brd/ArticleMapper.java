package com.mypet.web.brd;
import java.util.List;
import com.mypet.web.pxy.Proxy;

public interface ArticleMapper {
	public void insertArticle(Articles param);
	public String countArticle();
	public List<Articles> selectAllArticle(Proxy proxy);
	public void deleteArticle(Articles param);
	public void updateArticle(Articles param);
	public Articles getArticle(Articles param);

}
