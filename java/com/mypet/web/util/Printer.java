package com.mypet.web.util;

import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.mypet.web.cmm.IConsumer;

@Service
public class Printer implements IConsumer{

	@Override
	public void accept(Object t) {
		Consumer<String> consumer = System.out :: println;
		consumer.accept((String)t);
		
	}

}
