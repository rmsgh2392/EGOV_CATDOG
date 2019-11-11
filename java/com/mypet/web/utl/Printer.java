package com.mypet.web.utl;

import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.mypet.web.cmm.IConsumer;
@Service
public class Printer implements IConsumer{//서비스 ,서비스임플은 안쓴다 이제 5로 넘어오면서 
	
	@Override
	public void accept(Object o) {
		Consumer<String> c = System.out :: println;
		c.accept((String)o);
	}

}
