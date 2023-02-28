package ouliang.com.school.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ouliang.com.school.Service.ImgService;
import ouliang.com.school.util.Path;

import java.io.*;
import java.net.*;
import java.util.Date;

import static ouliang.com.school.util.Path.readInputStream;

@Controller
public class ImgController {
    final String Server = "http://ouliang.icu/wen/p/";//服务器文件存放地址
    @Autowired
    ImgService imgService;
    //网络图片下载
    @GetMapping("downloadURL")
    @ResponseBody
    public String DownloadURL(@RequestParam String id,@RequestParam String ImgURL,@RequestParam String title){
        String ImgName=imgService.getImgFile(id);
        new Path().deleteFile(ImgName);
        try {
            //定义一个URL对象，就是你想下载的图片的URL地址
            URL url = new URL(ImgURL);
            //打开连接
            URLConnection con=url.openConnection();
            con.setRequestProperty("User-Agent","Mozilla/4.0");//欺骗
            //通过输入流获取图片数据
            InputStream is = con.getInputStream();
            //得到图片的二进制数据，以二进制封装得到数据，具有通用性
            byte[] data = readInputStream(is);

            String str = new Path().getJDK() + "/wen/p";//linux使用
            File tmp = new File(str);
            if (!tmp.exists()) {
                //没有这个目录就创建目录
                tmp.mkdirs();
            }

            //创建一个文件对象用来保存图片
            ImgName=new Date().getTime()+".jpg";
                File imageFile = new File(str+"/"+ImgName);
            //创建输出流
            FileOutputStream outStream = new FileOutputStream(imageFile);
            //写入数据
            outStream.write(data);
            //关闭输出流，释放资源
            outStream.close();

            imgService.Insert(id,title,"wen/p/"+ImgName);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "成功 <a href=http://43.139.45.79:8081/d15aa0f48fcbd1338d51013daffbbc15>返回</a>";
    }
    @PostMapping("LoadUpImg")
    @ResponseBody
    public String LoadUpImg(@RequestParam MultipartFile multipartFile,@RequestParam String id,@RequestParam String title){
        String ImgName=imgService.getImgFile(id);
        new Path().deleteFile(ImgName);
        String coverName = multipartFile.getOriginalFilename();//获取文件名
        String str = new Path().getJDK() + "/wen/p/";//linux使用

        File tmp = new File(str);
        if (!tmp.exists()) {
            //没有这个目录就创建目录
            tmp.mkdirs();
        }
        Date date = new Date();
        coverName =date.getTime() + coverName;
        String resourcesPath = str + coverName;
        File upFile = new File(resourcesPath);
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),upFile);
            imgService.Insert(id,title,"wen/p/"+coverName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "成功 <a href=http://43.139.45.79:8081/6a295e846d2532d2248ff5d8a35448f4>返回</a>";
    }
}
