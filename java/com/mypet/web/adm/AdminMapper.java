package com.mypet.web.adm;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.mypet.web.adm.Admin;
@Repository
public interface AdminMapper {
	public void insertAdmin(Admin param);
	public Admin selectByAid(Admin param);
	public Admin access(Admin param);
	public Admin selectAdmin2(HashMap<?,?> param);
	public void createAdmin(HashMap<String,String> paramMap);
	public Admin deleteAdmin(Admin param);
	public Admin updateAdmin(Admin param);
//	Admin selectAdmin(HashMap<?,?> param);
//	Admin selectAdminByIdPw(Admin param);
//	Admin selectAdminById(String param);
//	Admin selectUserByIdPw(Admin param);
}



