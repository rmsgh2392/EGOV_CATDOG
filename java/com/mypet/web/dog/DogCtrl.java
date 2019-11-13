package com.mypet.web.dog;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypet.web.pxy.Box;
import com.mypet.web.pxy.Trunk;

@RestController
@RequestMapping("/dogs")
public class DogCtrl {
	@Autowired Map<String , Object> map;
	@Autowired Trunk<String> trunk;
	@Autowired Dog dog;
	@Autowired DogMapper dogMapper;
	@Autowired Box<Object> box;
	
	@GetMapping("/")
	public Map<?,?> register(@RequestBody Dog param){
		System.out.println("dog 정보 입력 컨트롤러 들어옴");
		Consumer<Dog> c = t-> dogMapper.registerDog(t);
		c.accept(param);
		box.clear();
		trunk.accept(Arrays.asList("msg"),Arrays.asList("success"));
		return trunk.get();
	}
	
}
