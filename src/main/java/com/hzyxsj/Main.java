package com.hzyxsj;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/resources/detail.properties"));
        String img = properties.getProperty("img");
        String  filePath = properties.getProperty("file");
        new ImageToRGB2().imgToRgb2(img, filePath);
       // new ImageToRGB().imgToRgb(img, filePath);
        System.out.println("完成了图片解码");
        //new Read().readfile(filePath);
    }
}
