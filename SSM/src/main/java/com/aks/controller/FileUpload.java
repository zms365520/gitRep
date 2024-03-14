package com.aks.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 16:58
 * @Description: com.aks.controller
 * @version: 1.0
 */
@Controller
public class FileUpload {

    @ResponseBody
    @RequestMapping("fileUpload.do")
    public String fileUpload(MultipartFile headPhoto) throws IOException{
        File dir=new File("d://imgs");
        String originalFilename = headPhoto.getOriginalFilename();

        File file=new File(dir, originalFilename);

        headPhoto.transferTo(file);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("fileUpload2.do")
    public String fileUpload2(MultipartFile headPhoto, HttpServletRequest request) throws IOException{
        //request：指定文件存储目录为项目部署环境下的upload目录
        String realPath = request.getServletContext().getRealPath("/upload");

        File dir=new File(realPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();

        File file=new File(dir, originalFilename);

        headPhoto.transferTo(file);

        return "ok";
    }
    @ResponseBody
    @RequestMapping("fileUpload3.do")
    public String fileUpload3(MultipartFile headPhoto, HttpServletRequest request) throws IOException{
        //request：指定文件存储目录为项目部署环境下的upload目录
        String realPath = request.getServletContext().getRealPath("/upload");

        File dir=new File(realPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();

        String uuid=UUID.randomUUID().toString();
        //文件的扩展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        if(!extendsName.equals(".jpg")){
            return "文件类型必须是.jpg";
        }
        //新的文件名
        String newFileName=uuid.concat(extendsName);

        File file=new File(dir, newFileName);

        headPhoto.transferTo(file);
        //System.out.println(newFileName);
        return "ok"+newFileName;
    }

    @ResponseBody
    @RequestMapping("fileUpload4.do")
    public Map<String,String> fileUpload4(MultipartFile headPhoto, HttpServletRequest request) throws IOException{
        Map<String,String> map=new HashMap<>();

        //request：指定文件存储目录为项目部署环境下的upload目录
        String realPath = request.getServletContext().getRealPath("/upload");

        //设置图片的大小，这里是一种方式，还可以在springMVC.xml中配置管理
        if(headPhoto.getSize()>1024*1024*2){
            map.put("message","图片不能大于2MB");
            return map;
        }

        File dir=new File(realPath);
        if (!dir.exists()){
            dir.mkdirs();
        }
        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();

        String uuid=UUID.randomUUID().toString();
        //文件的扩展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));
        if(!extendsName.equals(".jpg")){
            map.put("message","文件类型必须是.jpg");
            return map;
        }
        //新的文件名
        String newFileName=uuid.concat(extendsName);

        File file=new File(dir, newFileName);

        headPhoto.transferTo(file);
        //System.out.println(newFileName);

        map.put("message","上传成功");
        map.put("newFileName",newFileName);
        map.put("fileType",headPhoto.getContentType());
        return map;
    }


    private final static String fileserver="http://192.168.1.12:8090/upload/";
    @ResponseBody
    @RequestMapping("fileUpload5.do")
    public Map<String,String> fileUpload5(MultipartFile headPhoto, HttpServletRequest request) throws IOException{
        Map<String,String> map=new HashMap<>();

        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();

        String uuid=UUID.randomUUID().toString();
        //文件的扩展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));

        //新的文件名
        String newFileName=uuid.concat(extendsName);

        //创建sun公司提供的jersey包中的client对象
        Client client=Client.create();
        WebResource resource = client.resource(fileserver + newFileName);
        //文件保存到另一个服务器上去了
        resource.put(String.class,headPhoto.getBytes());

        //System.out.println(newFileName);

        map.put("message","上传成功");
        map.put("newFileName",fileserver +newFileName);
        map.put("fileType",headPhoto.getContentType());
        return map;
    }


    @ResponseBody
    @RequestMapping("fileUpload6.do")
    public Map<String,String> fileUpload6(MultipartFile headPhoto, HttpServletRequest request) throws IOException{
        Map<String,String> map=new HashMap<>();

        //获取文件名
        String originalFilename = headPhoto.getOriginalFilename();

        String uuid=UUID.randomUUID().toString();
        //文件的扩展名
        String extendsName = originalFilename.substring(originalFilename.lastIndexOf("."));

        //新的文件名
        String newFileName=uuid.concat(extendsName);

        //创建sun公司提供的jersey包中的client对象
        Client client=Client.create();
        WebResource resource = client.resource(fileserver + newFileName);
        //文件保存到另一个服务器上去了
        resource.put(String.class,headPhoto.getBytes());

        //System.out.println(newFileName);

        map.put("message","上传成功");
        map.put("newFileName",newFileName);
        map.put("fileType",headPhoto.getContentType());
        return map;
    }

    /*@RequestMapping("zhuce.do")
    public String zhuce(String cname,String room,String photoName,String photoType){
        System.out.println(cname+"--"+room+"--"+photoName+"--"+photoType);
        return "redirect:/index.jsp";
    }*/

}
