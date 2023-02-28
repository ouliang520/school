package ouliang.com.school.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ouliang.com.school.Service.ImgService;
import ouliang.com.school.Service.essayService;
import ouliang.com.school.pojo.Essay;
import ouliang.com.school.pojo.Img;
import ouliang.com.school.pojo.Video;
import ouliang.com.school.util.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Controller
public class essayController {
    final String Server = "http://ouliang.icu\\wen\\";//服务器文件存放地址
    @Autowired
    essayService essayService;

    @Autowired
    ImgService imgService;

    @PostMapping("/tijiao1")
    @ResponseBody
    public String tijao1(@RequestParam String text, @RequestParam String title, @RequestParam String introduce, @RequestParam("coverFile") MultipartFile coverFile) {
        //文件上传过程
        String coverName = coverFile.getOriginalFilename();//获取文件名

//        if (!coverName.endsWith(".png")||!coverName.endsWith(".jpg")){
//            //判断文件后缀 可以选择重定向回失败页面
//            return "失败";
//        }

//        String str= System.getProperty("user.dir") + "//wen";
        String str = new Path().getJDK() + "//wen";//linux使用

        File tmp = new File(str);
        if (!tmp.exists()) {
            //没有这个目录就创建目录
            tmp.mkdirs();
        }

        Date date = new Date();
        String resourcesPath = str + "//" + date.getTime() + coverName;
        File upFile = new File(resourcesPath);
        try {
            FileUtils.copyInputStreamToFile(coverFile.getInputStream(), upFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Essay essay = new Essay();
        essay.setCover(Server + date.getTime() + coverName);
        essay.setEnddata(date);
        essay.setIntroduce(introduce);
        essay.setTitle(title);
        essay.setText(text);
        essay.setFlag("0");
        essayService.addEssay(essay);

        return "成功 <a href=http://43.139.45.79:8081/26d9a9b077d03324659ea35c024648a6/x>返回<a>";
    }

    @PostMapping("tijiao2")
    @ResponseBody
    public String tijao2(@RequestParam String title, @RequestParam String introduce, @RequestParam("coverFile") MultipartFile coverFile, @RequestParam("File") MultipartFile File) {
        //文件上传过程
        String coverName = coverFile.getOriginalFilename();//获取文件名

        String Name = File.getOriginalFilename();//获取视频文件名

//        if (!coverName.endsWith(".png")||!coverName.endsWith(".jpg")){
//            //判断文件后缀 可以选择重定向回失败页面
//            return "失败";
//        }

//        String str= System.getProperty("user.dir") + "//wen";
        String str = new Path().getJDK() + "//wen";//linux使用

        File tmp = new File(str);
        if (!tmp.exists()) {
            //没有这个目录就创建目录
            tmp.mkdirs();
        }

        Date date = new Date();
        String resourcesPath = str + "//" + date.getTime() + coverName;
        String resourcesPath1 = str + "//" + date.getTime() + Name;
        File upFile = new File(resourcesPath);
        File upFile1 = new File(resourcesPath1);//视频
        try {
            FileUtils.copyInputStreamToFile(coverFile.getInputStream(), upFile);
            FileUtils.copyInputStreamToFile(File.getInputStream(), upFile1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Video video = new Video();
        video.setVideo(date.getTime() + Name);
        video.setEnddata(date);
        video.setIntroduce(introduce);
        video.setTitle(title);
        video.setTitle(introduce);
        video.setCover(Server + date.getTime() + coverName);
        video.setText("<p>"+introduce+"</p>");

        essayService.addVideo(video);

        return "成功 <a href=http://43.139.45.79:8081/6a295e846d2532d2248ff5d8a35448f4>返回<a>";
    }

    @PostMapping("/tijiao3")
    @ResponseBody
    public String tijao3(@RequestParam String text, @RequestParam String title, @RequestParam String introduce, @RequestParam("coverFile") MultipartFile coverFile) {
        String coverName = coverFile.getOriginalFilename();//获取文件名
        String str = new Path().getJDK() + "//wen";//linux使用

        File tmp = new File(str);
        if (!tmp.exists()) {
            //没有这个目录就创建目录
            tmp.mkdirs();
        }

        Date date = new Date();
        String resourcesPath = str + "//" + date.getTime() + coverName;
        File upFile = new File(resourcesPath);
        try {
            FileUtils.copyInputStreamToFile(coverFile.getInputStream(), upFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Essay essay = new Essay();
        essay.setEnddata(date);
        essay.setIntroduce(introduce);
        essay.setTitle(title);
        essay.setText(text);
        essay.setCover(Server + date.getTime() + coverName);
        essay.setFlag("1");
        essayService.addEssay(essay);
        return "公众号上传成功 <a href=http://43.139.45.79:8081/6a295e846d2532d2248ff5d8a35448f4>返回<a>";
    }


//    @GetMapping("/x")
//    public String x() {
//        return "admin/tijiao";
//    }


    @GetMapping("/selectTitle")
    @ResponseBody
    public List<Essay> selectTitle() {
        return essayService.selectEssayTitle();
    }

    @GetMapping("/selectVideo")
    @ResponseBody
    public List<Video> selectVideo() {
        return essayService.selectVideo(8);
    }

    @GetMapping("/essay/{id}")
    public String essayById(@PathVariable int id, Model model) {
        List<Essay> essays = essayService.selectEssayTitle();
        List<Video> videos = essayService.selectVideo(8);
        Essay essay = essayService.selectEssayById(id);
        model.addAttribute("essay", essay);
        model.addAttribute("videos", videos);
        model.addAttribute("essays", essays);
        return "essay";
    }

    @GetMapping("/video/{id}")
    public String videoById(@PathVariable int id, Model model) {
        Video video = essayService.selectVideoById(id);
        List<Video> videos = essayService.selectVideo(8);
        model.addAttribute("video", video);
        model.addAttribute("videos", videos);
        return "video";
    }

    @GetMapping({"/", "/index"})
    public String indexShow(Model model) {
        List<Img> images = imgService.selectImg();
        List<Essay> essays = essayService.selectEssayTitle();
//        List<Essay> index =essayService.selectIndex(); 去除公众号展示大图
        List<Video> videos = essayService.selectVideo(6);
        model.addAttribute("images", images);
        model.addAttribute("videos", videos);
        List<Video> videos3 = essayService.selectVideo(3);
        model.addAttribute("videos3", videos3);
        model.addAttribute("essays", essays);
//        model.addAttribute("index", index); 去除公众号展示大图

        return "index";
    }

    @GetMapping("/getJDK")
    @ResponseBody
    public String getJdk() {
        Video video = essayService.selectVideoById(37);
        String str = new Path().getJDK() + "wen/" + video.getVideo();
        return str;
    }

    @RequestMapping("/getVideo/{id}")
    public void getVideo(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        //获取从那个字节开始读取文件
        String rangeString = request.getHeader("Range");

        try {
            //获取响应的输出流
            OutputStream outputStream = response.getOutputStream();
            Video video = essayService.selectVideoById(id);
            //linux专用文件路径
            File file = new File(new Path().getJDK() + "wen/" + video.getVideo());
            if (file.exists()) {
                RandomAccessFile targetFile = new RandomAccessFile(file, "r");
                long fileLength = targetFile.length();
                //播放
                if (rangeString != null) {

                    long range = Long.valueOf(rangeString.substring(rangeString.indexOf("=") + 1, rangeString.indexOf("-")));
                    //设置内容类型
                    response.setHeader("Content-Type", "video/mp4");
                    //设置此次相应返回的数据长度
                    response.setHeader("Content-Length", String.valueOf(fileLength - range));
                    //设置此次相应返回的数据范围
                    response.setHeader("Content-Range", "bytes " + range + "-" + (fileLength - 1) + "/" + fileLength);
                    //返回码需要为206，而不是200
                    response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                    //设定文件读取开始位置（以字节为单位）
                    targetFile.seek(range);
                } else {//下载

                    //设置响应头，把文件名字设置好
                    response.setHeader("Content-Disposition", "attachment; filename=" + "文件名");
                    //设置文件长度
                    response.setHeader("Content-Length", String.valueOf(fileLength));
                    //解决编码问题
                    response.setHeader("Content-Type", "application/octet-stream");
                }


                byte[] cache = new byte[1024 * 300];
                int flag;
                while ((flag = targetFile.read(cache)) != -1) {
                    outputStream.write(cache, 0, flag);
                }
            } else {
                String message = "file:" + "文件名" + " not exists";
//                解决编码问题
                response.setHeader("Content-Type", "application/json");
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            }

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    @PostMapping("select")
    public String selectList(@RequestParam String TitleName, Model model) {
        List<Essay> essays = essayService.selectEssayByName(TitleName, 1);
        int EssayNum = essayService.selectEssayByNameNum(TitleName);
        model.addAttribute("TitleName", TitleName);
        model.addAttribute("essays", essays);
        model.addAttribute("EssayNum", EssayNum);
        model.addAttribute("page", 1);
        return "select";
    }

    @GetMapping("select/{TitleName}/{page}")
    public String selectByName(@PathVariable String TitleName, @PathVariable int page, Model model) {
        List<Essay> essays = essayService.selectEssayByName(TitleName, page);
        int EssayNum = essayService.selectEssayByNameNum(TitleName);
        model.addAttribute("TitleName", TitleName);
        model.addAttribute("essays", essays);
        model.addAttribute("EssayNum", EssayNum);
        model.addAttribute("page", page);
        return "select";
    }

    @GetMapping("select/{page}")
    public String selectByName(@PathVariable int page, Model model) {
        model.addAttribute("TitleName", null);
        List<Essay> essays = essayService.selectEssayByName("", page);
        int EssayNum = essayService.selectEssayByNameNum("");
        model.addAttribute("essays", essays);
        model.addAttribute("EssayNum", EssayNum);
        model.addAttribute("page", page);
        return "select";
    }

    @GetMapping("selectVideo/{page}")
    public String selectByVideoName(@PathVariable int page, Model model) {
        model.addAttribute("TitleName", null);
        List<Essay> essays = essayService.selectVideoByName("", page);
        int EssayNum = essayService.selectVideoByNameNum("");
        model.addAttribute("videos", essays);
        model.addAttribute("EssayNum", EssayNum);
        model.addAttribute("page", page);
        return "selectVideo";
    }

    @GetMapping("selectVideo/{TitleName}/{page}")
    public String selectByVideoName(@PathVariable String TitleName, @PathVariable int page, Model model) {
        List<Essay> essays = essayService.selectVideoByName(TitleName, page);
        int EssayNum = essayService.selectVideoByNameNum(TitleName);
        model.addAttribute("TitleName", TitleName);
        model.addAttribute("videos", essays);
        model.addAttribute("EssayNum", EssayNum);
        model.addAttribute("page", page);
        return "selectVideo";
    }

    @PostMapping("selectVideo")
    public String selectVideoList(@RequestParam String TitleName, Model model) {
        List<Essay> essays = essayService.selectVideoByName(TitleName, 1);
        int EssayNum = essayService.selectVideoByNameNum(TitleName);
        model.addAttribute("TitleName", TitleName);
        model.addAttribute("videos", essays);
        model.addAttribute("EssayNum", EssayNum);
        model.addAttribute("page", 1);
        return "selectVideo";
    }

    @GetMapping("deleteEssay")
    @ResponseBody
    public String deleteEssay(@RequestParam int id) {
        essayService.deleteEssay(id);
        return "删除文章成功 <a href=http://43.139.45.79:8081/391ad4e4d115fc48d1f004005bb95deb>返回<a>";
    }

    @GetMapping("deleteVideo")
    @ResponseBody
    public String deleteVideo(@RequestParam int id) {
        essayService.deleteVideo(id);
        return "删除视频成功 <a href=http://43.139.45.79:8081/f2e2c325336a2bce2b5175818514f92d>返回<a>";
    }

    @GetMapping("/391ad4e4d115fc48d1f004005bb95deb")
    public String d(Model model) {
        List<Essay> essays = essayService.deleteList();
        model.addAttribute("essays", essays);
        return "admin/delete";
    }

    @GetMapping("/f2e2c325336a2bce2b5175818514f92d")
    public String d2(Model model) {
        List<Video> videos = essayService.selectVideo(1000);
        model.addAttribute("videos", videos);
        return "admin/deleteVideo";
    }

    @GetMapping("cesi")
    @ResponseBody
    public String cesi(){
        Runtime rt =Runtime.getRuntime();
        try {
            Process pr=rt.exec("ffmpeg -i /www/wwwroot/ouliang.icu/wen/166987023473255-章梓虹-斯特朗.mp4 -vcodec h264 -s 1280*720 -acodec copy -f mp4 /www/wwwroot/ouliang.icu/wen/out.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "成功没?";
    }

}