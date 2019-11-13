package com.mypet.web.cat;

import java.util.HashMap;

import org.springframework.stereotype.Repository;
@Repository
public interface CatMapper {
	public void registerCat(Cat param);
	public Cat updateCat(Cat param);
	public Cat dropCat(Cat param);
	public int existId(String uid);
	public int countCats();
	public void createCat(HashMap<String, String> paramMap);
	public void dropCat(HashMap<String, String> paramMap);
}
