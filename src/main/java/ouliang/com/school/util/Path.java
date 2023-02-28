package ouliang.com.school.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

public  class Path {
        public  String getJDK(){
            //linux下使用!!!!
            //获取jar包同级目录
            String path = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
            String[] pathSplit = path.split("/");
            String jarName1 = pathSplit[pathSplit.length - 1];
            String jarName2 = pathSplit[pathSplit.length - 2];
            String jarName3 = pathSplit[pathSplit.length - 3];
            int num=jarName1.length()+jarName2.length()+jarName3.length()+3;
            String Resultpath = path.substring(5,path.length()-num);
            return Resultpath;
        }


    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[6024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len;
        //使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

    public  void deleteFile(String str){
        File file = new File(new Path().getJDK()+str);
        file.delete();
    }
}
