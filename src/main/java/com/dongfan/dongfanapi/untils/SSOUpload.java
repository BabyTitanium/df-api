package com.dongfan.dongfanapi.untils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * @Author: lll
 * @Date: 2019/8/20 20:17
 * @Version 1.0
 */
public class SSOUpload {
    public static String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    public static String accessKeyId = "<yourAccessKeyId>";
    public static String accessKeySecret = "<yourAccessKeySecret>";
    public static String bucketName="dongfan/";
    private static String filedir="newsImage";
    public static OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    public static String  uploadImage(MultipartFile multipartFile,String dic){
        InputStream inputStream = null;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            return null;
        }
        String originalFilename=multipartFile.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        return  uploadFile2OSS(inputStream,name,dic);

    }

    public static String uploadFile2OSS(InputStream instream, String fileName,String dic) {
        try {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            PutObjectResult putResult=null;
            String name=null;
            if(dic!=null){
                 name=dic+"/" + fileName;
            }else{
                name=fileName;
            }
            putResult = ossClient.putObject(bucketName,name, instream, objectMetadata);
            return getUrl(name);
        } catch (IOException e) {
            return null;
        }
    }


    public static String getcontentType(String FilenameExtension){
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public static String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        ossClient.shutdown();
        if (url != null) {
            return url.toString();
        }
        return null;
    }
}
