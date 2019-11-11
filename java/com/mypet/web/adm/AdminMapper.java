package com.mypet.web.adm;

import java.util.HashMap;

public interface AdminMapper {
<<<<<<< HEAD
	public void insertAdmin(Admin param);
	public Admin selectByAid(Admin param);
	public Admin access(Admin param);
	public Admin selectAdmin2(HashMap<?,?> param);
	public void createAdmin(HashMap<String,String> paramMap);
=======

	Admin deleteAdmin(Admin param);
	Admin updateAdmin(Admin param);
	Admin selectAdmin(HashMap<?,?> param);
	
	Admin selectAdminByIdPw(Admin param);
	
	Admin selectAdminById(String param);
	Admin selectUserByIdPw(Admin param);

>>>>>>> 477b340027fb1dbd3ad9ddeb549b90ce575782c4
}
