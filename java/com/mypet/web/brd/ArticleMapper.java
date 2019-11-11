 package com.mypet.web.brd;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.mypet.web.cur.Customer;
import com.mypet.web.pxy.Proxy;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article param);
	public String countArticle();
	public List<Article> selectAll(Proxy pxy);
	public void createArticles(HashMap<String, String> paramMap);
}