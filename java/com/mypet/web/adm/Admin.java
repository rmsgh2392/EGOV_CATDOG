package com.mypet.web.adm;

<<<<<<< HEAD
import org.springframework.stereotype.Component;

=======
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	private String aid,pwd,ssn,aname,phone,address,email;
=======
@Data 
@Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class Admin{
	private String aid,pwd,ssn,creditcard,pname,phone,address,email;

>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
}
