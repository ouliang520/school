package ouliang.com.school.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ouliang.com.school.pojo.VideoTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class VideoUtil {

    @Value("12")
    private int MAX_CAP_SIZE;//最大队列
    @Value("1")
    private int MAX_THREAD_NUM;//最大线程数量
    @Value("true")
    private boolean IS_FAIR;//是否采用公平锁

    //交给spring管理后为整个util为单例
    private volatile BlockingQueue<VideoTask> queue;//


    //Spring初始化VideoUtil类后执行
    @PostConstruct
    public void init(){
        queue = new LinkedBlockingQueue<>(MAX_CAP_SIZE);

        new QueueCheck().start();;
    }

    public void addTask(VideoTask task){
        queue.offer(task);
    }

    //开辟线程检测任务队列
    private class QueueCheck extends Thread{
        QueueCheck(){
            setName("video task check thread");
        }

        @Override
        public void run(){
            while (true){
                if (!queue.isEmpty()){
                    Runnable task = queue.poll();
                    task.run();
                }
            }
        }
    }

    //视频任务


    //视频压缩任务

}