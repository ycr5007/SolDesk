package board.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDownloadAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String fileName = request.getParameter("fileName");
		
		FileInputStream fis = new FileInputStream("D:\\@Private\\Study\\@SOLDESK\\@Code\\upload\\" + fileName);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		response.setContentType("application/octet-stream");
		
		fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");

		String cuttingFileName = fileName.substring(fileName.indexOf("_") + 1);
		
		response.setHeader("Content-Disposition", "attachment;filename=" + cuttingFileName);
		
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		
		int numRead = 0;
		byte[] b = new byte[4096];
		while((numRead = bis.read(b, 0, b.length)) != -1) {
			bos.write(b, 0, numRead);
		}
		
		bos.flush();
		bos.close();
		bis.close();
		
		return null;
	}
}
