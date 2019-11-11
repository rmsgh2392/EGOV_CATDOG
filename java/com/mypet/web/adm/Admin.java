package com.mypet.web.adm;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy  //tx가 걸리면서 즉각반응이 아닌 transaction이 끝날 때 한번에 모든반응을 처리함.(data에 걸어야 함)
@Data 
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private String aid,pwd,ssn,creditcard,pname,phone,address,email;
}
