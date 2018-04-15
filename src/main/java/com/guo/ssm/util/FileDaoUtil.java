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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.guo.ssm.controller.ChartsController;

/*
 * 文件操作
*/
public class FileDaoUtil {

	private  static final Logger log=LoggerFactory.getLogger(FileDaoUtil.class);
	
	private static String FileSavePath="D:\\fileUpload\\";
	
	
	
	
  /**	single file uplaod 
   * input multiparfile file 
	return path*/
   public  static String  UploadFile(MultipartFile file) {
	 
	   if(file==null) {
		   log.info("file is null");
		   return null;
	   }
	   //file is not null
	   else {
		  //file empty
		   if(file.getSize()<0) {
			   log.info("file is empty");
			   return null;
		   }
		   else {
               try {
                   byte[] bytes = file.getBytes();
                   File savedFilepath = new File(FileSavePath+ File.separator + file.getOriginalFilename());
                   log.info("savedFilepath"+savedFilepath); 
                   
                   BufferedOutputStream stream = new BufferedOutputStream(
                           new FileOutputStream(savedFilepath));
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
	
	
	//多文件上传
	//返回多个文件的path
	public String UploadFiles( MultipartFile[] files){
		log.info("UploadFiles");
		/*	log.info("begin-post");
		 try {
			response.getWriter().write("success");
			log.info("wtiter"+response.getWriter());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        response.setHeader("Access-Control-Allow-Origin", "*");*/
   //	log.info("context.getRalPath"+context.getRealPath(""));

       // Root Directory.
    //   String uploadRootPath = request.getServletContext().getRealPath("upload");
     //  log.info("uploadRootPath=" + uploadRootPath);

    //   File uploadRootDir = new File(uploadRootPath);
       //
       // Create directory if it not exists.
   //    if (!uploadRootDir.exists()) {
  //         uploadRootDir.mkdirs();
 //      }
       //这里是多文件上传，
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
                   /*File serverFile = new File(uploadRootDir.getAbsolutePath()
                           + File.separator + name);*/
                   //为了不重复创建给每个文件设置独立ID
                  // File serverFile = new File("F:\\fileUpload"+ File.separator+new Date().toString() + name);
                   File serverFile = new File("D:\\fileUpload"+ File.separator + name);
                   log.info("保存路径F:\\fileUpload" + File.separator+ name);
                   /*log.info("保存路径"+uploadRootDir.getAbsolutePath()
                           + File.separator + name);*/
                  /* if(!serverFile.exists()){
                     log.info("不存在这个文件");
                   	 //serverFile = new File("F:\\fileUpload"+ File.separator+new Date().toString() + name);
                   	 //存在既创建一个新的
                   	 serverFile.mkdirs();
                   	 log.info("所以创建"+serverFile.mkdirs());
                    }*/
                   // log.info("创建后是否存在"+serverFile.exists());
                   // Stream to write data to file in server.
                   BufferedOutputStream stream = new BufferedOutputStream(
                           new FileOutputStream(serverFile));
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
	//多文件上传
	//返回多个文件的path
	public List<String> UploadFilesAndReturnPath( MultipartFile[] files){
		log.info("uploadfilesandreturnpathlist");
		//listpath
   List<String> pathlist=new ArrayList<String>();
       //这里是多文件上传，
       //List<File> uploadedFiles = new ArrayList<File>();
       for (int i = 0; i < files.length; i++) {
           MultipartFile file = files[i];
           

           // Client File Name
           String name = file.getOriginalFilename();
          log.info("Client File Name = " + name);

           if (name != null && name.length() > 0) {
               try {
                   byte[] bytes = file.getBytes();

                   // Create the file on server
                   /*File serverFile = new File(uploadRootDir.getAbsolutePath()
                           + File.separator + name);*/
                   //为了不重复创建给每个文件设置独立ID
                  // File serverFile = new File("F:\\fileUpload"+ File.separator+new Date().toString() + name);
                   File serverFile = new File("D:\\fileUpload"+ File.separator + name);
                   log.info("保存路径D:\\fileUpload" + File.separator+ name);
                   /*log.info("保存路径"+uploadRootDir.getAbsolutePath()
                           + File.separator + name);*/
                  /* if(!serverFile.exists()){
                     log.info("不存在这个文件");
                   	 //serverFile = new File("F:\\fileUpload"+ File.separator+new Date().toString() + name);
                   	 //存在既创建一个新的
                   	 serverFile.mkdirs();
                   	 log.info("所以创建"+serverFile.mkdirs());
                    }*/
                   // log.info("创建后是否存在"+serverFile.exists());
                   // Stream to write data to file in server.
                   BufferedOutputStream stream = new BufferedOutputStream(
                           new FileOutputStream(serverFile));
                   stream.write(bytes);
                   //这个有啥用？
                   //uploadedFiles.add(serverFile);
                   pathlist.add(serverFile.toString());
                   log.info("serverFile " + pathlist);
                   
                 
                   stream.close();
                   log.info("stream流关闭");
               } catch (Exception e) {
                  log.info("Error Write file: " + name);
               }
           }
       }
		
		return  pathlist;
	}
	
	/**
	 * @return message
	 *
	 * */
	// 单个文件下载,如果要实现多文件下载的话，我就create zip 文件，讲道理都应该设置成zip再传输好了（文件小就算了）
	public  String  FileDownLoad (HttpServletRequest request,HttpServletResponse response) throws Exception  {
		String message =new String("yesbaby");
		String filename=request.getParameter("filename");
		log.info("filename"+filename);
		//临时代替下filename传不过来的时候
		//filename="1.jpg";
		//utf-8处理文件名
		/*filename =new String(filename.getBytes(""),"UTF-8");*/
		//路径
		String filepath=FindFileByName(filename);
		log.info("filepath:"+filepath);
		//create file
		File file=new File(filepath);
		//not find file
		if(!file.exists()){
			log.info("notfind");
			message="notfindfile";
			/*request.setAttribute("message", "not find");*/
		}
		//set header
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		//文件输入流，保存到文件输入流
		FileInputStream fileInputStream=new FileInputStream(file);
		log.info("fileinputstream:"+fileInputStream.toString());
		//创建输出流
		OutputStream outputStream=response.getOutputStream();
		//缓存区 
		byte buffer[]=new byte [1024];
		int len=0;
		//循环将文件输入流读到缓存区中
		while ((len=fileInputStream.read(buffer))>0) {
		//缓存输出到到浏览器，实现文件下载
			outputStream.write(buffer,0,len);	
		}
		//文件输入流关闭
		fileInputStream.close();
		log.info("closein");
		//输出流关闭
		outputStream.close();
		log.info("closeout");
		
		log.info(message);
		return message;
		
	}
	
	public  String  FileDownLoadNew (String path,HttpServletResponse response) throws Exception  {
		String message =new String("yesbaby");
StringDaoUtil stringDaoUtil=new StringDaoUtil();
		//临时代替下filename传不过来的时候
		//filename="1.jpg";
		//utf-8处理文件名
		/*filename =new String(filename.getBytes(""),"UTF-8");*/
		//路径
		String filepath=path;
		log.info("filepath:"+filepath);
		//create file
		File file=new File(filepath);
		//not find file
		if(!file.exists()){
			log.info("notfind");
			message="notfindfile";
			/*request.setAttribute("message", "not find");*/
		}
		String filename=stringDaoUtil.PathToFileName(filepath);
		//set header
		response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		//文件输入流，保存到文件输入流
		FileInputStream fileInputStream=new FileInputStream(file);
		log.info("fileinputstream:"+fileInputStream.toString());
		//创建输出流
		OutputStream outputStream=response.getOutputStream();
		//缓存区 
		byte buffer[]=new byte [1024];
		int len=0;
		//循环将文件输入流读到缓存区中
		while ((len=fileInputStream.read(buffer))>0) {
		//缓存输出到到浏览器，实现文件下载
			outputStream.write(buffer,0,len);	
		}
		//文件输入流关闭
		fileInputStream.close();
		log.info("closein");
		//输出流关闭
		outputStream.close();
		log.info("closeout");
		
		log.info(message);
		return message;
		
	}
	//找到文件路径
	public String FindFileByName(String filename){
		
		return "D:\\fileUpload\\1.jpg";
	}
	
	public Boolean isExistFile(String filename){
		 String filepath="D:\\fileUpload\\"+filename;
		 log.info(filepath);
		 File file=new File(filepath);
		 if(file.exists()){
			 return true;
		 }
		 else{
			 return false;
		 }		
	}
	
	//zip压缩，返回路径，。。为完成
	public String FileToZip(String filepath) throws FileNotFoundException{
		StringDaoUtil stringDaoUtil =new StringDaoUtil();
		String filename=stringDaoUtil.PathToName(filepath);
		ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream("D:\\fileDownLoad"+filename+".zip"));
		BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(zipOutputStream);
		
		
		
		return null;
	}
	
}
