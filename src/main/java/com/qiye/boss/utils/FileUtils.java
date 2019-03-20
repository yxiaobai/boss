package com.qiye.boss.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ma Zhaocai
 * @Date: 2019-3-20
 * 文件上传工具类
 */
public class FileUtils {
    private static String fileDir = "WEB-INF\\classes\\static\\upload\\";

    public static Map<String, Object> uploadFile(MultipartFile file, HttpServletRequest request) throws Exception {
        String path2 = request.getServletContext().getRealPath("/") ;
        System.out.println(path2+fileDir);
        if(!file.isEmpty()) {
            File dir = new File(path2+fileDir);
            if(! dir.exists()) {
                dir.mkdir();
            } //假如路径不存在 生成
            String imgmame = file.getOriginalFilename().replace(" ","");
            String filePath =  BossCommonUtils.getUUIDString()+imgmame.substring(imgmame.lastIndexOf("."),imgmame.length());
            String uuidPath = fileDir + filePath;
            File tempFile = new File(path2+uuidPath);
            file.transferTo(tempFile);//将上传的文件保存到临时文件
            Map<String, Object> fileMap = new HashMap<>();
            fileMap.put("fileName", file.getOriginalFilename());
            fileMap.put("filePath", filePath);
            fileMap.put("fileSize", file.getSize()/1024l+" K");
            System.out.println("================= FILE CONFIG START =================");
            System.out.println("File-name:"+file.getOriginalFilename());
            System.out.println("File-path:"+uuidPath);
            System.out.println("File-size:"+file.getSize()/1024l+" K");
            System.out.println("================= FILE CONFIG END =================");
            return fileMap;
        }else {
            throw new Exception("file is empty...");
        }
    }
}
