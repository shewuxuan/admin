package com.guodu.util;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @program: admin
 * @description: 文件处理类
 * @author: she
 * @create: 2020-04-15 11:26
 */
public class FileHandleUtils {

    /***单个文件上传
     * @param request
     * @param file
     * @param imgSavePath
     */
    public static void singlefileUpload(HttpServletRequest request,MultipartFile file,String imgSavePath,String fileId){
        if(file.isEmpty()){
            return;
        }
            String fileName = file.getOriginalFilename();
                File dest = new File(imgSavePath + "/" + fileId+fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
    }

    /***
     * 多个文件上传
     * @param request
     * @param files
     * @param imgSavePath
     */
    public static void multifileUpload(HttpServletRequest request,List<MultipartFile> files,String imgSavePath){
        if(files.isEmpty()){
            return;
        }
        for(MultipartFile file:files){
            String fileName = file.getOriginalFilename();
            //int size = (int) file.getSize();
            if(file.isEmpty()){
                return;
            }else{
                File dest = new File(imgSavePath + "/" + fileName);
                if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
                    dest.getParentFile().mkdir();
                }
                try {
                    file.transferTo(dest);
                }catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     * @param filePath
     */
    public static void deleteFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /***
     * 预览图片 流响应
     * @param request
     * @param response
     * @return
     */
    public static void previewImage(HttpServletRequest request, HttpServletResponse response,String filePath){
        File file = null;
        FileInputStream fis = null;
        try {
            file = new File(filePath);
            if(!file.exists()) return;
            fis = new FileInputStream(file);
            int len = 0;
            final byte[] buffer = new byte[1024 * 10];
            while ((len = fis.read(buffer)) != -1){
                response.getOutputStream().write(buffer);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
