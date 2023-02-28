package ouliang.com.school.pojo;

import java.text.DateFormat;
import java.util.Date;

public class Essay {
    private String id;
    private String introduce;
    private String text;
    private String cover;
    private String title;
    private Date enddata;
    private String flag;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEnddata() {
        return enddata;
    }

    public void setEnddata(Date enddata) {
        this.enddata = enddata;
    }

    public String getTime(){
        DateFormat dateInstance = DateFormat.getDateInstance();
        return dateInstance.format(enddata);
    }
}
