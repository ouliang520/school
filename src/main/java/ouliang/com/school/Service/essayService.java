package ouliang.com.school.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouliang.com.school.Dao.EssayDao;
import ouliang.com.school.pojo.Essay;
import ouliang.com.school.pojo.Video;
import ouliang.com.school.util.Path;

import java.util.List;


@Service
public class essayService {
    @Autowired
    EssayDao essayDao;

    public List<Essay> selectEssayTitle(){
        return essayDao.selectAll();
    }

    public List<Essay> selectIndex(){
        return essayDao.selectIndex();
    }



    public int addEssay(Essay essay){

        if ("0".equals(essay.getFlag())) {
            String text = essay.getText();
            String[] val = text.split("\r\n");
            text = "<p>";
            for (int i = 0; i < val.length; i++) {
                if (i == val.length - 1) {
                    text += val[i];
                    text += "</p>";
                    break;
                }
                text += val[i];
                text += "</p>\r\n<p>";
            }
            essay.setText(text);
        }
        int i=essayDao.addEssay(essay);
        return i;
    }

    public int addVideo(Video video) {
        String text=video.getText();
        String[] val = text.split("\r\n");
        text ="<p>";
        for (int i=0;i<val.length;i++){
            if (i==val.length-1){
                text+=val[i];
                text+="</p>";
                break;
            }
            text+=val[i];
            text+="</p>\r\n<p>";
        }
        video.setText(text);
        int i=essayDao.addVideo(video);
        return i;
    }

    public List<Video> selectVideo(int page) {
        return essayDao.selectVideoAll(page);
    }

    public Essay selectEssayById(int id) {
        return essayDao.selectEssayById(id);
    }

    public Video selectVideoById(int id) {
        return essayDao.selectVideoById(id);
    }


    public List<Essay> selectEssayByName(String TitleName, int page) {
        TitleName="%"+TitleName+"%";
        page = (page-1)*15;
        return essayDao.selectEssayByName(TitleName,page);
    }

    public int selectEssayByNameNum(String TitleName){
        TitleName="%"+TitleName+"%";
        return essayDao.selectEssayByNameNum(TitleName);
    }

    public List<Essay> selectVideoByName(String TitleName, int page) {
        TitleName="%"+TitleName+"%";
        page=(page-1)*15;
        return essayDao.selectVideoByName(TitleName,page);
    }

    public int selectVideoByNameNum(String TitleName) {
        TitleName="%"+TitleName+"%";
        return essayDao.selectVideoByNameNum(TitleName);
    }

    public int deleteEssay(int id){
        Essay essay= essayDao.selectEssayById(id);
        new Path().deleteFile(essay.getCover().replace("http://ouliang.icu/",""));
        essayDao.deleteEssay(id);
        return 1;
    }

    public int deleteVideo(int id){
        Video video= essayDao.selectVideoById(id);
        new Path().deleteFile("wen/"+video.getVideo());
        new Path().deleteFile(video.getCover().replace("http://ouliang.icu/",""));
        essayDao.deleteVideo(id);
        return 1;
    }

    public List<Essay> deleteList(){
        return essayDao.selectAll0();
    }


}
