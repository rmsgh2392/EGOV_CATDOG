package com.mypet.web.adm;
import com.mypet.web.cur.Customer;

public interface AdminMapper {


	public Admin selectAdminByIdPw(Admin param);

	public Admin deleteAdmin(Admin param);

	public Admin updateAdmin(Admin param);

	public Admin selectAdminById(String param);

	public Admin selectCustomerByIdPw(Admin param);

	

}