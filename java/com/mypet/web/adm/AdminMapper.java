package com.mypet.web.adm;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.mypet.web.adm.Admin;
@Repository
public interface AdminMapper {
	public void insertAdmin(Admin param);
	public Admin selectByAid(Admin param);
	public Admin access(Admin param);
	public void createAdmin(HashMap<String,String> paramMap);
	public Admin deleteAdmin(Admin param);
	public Admin updateAdmin(Admin param);
    public List<Admin> selectAdmin(HashMap<?,?> param);

}



