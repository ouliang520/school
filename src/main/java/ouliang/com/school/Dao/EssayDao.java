package ouliang.com.school.Dao;

import org.apache.ibatis.annotations.Mapper;
import ouliang.com.school.pojo.Essay;
import ouliang.com.school.pojo.Video;

import java.util.List;

@Mapper
public interface EssayDao {

    int addEssay(Essay essay);

    List<Essay> selectAll();

    int addVideo(Video video);

    List<Video> selectVideoAll(int page);

    Essay selectEssayById(int id);

    Video selectVideoById(int id);

    List<Essay> selectEssayByName(String TitleName, int page);

    int selectEssayByNameNum(String TitleName);

    List<Essay> selectVideoByName(String TitleName, int page);

    int selectVideoByNameNum(String TitleName);

    List<Essay> selectIndex();

    int deleteEssay(int id);

    int deleteVideo(int id);

    List<Essay> selectAll0();
}
