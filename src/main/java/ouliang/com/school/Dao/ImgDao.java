package ouliang.com.school.Dao;

import org.apache.ibatis.annotations.Mapper;
import ouliang.com.school.pojo.Img;

import java.util.List;

@Mapper
public interface ImgDao {
    int insertImg(String id, String title,String file);
    List<Img> selectImg();

    String selectImg0(String id);
}
