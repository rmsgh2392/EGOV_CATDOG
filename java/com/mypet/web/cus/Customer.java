package com.mypet.web.cus;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Lazy @Data 
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Customer{
	private String cid,pwd,ssn,creditcard,pname,phone,address,email;


}