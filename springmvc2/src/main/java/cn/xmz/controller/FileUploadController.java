package cn.xmz.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileUploadController {

    @RequestMapping("/upload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("传统文件上传");
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        File file = new File(path);
        /*判断路径是否存在*/
        if(!file.exists()){
            /*创建新文件夹*/
            file.mkdirs();
        }
        /*解析request对象，获取上传文件项*/
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item:items){
            if(item.isFormField()){
                /*普通表项*/
            }else{
                /*文件项*/
                String filename = item.getName();
                /*uuid*/
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+filename;
                item.write(new File(path, filename));
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("/upload2")
    public String fileUpload2(HttpServletRequest request, MultipartFile upload2) throws Exception {
        System.out.println("springmvc文件上传");
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        System.out.println(path);
        File file = new File(path);
        /*判断路径是否存在*/
        if(!file.exists()){
            /*创建新文件夹*/
            file.mkdirs();
        }
        String filename = upload2.getOriginalFilename();
        /*uuid*/
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+filename;
        upload2.transferTo(new File(path, filename));
        return "success";
    }

    /*跨服务器上传*/
    @RequestMapping("/upload3")
    public String fileUpload3(HttpServletRequest request, MultipartFile upload3) throws Exception {
        System.out.println("跨服务器文件上传");
        String path = "http://localhost:9090/uploads";

        String filename = upload3.getOriginalFilename();
        /*uuid*/
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+filename;

        /*创建客户端对象*/
        Client client = Client.create();
        /*与图片服务器进行连接*/
        WebResource webResource = client.resource(path + filename);
        /*上传文件*/
        webResource.put(upload3.getBytes());
        /*可能报未存在文件夹的错误，手动创建就好了*/
        return "success";
    }
}
