package com.mypet.web.adm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Data 
@AllArgsConstructor
@NoArgsConstructor
@Lazy
@Component
public class Admin {
	private String aid,pwd,ssn,aname,phone,address,email;
}
