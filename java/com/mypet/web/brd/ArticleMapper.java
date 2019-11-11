package com.mypet.web.brd;

import java.util.List;

<<<<<<< HEAD
import com.mypet.web.pxy.Proxy;

public interface ArticleMapper {
	public void insertArticle(Articles param);
	public String countArticle();
	public List<Articles> selectAllArticle(Proxy proxy);
	public void deleteArticle(Articles param);
	public void updateArticle(Articles param);
	public Articles getArticle(Articles param);
=======
import org.springframework.stereotype.Repository;

import com.mypet.web.cus.Customer;
import com.mypet.web.pxy.Proxy;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article param);
	public String countArtseq();
	public List<Article> selectAll(Proxy pxy);
	public Article selectArticle(String articleseq);
	public void deleteArticle(Article param);
	public void modify(Article param);

>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
}
