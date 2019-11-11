package com.mypet.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mypet.web.pxy.Proxy;
import com.mypet.web.user.User;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article param);
	public String countArtseq();
	public List<Article> selectAll(Proxy pxy);
	public Article selectArticle(String articleseq);
	public void deleteArticle(Article param);
	public void modify(Article param);

}
