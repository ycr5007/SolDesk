package board.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil {
	public HashMap<String, String> uploadFile(HttpServletRequest request) {
		HashMap<String, String> dataMap = new HashMap<String, String>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if(isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			
			Iterator<FileItem> iter = items.iterator();
			
			while(iter.hasNext()) {
				FileItem item = iter.next();
				if(item.isFormField()) {
					try {
						dataMap.put(item.getFieldName(), item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else {
					String fileName = item.getName();
					if(!fileName.isEmpty()) {
						String path = "D:\\@Private\\Study\\@SOLDESK\\@Code\\upload";
						
						UUID uuid = UUID.randomUUID();
						File uploadFile = new File(path + "\\" + uuid.toString() + "_" + fileName);
						
						try {
							item.write(uploadFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
						
						dataMap.put(item.getFieldName(), uploadFile.getName());
					}
				}
			}
		}
		return dataMap;
	}
}
