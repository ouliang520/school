package ouliang.com.school.pojo;

public abstract class VideoTask implements Runnable{

    protected Object obj;

    public VideoTask(Object obj){
        this.obj = obj;
    }

    @Override
    public void run(){
        //TODO
        excuJob(obj);

    }

    abstract void excuJob(Object obj);
}
