package com.mypet.web.pxy;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.mypet.web.enums.Path;

@Component("filemgr")
public class FileProxy extends Proxy{
	@Autowired GenFile<String> genfile;
	public void fileupload(MultipartFile[] uploadFile) {
		System.out.println("파일업로드 컨트롤러 들어옴");
		String uploadFolder = Path.UPLOAD_PATH.toString();
		File uploadPath = genfile.makeFile(uploadFolder,getFolder());
		if(uploadPath.exists()==false) {
			uploadPath.mkdirs();
		}
		for(MultipartFile f : uploadFile) {
			String fname = f.getOriginalFilename();
			String extension = fname.substring(fname.lastIndexOf(".")+1);
			fname = fname.substring(fname.lastIndexOf("\\")+1, fname.lastIndexOf("."));
//			UUID uuid = UUID.randomUUID();
//			fname = UUID.randomUUID().toString()+"_"+fname;
			System.out.println("파일명"+fname);
			System.out.println("확장자 :"+extension);
			File saveFile  = new File(uploadPath,fname+"-"+UUID.randomUUID().toString()+"."+extension);
			try {
				f.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("파일 업로드 들어옴");
	}
	public String getFolder() {
		return currentDate().replace("-",File.separator);
	}
	
}
