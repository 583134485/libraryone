package com.guo.ssm.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.controller.ChartsController;
import com.guo.ssm.core.Constant;

/*
 * 文件操作
*/
public class FileDaoUtil {

	private static final Logger log = LoggerFactory.getLogger(FileDaoUtil.class);

	// private static String FileSavePath="D:\\fileUpload\\";
	private static String FileSavePath = Constant.uploadpath;
	private static String FileDownPath = Constant.downloadpath;

	
	public static String WorkSheetToFile(XSSFWorkbook workbook, String filename) {
		StringBuffer filepath = new StringBuffer();
		filepath.append(FileDownPath);
		if (filepath.toString().endsWith("\\") || filepath.toString().endsWith("/")) {
		} else {
			filepath.append(System.getProperty("file.separator"));
		}
		File filedir = new File(filepath.toString());
		// 新环境 可能 出现 没有目录 的情况 (系统找不到指定路径)
		if (!filedir.exists()) {
			log.info("创建新目录 " + filedir);
			filedir.mkdirs();
		}
		filepath.append(filename);
		File file = new File(filepath.toString());
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			workbook.write(fileOutputStream);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO: handle exception
		finally {
			// flush
			try {				
				fileOutputStream.flush();
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			// close			
		}

	
	}
		return filepath.toString();
	}

	/**
	 * single file uplaod input multiparfile file return path
	 */
	public static String UploadFile(MultipartFile file) {

		if (file == null) {
			log.info("file is null");
			return null;
		}
		// file is not null
		else {
			// file empty
			if (file.getSize() < 0) {
				log.info("file is empty");
				return null;
			} else {
				try {
					StringBuffer filepath = new StringBuffer();
					filepath.append(FileSavePath);
					if (filepath.toString().endsWith("\\") || filepath.toString().endsWith("/")) {
					} else {
						filepath.append(System.getProperty("file.separator"));
					}

					byte[] bytes = file.getBytes();
					File filedir = new File(filepath.toString());
					// 新环境 可能 出现 没有目录 的情况 (系统找不到指定路径)
					if (!filedir.exists()) {
						log.info("创建新目录 " + filedir);
						filedir.mkdirs();
					}
					File savedFilepath = new File(filepath.append(file.getOriginalFilename()).toString());
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(savedFilepath));
					stream.write(bytes);
					stream.close();
					return savedFilepath.toString();
				} catch (IOException e) {
					e.printStackTrace();
					log.info("Error Write file: " + FileSavePath);
				}
			}

		}
		return null;
	}

	// 多文件上传
	// 返回多个文件的path
	public String UploadFiles(MultipartFile[] files) {
		log.info("UploadFiles");
		/*
		 * log.info("begin-post"); try { response.getWriter().write("success");
		 * log.info("wtiter"+response.getWriter()); } catch (IOException e1) { // TODO
		 * Auto-generated catch block e1.printStackTrace(); }
		 * response.setHeader("Access-Control-Allow-Origin", "*");
		 */
		// log.info("context.getRalPath"+context.getRealPath(""));

		// Root Directory.
		// String uploadRootPath = request.getServletContext().getRealPath("upload");
		// log.info("uploadRootPath=" + uploadRootPath);

		// File uploadRootDir = new File(uploadRootPath);
		//
		// Create directory if it not exists.
		// if (!uploadRootDir.exists()) {
		// uploadRootDir.mkdirs();
		// }
		// 这里是多文件上传，
		List<File> uploadedFiles = new ArrayList<File>();
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];

			// Client File Name
			String name = file.getOriginalFilename();
			log.info("Client File Name = " + name);

			if (name != null && name.length() > 0) {
				try {
					byte[] bytes = file.getBytes();

					// Create the file on server
					/*
					 * File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator +
					 * name);
					 */
					// 为了不重复创建给每个文件设置独立ID
					// File serverFile = new File("F:\\fileUpload"+ File.separator+new
					// Date().toString() + name);
					File serverFile = new File("D:\\fileUpload" + File.separator + name);
					log.info("保存路径F:\\fileUpload" + File.separator + name);
					/*
					 * log.info("保存路径"+uploadRootDir.getAbsolutePath() + File.separator + name);
					 */
					/*
					 * if(!serverFile.exists()){ log.info("不存在这个文件"); //serverFile = new
					 * File("F:\\fileUpload"+ File.separator+new Date().toString() + name);
					 * //存在既创建一个新的 serverFile.mkdirs(); log.info("所以创建"+serverFile.mkdirs()); }
					 */
					// log.info("创建后是否存在"+serverFile.exists());
					// Stream to write data to file in server.
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();
					log.info("stream流关闭");
					//
					uploadedFiles.add(serverFile);
					log.info("Write file: " + serverFile);
				} catch (Exception e) {
					log.info("Error Write file: " + name);
				}
			}
		}

		return "上传成功";
	}

	// 多文件上传
	// 返回多个文件的path
	public static List<String> UploadFilesAndReturnPath(MultipartFile[] files) {
		log.info("UploadFilesAndReturnPath");
		// listpath
		List<String> pathlist = new ArrayList<String>();
		// 这里是多文件上传，
		// List<File> uploadedFiles = new ArrayList<File>();
		for (int i = 0; i < files.length; i++) {
			MultipartFile file = files[i];

			String path = UploadFile(file);
			if (path != null && !path.isEmpty()) {
				pathlist.add(path);
			}

		}

		return pathlist;
	}

	/**
	 * @return message
	 *
	 */
	// 单个文件下载,如果要实现多文件下载的话，我就create zip 文件，讲道理都应该设置成zip再传输好了（文件小就算了）
	public  static String FileDownLoad(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String message = new String("yesbaby");
		String filename = request.getParameter("filename");
		log.info("filename" + filename);
		// 临时代替下filename传不过来的时候
		// filename="1.jpg";
		// utf-8处理文件名
		/* filename =new String(filename.getBytes(""),"UTF-8"); */
		// 路径
		String filepath = FindFileByName(filename);
		log.info("filepath:" + filepath);
		// create file
		File file = new File(filepath);
		// not find file
		if (!file.exists()) {
			log.info("notfind");
			message = "notfindfile";
			/* request.setAttribute("message", "not find"); */
		}
		// set header
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		// 文件输入流，保存到文件输入流
		FileInputStream fileInputStream = new FileInputStream(file);
		log.info("fileinputstream:" + fileInputStream.toString());
		// 创建输出流
		OutputStream outputStream = response.getOutputStream();
		// 缓存区
		byte buffer[] = new byte[1024];
		int len = 0;
		// 循环将文件输入流读到缓存区中
		while ((len = fileInputStream.read(buffer)) > 0) {
			// 缓存输出到到浏览器，实现文件下载
			outputStream.write(buffer, 0, len);
		}
		// 文件输入流关闭
		fileInputStream.close();
		log.info("closein");
		// 输出流关闭
		outputStream.close();
		log.info("closeout");

		log.info(message);
		return message;

	}

	public  static String FileDownLoadNew(String path, HttpServletResponse response) throws Exception {
		String message = new String("download");
		//StringDaoUtil stringDaoUtil = new StringDaoUtil();
		// 临时代替下filename传不过来的时候
		// filename="1.jpg";
		// utf-8处理文件名
		/* filename =new String(filename.getBytes(""),"UTF-8"); */
		// 路径
		//String filepath = path;
		log.info("begin down filepath:" + path);
		// create file
		File file = new File(path);
		// not find file
		if (!file.exists()) {
			log.info("not find file"+path);
			throw new NullPointerException();
		
			//message = "notfindfile";
			
			/* request.setAttribute("message", "not find"); */
		}
		String filename = StringDaoUtil.PathToFileName(path);
		
		
		// set header
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		FileInputStream fileInputStream=null;
		OutputStream outputStream =null;
		try {
			// 文件输入流，保存到文件输入流
			 fileInputStream = new FileInputStream(file);
			//log.info("fileinputstream:");
			// 创建输出流
			 outputStream = response.getOutputStream();
			// 缓存区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将文件输入流读到缓存区中
			while ((len = fileInputStream.read(buffer)) > 0) {
				// 缓存输出到到浏览器，实现文件下载
				outputStream.write(buffer, 0, len);
			}

		}
		catch (IOException e) {
 e.printStackTrace();
 log.info("down load file error");
		}
		finally {
			// 文件输入流关闭
			fileInputStream.close();

			// 输出流关闭
			outputStream.close();

		}


		log.info(message);
		return message;

	}

	// 找到文件路径  通过 文件明
	public  static String FindFileByName(String filename) {
  StringBuffer filepath=new StringBuffer();
  filepath.append(FileDownPath);
  filepath.append(filename);
		return filepath.toString();
	}

	public Boolean isExistFile(String filename) {
		String filepath = "D:\\fileUpload\\" + filename;
		log.info(filepath);
		File file = new File(filepath);
		if (file.exists()) {
			return true;
		} else {
			return false;
		}
	}

	// zip压缩，返回路径，。。为完成
	public String FileToZip(String filepath) throws FileNotFoundException {
		StringDaoUtil stringDaoUtil = new StringDaoUtil();
		String filename = stringDaoUtil.PathToName(filepath);
		ZipOutputStream zipOutputStream = new ZipOutputStream(
				new FileOutputStream("D:\\fileDownLoad" + filename + ".zip"));
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);

		return null;
	}

}
