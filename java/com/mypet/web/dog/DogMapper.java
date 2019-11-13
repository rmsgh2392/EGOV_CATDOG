package com.mypet.web.dog;

import org.springframework.stereotype.Repository;

@Repository
public interface DogMapper {
	public void registerDog(Dog param);
	public int countDogs();
}
