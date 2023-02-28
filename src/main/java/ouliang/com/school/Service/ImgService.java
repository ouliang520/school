package ouliang.com.school.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ouliang.com.school.Dao.ImgDao;
import ouliang.com.school.pojo.Img;

import java.util.List;

@Service
public class ImgService {
    @Autowired
    ImgDao imgDao;
    public int Insert(String id,String title,String file){
        return imgDao.insertImg(id,title,file);
    }

    public List<Img> selectImg(){
        return imgDao.selectImg();
    }

    public String getImgFile(String id) {
        return imgDao.selectImg0(id);
    }
}
