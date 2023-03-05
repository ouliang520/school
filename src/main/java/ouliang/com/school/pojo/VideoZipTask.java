package ouliang.com.school.pojo;


import java.io.IOException;

public class VideoZipTask extends VideoTask {

    public VideoZipTask(Object obj) {
        super(obj);
    }

    @Override
    void excuJob(Object obj) {
        String videoName = (String) obj;
        Runtime rt = Runtime.getRuntime();
        videoName = "/www/wwwroot/ouliang.icu/wen/" + videoName;
        try {
            Process pr = rt.exec("ffmpeg -i " + videoName + " -vcodec h264 -s 1280*720 -acodec copy -f mp4 /www/wwwroot/ouliang.icu/wen/out.mp4");
            pr.waitFor();
            pr=rt.exec("rm -f "+videoName);
            pr.waitFor();
            pr=rt.exec("mv /www/wwwroot/ouliang.icu/wen/out.mp4 "+videoName);
            pr.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
